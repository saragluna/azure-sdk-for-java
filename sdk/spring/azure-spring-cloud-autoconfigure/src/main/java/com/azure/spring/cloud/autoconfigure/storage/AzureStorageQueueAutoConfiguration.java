// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.storage;

import com.azure.core.credential.TokenCredential;
import com.azure.core.management.AzureEnvironment;
import com.azure.spring.MappingCredentialPropertiesProvider;
import com.azure.spring.cloud.autoconfigure.context.AzureResourceManagerAutoConfiguration;
import com.azure.spring.cloud.context.core.impl.StorageAccountManager;
import com.azure.spring.cloud.context.core.storage.StorageConnectionStringProvider;
import com.azure.spring.integration.storage.queue.StorageQueueOperation;
import com.azure.spring.integration.storage.queue.StorageQueueTemplate;
import com.azure.spring.integration.storage.queue.QueueClientBuilderCustomizer;
import com.azure.spring.integration.storage.queue.factory.DefaultStorageQueueClientFactory;
import com.azure.spring.integration.storage.queue.factory.StorageQueueClientFactory;
import com.azure.storage.queue.QueueClientBuilder;
import com.azure.storage.queue.QueueServiceClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

/**
 * Auto-configuration class for Azure Storage Queue.
 */
@Configuration
@AutoConfigureAfter({ AzureResourceManagerAutoConfiguration.class})
@ConditionalOnClass(QueueServiceClient.class)
@EnableConfigurationProperties(AzureStorageProperties.class)
public class AzureStorageQueueAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "spring.cloud.azure.storage.account")
    public StorageConnectionStringProvider storageConnectionStringProvider(
        AzureStorageProperties storageProperties,
        ObjectProvider<AzureEnvironment> azureEnvironmentProvider,
        ObjectProvider<StorageAccountManager> storageAccountManagerProvider
    ) {
        final String account = storageProperties.getAccount();
        StorageAccountManager storageAccountManager = storageAccountManagerProvider.getIfAvailable();
        if (storageAccountManager != null) {
            return new StorageConnectionStringProvider(storageAccountManager.getOrCreate(account));
        } else {
            final String accessKey = storageProperties.getAccessKey();
            AzureEnvironment azureEnvironment = azureEnvironmentProvider.getIfAvailable();
            if (azureEnvironment != null) {
                return new StorageConnectionStringProvider(account, accessKey, azureEnvironment);
            }
        }

        return null;
    }

    @Bean
    @ConditionalOnBean(StorageConnectionStringProvider.class)
    public QueueClientBuilderCustomizer queueClientBuilderCustomizer(
        ObjectProvider<StorageConnectionStringProvider> storageConnectionStringProviders,
        ObjectProvider<MappingCredentialPropertiesProvider> mappingPropertiesProviders,
        ObjectProvider<TokenCredential> defaultTokenCredentials) {
        return new DefaultQueueClientBuilderCustomizer(
            storageConnectionStringProviders.orderedStream().findFirst().orElse(null),
            mappingPropertiesProviders.orderedStream().findFirst().orElse(null),
            defaultTokenCredentials.orderedStream().findFirst().orElse(null));
    }

    @Bean
    @ConditionalOnMissingBean
    public QueueClientBuilderConfigurer queueClientBuilderConfigurer(
        ObjectProvider<QueueClientBuilderCustomizer> queueClientBuilderCustomizers) {
        QueueClientBuilderConfigurer configurer = new QueueClientBuilderConfigurer();
        configurer.setQueueClientBuilderCustomizerList(
            queueClientBuilderCustomizers.orderedStream().collect(Collectors.toList()));
        return configurer;
    }

    @Bean
    @ConditionalOnMissingBean
    public QueueClientBuilder queueClientBuilder(AzureStorageProperties storageProperties,
                                                 QueueClientBuilderConfigurer queueClientBuilderConfigurer) {
        return queueClientBuilderConfigurer.configure(new QueueClientBuilder());
    }

    @Bean
    @ConditionalOnMissingBean
    StorageQueueClientFactory storageQueueClientFactory(QueueClientBuilder queueClientBuilder) {
        return new DefaultStorageQueueClientFactory(queueClientBuilder);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(StorageQueueClientFactory.class)
    StorageQueueOperation storageQueueOperation(StorageQueueClientFactory storageQueueClientFactory) {
        return new StorageQueueTemplate(storageQueueClientFactory);
    }
}
