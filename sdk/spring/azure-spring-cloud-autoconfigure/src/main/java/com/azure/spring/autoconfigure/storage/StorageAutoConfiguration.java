// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.storage;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.spring.MappingCredentialPropertiesProvider;
import com.azure.spring.autoconfigure.storage.resource.AzureStorageProtocolResolver;
import com.azure.spring.autoconfigure.unity.identity.AzureDefaultTokenCredentialAutoConfiguration;
import com.azure.spring.identity.SpringEnvironmentCredential;
import com.azure.spring.identity.SpringEnvironmentCredentialBuilder;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.azure.storage.file.share.ShareServiceClientBuilder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

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

    private final SpringEnvironmentCredentialBuilder environmentCredentialBuilder;

    private final TokenCredential defaultTokenCredential;

    public StorageAutoConfiguration(SpringEnvironmentCredentialBuilder environmentCredentialBuilder,
                                    TokenCredential defaultTokenCredential) {
        this.environmentCredentialBuilder = environmentCredentialBuilder;
        this.defaultTokenCredential = defaultTokenCredential;
    }
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty("azure.storage.blob-endpoint")
    public BlobServiceClientBuilder blobServiceClientBuilder(
        StorageProperties storageProperties,
        ObjectProvider<MappingCredentialPropertiesProvider> mappingPropertiesProviders,
        ObjectProvider<TokenCredential> defaultTokenCredentials) {
        final String accountName = storageProperties.getAccountName();
        final String accountKey = storageProperties.getAccountKey();
        BlobServiceClientBuilder serviceClientBuilder = new BlobServiceClientBuilder()
            .endpoint(storageProperties.getBlobEndpoint())
            .httpLogOptions(new HttpLogOptions().setApplicationId(AZURE_SPRING_STORAGE_BLOB + VERSION));
        if (StringUtils.hasText(accountName)
            && StringUtils.hasText(accountKey)) {
            return serviceClientBuilder.credential(new StorageSharedKeyCredential(accountName, accountKey));
        }

        MappingCredentialPropertiesProvider propertiesProvider = mappingPropertiesProviders.orderedStream()
                                                                                           .findFirst()
                                                                                           .orElse(null);
        if (propertiesProvider != null) {
            return serviceClientBuilder.credential(propertiesProvider.mappingTokenCredential());
        }

        TokenCredential defaultTokenCredential = defaultTokenCredentials.orderedStream().findFirst().orElse(null);
        if (defaultTokenCredential != null) {
            return serviceClientBuilder.credential(defaultTokenCredential);
        }

        throw new IllegalStateException("Not found any credential properties configured.");
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
