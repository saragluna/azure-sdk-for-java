// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.storage;

import com.azure.spring.identity.AbstractClientBuilderConfigurer;
import com.azure.spring.identity.ClientBuilderCustomizer;
import com.azure.spring.identity.ConnectionStringClientBuilderCustomizer;
import com.azure.spring.identity.SharedKeyCredentialClientBuilderCustomizer;
import com.azure.storage.queue.QueueClientBuilder;

/**
 * Configurer for extending Azure Storage Queue service client builder configuration.
 */
public class StorageQueueClientBuilderConfigurer
    extends AbstractClientBuilderConfigurer<ClientBuilderCustomizer<QueueClientBuilder>, QueueClientBuilder> {

    private SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder> shareKeyCredentialCustomizer;

    private ConnectionStringClientBuilderCustomizer<QueueClientBuilder> connectionStringClientBuilderCustomizer;

    public StorageQueueClientBuilderConfigurer() {
        this.connectionStringClientBuilderCustomizer = null;
        this.shareKeyCredentialCustomizer = null;
    }

    public SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder> getShareKeyCredentialCustomizer() {
        return shareKeyCredentialCustomizer;
    }

    public void setShareKeyCredentialCustomizer(SharedKeyCredentialClientBuilderCustomizer<QueueClientBuilder> shareKeyCredentialCustomizer) {
        this.shareKeyCredentialCustomizer = shareKeyCredentialCustomizer;
    }

    public ConnectionStringClientBuilderCustomizer<QueueClientBuilder> getConnectionStringClientBuilderCustomizer() {
        return connectionStringClientBuilderCustomizer;
    }

    public void setConnectionStringClientBuilderCustomizer(ConnectionStringClientBuilderCustomizer<QueueClientBuilder> connectionStringClientBuilderCustomizer) {
        this.connectionStringClientBuilderCustomizer = connectionStringClientBuilderCustomizer;
    }

    @Override
    public QueueClientBuilder configure(QueueClientBuilder builder) {
        SkipCredentialCallback credentialCallback = new SkipCredentialCallback();
        connectionStringClientBuilderCustomizer.connectionString(builder, credentialCallback);
        if (!credentialCallback.isSkipCredential()) {
            shareKeyCredentialCustomizer.sharedKeyCredential(builder, credentialCallback);
            configureTokenCredential(builder);
        }
        return builder;
    }
}
