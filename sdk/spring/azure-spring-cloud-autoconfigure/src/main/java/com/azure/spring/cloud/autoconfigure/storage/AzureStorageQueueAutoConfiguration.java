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
import com.azure.spring.identity.ClientBuilderCustomizer;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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

    private final AzureStorageProperties azureStorageProperties;

    public AzureStorageQueueAutoConfiguration(AzureStorageProperties azureStorageProperties) {
        this.azureStorageProperties = azureStorageProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public ConnectionStringClientBuilderCustomizer<QueueClientBuilder> queueConnectionStringClientBuilderCustomizer(
        AzureStorageProperties storageProperties,
        ObjectProvider<AzureEnvironment> azureEnvironmentProvider,
        ObjectProvider<StorageAccountManager> storageAccountManagerProvider) {
        ConnectionStringClientBuilderCustomizer<QueueClientBuilder> connectionStringCustomizer =
            (builder, callback) -> {
                StorageConnectionStringProvider provider = null;
                final String account = storageProperties.getAccount();
                StorageAccountManager storageAccountManager = storageAccountManagerProvider.getIfAvailable();
                if (storageAccountManager != null) {
                    provider = new StorageConnectionStringProvider(storageAccountManager.getOrCreate(account));
                } else {
                    final String accessKey = storageProperties.getAccessKey();
                    AzureEnvironment azureEnvironment = azureEnvironmentProvider.getIfAvailable();
                    if (azureEnvironment != null) {
                        provider = new StorageConnectionStringProvider(account, accessKey, azureEnvironment);
                    }
                }
                if (provider != null) {
                    builder.connectionString(provider.getConnectionString());
                    callback.skipCredential();
                }
            };
        return connectionStringCustomizer;
    }

    @Bean(STORAGE_QUEUE_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME)
    @ConditionalOnMissingBean
    public ChainedTokenCredential storageQueueChainedTokenCredential(TokenCredential defaultTokenCredential) {
        SpringMappingCredentialPropertiesProvider propertiesProvider = new SpringMappingCredentialPropertiesProvider(azureStorageProperties);
        final ChainedTokenCredentialBuilder chainedTokenCredentialBuilder = new ChainedTokenCredentialBuilder();
        chainedTokenCredentialBuilder.addLast(propertiesProvider.mappingTokenCredential())
                                     .addLast(defaultTokenCredential);
        return chainedTokenCredentialBuilder.build();
    }

    @Bean
    @ConditionalOnMissingBean
    public SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder> queueSharedKeyCredentialCustomizer(
        @Autowired(required = false) @Qualifier(STORAGE_QUEUE_SHARED_KEY_CREDENTIAL_BEAN_NAME) StorageSharedKeyCredential sharedKeyCredential) {
        if (sharedKeyCredential != null) {
            return (builder, callback) -> {
                builder.credential(sharedKeyCredential);
                callback.skipCredential();
            };
        }
        return null;
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenCredentialClientBuilderCustomizer<QueueClientBuilder> storageQueueTokenCredentialCustomizer(
        @Qualifier(STORAGE_QUEUE_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME) ChainedTokenCredential storageQueueChainedTokenCredential) {
        return builder -> builder.credential(storageQueueChainedTokenCredential);
    }

    @Bean
    @ConditionalOnMissingBean
    public ClientBuilderCustomizer<QueueClientBuilder> storageQueueClientBuilderCustomizers() {
        return builder -> builder.clientOptions(new ClientOptions().setApplicationId(AZURE_SPRING_STORAGE_QUEUE + VERSION));
    }

    /**
     * Storage Queue client builder configurer
     * @param clientBuilderCustomizers Customize queue client builder.
     * @param sharedKeyCredentialCustomizers Customize shared key credential
     * @param tokenCredentialCustomizers Customize token credential.
     * @return Cosmos client builder configurer
     */
    @Bean
    public StorageQueueClientBuilderConfigurer storageQueueClientBuilderConfigurer(
        ObjectProvider<ClientBuilderCustomizer<QueueClientBuilder>> clientBuilderCustomizers,
        ObjectProvider<SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder>> sharedKeyCredentialCustomizers,
        ObjectProvider<TokenCredentialClientBuilderCustomizer<QueueClientBuilder>> tokenCredentialCustomizers) {
        StorageQueueClientBuilderConfigurer configurer = new StorageQueueClientBuilderConfigurer();
        configurer.setClientBuilderCustomizer(clientBuilderCustomizers.orderedStream().findFirst().get());
        configurer.setShareKeyCredentialCustomizer(sharedKeyCredentialCustomizers.orderedStream().findFirst().orElse(null));
        configurer.setTokenCredentialCustomizer(tokenCredentialCustomizers.orderedStream().findFirst().get());
        return configurer;
    }

    /**
     * Create QueueClientBuilder
     * @param storageQueueClientBuilderConfigurer Configurer queue service client with all the customizer
     * @return Default QueueClientBuilder
     */
    @Bean
    @ConditionalOnMissingBean
    public QueueClientBuilder blobServiceClientBuilder(StorageQueueClientBuilderConfigurer storageQueueClientBuilderConfigurer) {
        QueueClientBuilder serviceClientBuilder = new QueueClientBuilder();
        return storageQueueClientBuilderConfigurer.configure(serviceClientBuilder);
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
