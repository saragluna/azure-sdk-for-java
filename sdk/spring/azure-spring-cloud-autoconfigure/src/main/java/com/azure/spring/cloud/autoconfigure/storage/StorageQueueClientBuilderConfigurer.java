// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.storage;

import com.azure.spring.identity.AbstractClientBuilderConfigurer;
import com.azure.spring.identity.ClientBuilderCustomizer;
import com.azure.spring.identity.ConnectionStringClientBuilderCustomizer;
import com.azure.spring.identity.SharedKeyCredentialClientBuilderCustomizer;
import com.azure.spring.identity.DefaultSkipCredentialCallback;
import com.azure.storage.queue.QueueClientBuilder;

/**
 * Configurer for extending Azure Storage Queue service client builder configuration.
 */
public class StorageQueueClientBuilderConfigurer
    extends AbstractClientBuilderConfigurer<ClientBuilderCustomizer<QueueClientBuilder>, QueueClientBuilder> {

    private ConnectionStringClientBuilderCustomizer<QueueClientBuilder> connectionStringClientBuilderCustomizer;
    private SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder> shareKeyCredentialCustomizer;

    public StorageQueueClientBuilderConfigurer() {
        this.connectionStringClientBuilderCustomizer = null;
        this.shareKeyCredentialCustomizer = null;
    }

    public void setShareKeyCredentialCustomizer(SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder> shareKeyCredentialCustomizer) {
        this.shareKeyCredentialCustomizer = shareKeyCredentialCustomizer;
    }

    public void setConnectionStringClientBuilderCustomizer(ConnectionStringClientBuilderCustomizer<QueueClientBuilder> connectionStringClientBuilderCustomizer) {
        this.connectionStringClientBuilderCustomizer = connectionStringClientBuilderCustomizer;
    }

    @Override
    public QueueClientBuilder configure(QueueClientBuilder builder) {
        DefaultSkipCredentialCallback<StorageQueueClientBuilderConfigurer> credentialCallback = new DefaultSkipCredentialCallback<>(this);
        if (connectionStringClientBuilderCustomizer != null) {
            connectionStringClientBuilderCustomizer.connectionString(builder, credentialCallback);
        }
        if (!credentialCallback.isSkipCredential() && shareKeyCredentialCustomizer != null) {
            shareKeyCredentialCustomizer.sharedKeyCredential(builder, credentialCallback);
        }
        configureTokenCredential(builder);
        return builder;
    }
}
