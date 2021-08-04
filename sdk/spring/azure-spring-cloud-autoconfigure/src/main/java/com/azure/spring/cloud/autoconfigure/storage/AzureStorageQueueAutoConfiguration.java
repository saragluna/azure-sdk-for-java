// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.storage;

import com.azure.core.credential.TokenCredential;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.util.ClientOptions;
import com.azure.identity.ChainedTokenCredential;
import com.azure.identity.ChainedTokenCredentialBuilder;
import com.azure.spring.SpringMappingCredentialPropertiesProvider;
import com.azure.spring.cloud.autoconfigure.context.AzureResourceManagerAutoConfiguration;
import com.azure.spring.cloud.context.core.impl.StorageAccountManager;
import com.azure.spring.cloud.context.core.storage.StorageConnectionStringProvider;
import com.azure.spring.identity.ConnectionStringClientBuilderCustomizer;
import com.azure.spring.identity.SharedKeyCredentialClientBuilderCustomizer;
import com.azure.spring.identity.TokenCredentialClientBuilderCustomizer;
import com.azure.spring.integration.storage.queue.StorageQueueOperation;
import com.azure.spring.integration.storage.queue.StorageQueueTemplate;
import com.azure.spring.integration.storage.queue.factory.DefaultStorageQueueClientFactory;
import com.azure.spring.integration.storage.queue.factory.StorageQueueClientFactory;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.azure.storage.queue.QueueClientBuilder;
import com.azure.storage.queue.QueueServiceClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.azure.spring.core.ApplicationId.AZURE_SPRING_STORAGE_QUEUE;
import static com.azure.spring.core.ApplicationId.VERSION;

/**
 * Auto-configuration class for Azure Storage Queue.
 */
@Configuration
@AutoConfigureAfter({ AzureResourceManagerAutoConfiguration.class})
@ConditionalOnClass(QueueServiceClient.class)
@EnableConfigurationProperties(AzureStorageProperties.class)
public class AzureStorageQueueAutoConfiguration {

    private static final String STORAGE_QUEUE_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME = "storageQueueChainedTokenCredential";
    private static final String STORAGE_QUEUE_SHARED_KEY_CREDENTIAL_BEAN_NAME = "storageQueueSharedKeyCredential";
    private static final String STORAGE_QUEUE_ENDPOINT_PATTERN = "https://%s.queue.core.windows.net/";
    private final AzureStorageProperties properties;

    public AzureStorageQueueAutoConfiguration(AzureStorageProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty({"spring.cloud.azure.storage.access-key", "spring.cloud.azure.storage.account"})
    public ConnectionStringClientBuilderCustomizer<QueueClientBuilder> queueConnectionStringClientBuilderCustomizer(
        AzureStorageProperties storageProperties,
        ObjectProvider<AzureEnvironment> azureEnvironmentProvider,
        ObjectProvider<StorageAccountManager> storageAccountManagerProvider) {
        return builder -> {
            StorageConnectionStringProvider provider;
            String account = storageProperties.getAccount();
            StorageAccountManager storageAccountManager = storageAccountManagerProvider.getIfAvailable();
            if (storageAccountManager != null) {
                provider = new StorageConnectionStringProvider(storageAccountManager.getOrCreate(account));
            } else {
                final String accessKey = storageProperties.getAccessKey();
                AzureEnvironment azureEnvironment = azureEnvironmentProvider.getIfAvailable(()-> AzureEnvironment.AZURE);
                provider = new StorageConnectionStringProvider(account, accessKey, azureEnvironment);
            }
            builder.connectionString(provider.getConnectionString());
        };
    }

    @Bean(STORAGE_QUEUE_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME)
    @ConditionalOnMissingBean(name = STORAGE_QUEUE_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME)
    public ChainedTokenCredential storageQueueChainedTokenCredential(TokenCredential defaultTokenCredential) {
        SpringMappingCredentialPropertiesProvider propertiesProvider = new SpringMappingCredentialPropertiesProvider(properties);
        final ChainedTokenCredentialBuilder chainedTokenCredentialBuilder = new ChainedTokenCredentialBuilder();
        chainedTokenCredentialBuilder.addLast(propertiesProvider.mappingTokenCredential())
                                     .addLast(defaultTokenCredential);
        return chainedTokenCredentialBuilder.build();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(name = STORAGE_QUEUE_SHARED_KEY_CREDENTIAL_BEAN_NAME)
    public SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder> queueSharedKeyCredentialCustomizer(
        StorageSharedKeyCredential sharedKeyCredential) {
        return builder -> builder.credential(sharedKeyCredential);
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenCredentialClientBuilderCustomizer<QueueClientBuilder> storageQueueTokenCredentialCustomizer(
        @Qualifier(STORAGE_QUEUE_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME) ChainedTokenCredential storageQueueChainedTokenCredential) {
        return builder -> builder.credential(storageQueueChainedTokenCredential);
    }

    /**
     * Storage Queue client builder configurer
     * @param connectionStringClientBuilderCustomizers Customize the connection string client builder
     * @param sharedKeyCredentialCustomizers Customize shared key credential
     * @param tokenCredentialCustomizers Customize token credential.
     * @return Cosmos client builder configurer
     */
    @Bean
    @ConditionalOnMissingBean
    public StorageQueueClientBuilderConfigurer storageQueueClientBuilderConfigurer(
        ObjectProvider<ConnectionStringClientBuilderCustomizer<QueueClientBuilder>> connectionStringClientBuilderCustomizers,
        ObjectProvider<SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder>> sharedKeyCredentialCustomizers,
        ObjectProvider<TokenCredentialClientBuilderCustomizer<QueueClientBuilder>> tokenCredentialCustomizers) {
        StorageQueueClientBuilderConfigurer configurer = new StorageQueueClientBuilderConfigurer();
        configurer.setConnectionStringClientBuilderCustomizer(connectionStringClientBuilderCustomizers.orderedStream().findFirst().orElse(null));
        configurer.setShareKeyCredentialCustomizer(sharedKeyCredentialCustomizers.orderedStream().findFirst().orElse(null));
        configurer.setTokenCredentialCustomizer(tokenCredentialCustomizers.orderedStream().findFirst().orElse(null));
        return configurer;
    }

    /**
     * Create QueueClientBuilder
     * @param storageQueueClientBuilderConfigurer Configurer queue service client with all the customizer
     * @return Default QueueClientBuilder
     */
    @Bean
    @ConditionalOnMissingBean
    public QueueClientBuilder queueServiceClientBuilder(StorageQueueClientBuilderConfigurer storageQueueClientBuilderConfigurer) {
        QueueClientBuilder builder = new QueueClientBuilder();
        builder.endpoint(String.format(STORAGE_QUEUE_ENDPOINT_PATTERN, properties.getAccount()))
               .clientOptions(new ClientOptions().setApplicationId(AZURE_SPRING_STORAGE_QUEUE + VERSION));
        return storageQueueClientBuilderConfigurer.configure(builder);
    }

    @Bean
    @ConditionalOnMissingBean
    public StorageQueueClientFactory storageQueueClientFactory(QueueClientBuilder queueClientBuilder) {
        return new DefaultStorageQueueClientFactory(queueClientBuilder);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(StorageQueueClientFactory.class)
    public StorageQueueOperation storageQueueOperation(StorageQueueClientFactory storageQueueClientFactory) {
        return new StorageQueueTemplate(storageQueueClientFactory);
    }
}
