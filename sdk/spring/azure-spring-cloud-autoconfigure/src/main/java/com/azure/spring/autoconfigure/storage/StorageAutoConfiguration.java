// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.storage;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.util.ClientOptions;
import com.azure.identity.ChainedTokenCredential;
import com.azure.identity.ChainedTokenCredentialBuilder;
import com.azure.spring.SpringMappingCredentialPropertiesProvider;
import com.azure.spring.autoconfigure.storage.resource.AzureStorageProtocolResolver;
import com.azure.spring.autoconfigure.unity.identity.AzureDefaultTokenCredentialAutoConfiguration;
import com.azure.spring.identity.ClientBuilderCustomizer;
import com.azure.spring.identity.SharedKeyCredentialClientBuilderCustomizer;
import com.azure.spring.identity.TokenCredentialClientBuilderCustomizer;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.azure.storage.file.share.ShareServiceClientBuilder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static com.azure.spring.core.ApplicationId.AZURE_SPRING_STORAGE_BLOB;
import static com.azure.spring.core.ApplicationId.AZURE_SPRING_STORAGE_FILES;
import static com.azure.spring.core.ApplicationId.VERSION;

/**
 * An auto-configuration for Azure Storage Account
 *
 * @author Warren Zhu
 */
@Configuration
@ConditionalOnClass({ BlobServiceClientBuilder.class, ShareServiceClientBuilder.class })
@ConditionalOnResource(resources = "classpath:storage.enable.config")
@EnableConfigurationProperties(StorageProperties.class)
@AutoConfigureAfter(AzureDefaultTokenCredentialAutoConfiguration.class)
public class StorageAutoConfiguration {

    private final StorageProperties storageProperties;
    private final static String STORAGE_BLOB_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME = "storageBlobChainedTokenCredential";
    private final static String STORAGE_BLOB_SHARED_KEY_CREDENTIAL_BEAN_NAME = "storageBlobSharedKeyCredential";

    public StorageAutoConfiguration(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public SharedKeyCredentialClientBuilderCustomizer<BlobServiceClientBuilder> blobShareKeyCredentialCustomizer(
        @Autowired(required = false) @Qualifier(STORAGE_BLOB_SHARED_KEY_CREDENTIAL_BEAN_NAME) StorageSharedKeyCredential sharedKeyCredential) {
        if (sharedKeyCredential != null) {
            return (builder, callback) -> {
                callback.skipCredential();
                builder.credential(sharedKeyCredential);
            };
        }
        return null;
    }

    @Bean(STORAGE_BLOB_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME)
    @ConditionalOnMissingBean
    public ChainedTokenCredential storageBlobChainedTokenCredential(StorageProperties storageProperties,
                                                                TokenCredential defaultTokenCredential) {
        SpringMappingCredentialPropertiesProvider propertiesProvider = new SpringMappingCredentialPropertiesProvider(storageProperties);
        final ChainedTokenCredentialBuilder chainedTokenCredentialBuilder = new ChainedTokenCredentialBuilder();
        chainedTokenCredentialBuilder.addLast(propertiesProvider.mappingTokenCredential())
                                     .addLast(defaultTokenCredential);
        return chainedTokenCredentialBuilder.build();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClientBuilderCustomizer<BlobServiceClientBuilder> storageBlobClientBuilderCustomizers() {
        ClientBuilderCustomizer<BlobServiceClientBuilder> clientBuilderCustomizer = builder -> {
            builder.endpoint(storageProperties.getBlobEndpoint())
                   .clientOptions(new ClientOptions().setApplicationId(AZURE_SPRING_STORAGE_BLOB + VERSION));
        };
        return clientBuilderCustomizer;
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenCredentialClientBuilderCustomizer<BlobServiceClientBuilder> storageBlobTokenCredentialCustomizer(
        @Qualifier(STORAGE_BLOB_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME) ChainedTokenCredential storageBlobChainedTokenCredential) {
        return builder -> builder.credential(storageBlobChainedTokenCredential);
    }

    /**
     * Storage Blob client builder configurer
     * @param storageBlobClientBuilderCustomizers Customize cosmos client builder.
     * @param storageBlobClientBuilderCustomizers Customize shared key credential
     * @param tokenCredentialCustomizers Customize token credential.
     * @return Cosmos client builder configurer
     */
    @Bean
    public StorageBlobServiceClientBuilderConfigurer storageBlobClientBuilderConfigurer(
        ObjectProvider<ClientBuilderCustomizer<BlobServiceClientBuilder>> storageBlobClientBuilderCustomizers,
        ObjectProvider<SharedKeyCredentialClientBuilderCustomizer<BlobServiceClientBuilder>> sharedKeyCredentialCustomizers,
        ObjectProvider<TokenCredentialClientBuilderCustomizer<BlobServiceClientBuilder>> tokenCredentialCustomizers) {
        StorageBlobServiceClientBuilderConfigurer configurer = new StorageBlobServiceClientBuilderConfigurer();
        configurer.setClientBuilderCustomizer(storageBlobClientBuilderCustomizers.orderedStream().findFirst().get());
        configurer.setShareKeyCredentialCustomizer(sharedKeyCredentialCustomizers.orderedStream().findFirst().orElse(null));
        configurer.setTokenCredentialCustomizer(tokenCredentialCustomizers.orderedStream().findFirst().get());
        return configurer;
    }

    /**
     * Create BlobServiceClientBuilder
     * @param storageBlobClientBuilderConfigurer Configurer blob service cleint with all the customizer
     * @return Default BlobServiceClientBuilder
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty("azure.storage.blob-endpoint")
    public BlobServiceClientBuilder blobServiceClientBuilder(
        StorageBlobServiceClientBuilderConfigurer storageBlobClientBuilderConfigurer) {
        BlobServiceClientBuilder serviceClientBuilder = new BlobServiceClientBuilder();
        return storageBlobClientBuilderConfigurer.configure(serviceClientBuilder);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty("azure.storage.file-endpoint")
    public ShareServiceClientBuilder shareServiceClientBuilder(StorageProperties storageProperties) {
        final String accountName = storageProperties.getAccountName();
        final String accountKey = storageProperties.getAccountKey();

        return new ShareServiceClientBuilder()
            .endpoint(storageProperties.getFileEndpoint())
            .credential(new StorageSharedKeyCredential(accountName, accountKey))
            .httpLogOptions(new HttpLogOptions().setApplicationId(AZURE_SPRING_STORAGE_FILES + VERSION));
    }

    @Configuration
    @ConditionalOnClass(AzureStorageProtocolResolver.class)
    @Import(AzureStorageProtocolResolver.class)
    static class StorageResourceConfiguration {
    }
}
