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
public class StorageQueueClientBuilderConfigurer extends AbstractClientBuilderConfigurer<ClientBuilderCustomizer, QueueClientBuilder> {

    private SharedKeyCredentialClientBuilderCustomizer shareKeyCredentialCustomizer;

    private ConnectionStringClientBuilderCustomizer connectionStringClientBuilderCustomizer;

    public SharedKeyCredentialClientBuilderCustomizer getShareKeyCredentialCustomizer() {
        return shareKeyCredentialCustomizer;
    }

    public void setShareKeyCredentialCustomizer(SharedKeyCredentialClientBuilderCustomizer shareKeyCredentialCustomizer) {
        this.shareKeyCredentialCustomizer = shareKeyCredentialCustomizer;
    }

    public ConnectionStringClientBuilderCustomizer getConnectionStringClientBuilderCustomizer() {
        return connectionStringClientBuilderCustomizer;
    }

    public void setConnectionStringClientBuilderCustomizer(ConnectionStringClientBuilderCustomizer connectionStringClientBuilderCustomizer) {
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
