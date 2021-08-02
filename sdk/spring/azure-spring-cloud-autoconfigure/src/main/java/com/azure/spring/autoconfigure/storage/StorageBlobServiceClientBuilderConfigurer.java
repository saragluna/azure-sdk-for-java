// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.storage;

import com.azure.spring.identity.AbstractClientBuilderConfigurer;
import com.azure.spring.identity.SharedKeyCredentialClientBuilderCustomizer;
import com.azure.storage.blob.BlobServiceClientBuilder;

/**
 * Configurer for extending Azure Storage Blob service client builder configuration.
 */
public class StorageBlobServiceClientBuilderConfigurer extends AbstractClientBuilderConfigurer<BlobServiceClientBuilder> {

    private SharedKeyCredentialClientBuilderCustomizer<BlobServiceClientBuilder> shareKeyCredentialCustomizer;

    public StorageBlobServiceClientBuilderConfigurer() {
        super();
        this.shareKeyCredentialCustomizer = null;
    }

    public void setShareKeyCredentialCustomizer(SharedKeyCredentialClientBuilderCustomizer<BlobServiceClientBuilder> shareKeyCredentialCustomizer) {
        this.shareKeyCredentialCustomizer = shareKeyCredentialCustomizer;
    }

    @Override
    public BlobServiceClientBuilder configure(BlobServiceClientBuilder builder) {
        super.configure(builder);
        if (shareKeyCredentialCustomizer != null) {
            shareKeyCredentialCustomizer.sharedKeyCredential(builder);
        }
        return builder;
    }
}
