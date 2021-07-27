// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.storage;

import com.azure.spring.identity.AbstractClientBuilderConfigurer;
import com.azure.spring.identity.ClientBuilderCustomizer;
import com.azure.spring.identity.SharedKeyCredentialClientBuilderCustomizer;
import com.azure.storage.blob.BlobServiceClientBuilder;

/**
 * Configurer for extending Azure Storage Blob service client builder configuration.
 */
public class StorageBlobServiceClientBuilderConfigurer
    extends AbstractClientBuilderConfigurer<ClientBuilderCustomizer, BlobServiceClientBuilder> {

    private SharedKeyCredentialClientBuilderCustomizer shareKeyCredentialCustomizer;

    public SharedKeyCredentialClientBuilderCustomizer getShareKeyCredentialCustomizer() {
        return shareKeyCredentialCustomizer;
    }

    public void setShareKeyCredentialCustomizer(SharedKeyCredentialClientBuilderCustomizer shareKeyCredentialCustomizer) {
        this.shareKeyCredentialCustomizer = shareKeyCredentialCustomizer;
    }

    @Override
    public BlobServiceClientBuilder configure(BlobServiceClientBuilder builder) {
        configureClientBuilder(builder);
        shareKeyCredentialCustomizer.sharedKeyCredential(builder, new SkipCredentialCallback());
        configureTokenCredential(builder);
        return builder;
    }
}
