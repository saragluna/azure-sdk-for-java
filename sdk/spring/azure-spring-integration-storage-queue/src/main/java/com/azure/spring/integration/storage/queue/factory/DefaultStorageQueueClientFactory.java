// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.integration.storage.queue.factory;

import com.azure.spring.core.util.Memoizer;
import com.azure.storage.queue.QueueAsyncClient;
import com.azure.storage.queue.QueueClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import java.util.function.Function;

/**
 * Default client factory for Storage Queue.
 */
public class DefaultStorageQueueClientFactory implements StorageQueueClientFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultStorageQueueClientFactory.class);
    private final QueueClientBuilder queueClientBuilder;
    private final Function<String, QueueAsyncClient> queueClientCreator = Memoizer.memoize(this::createQueueClient);

    public DefaultStorageQueueClientFactory(@NonNull QueueClientBuilder queueClientBuilder) {
        this.queueClientBuilder = queueClientBuilder;
    }

    @Override
    public QueueAsyncClient getOrCreateQueueClient(String queueName) {
        return this.queueClientCreator.apply(queueName);
    }

    private QueueAsyncClient createQueueClient(String queueName) {
        queueClientBuilder.queueName(queueName);
        final QueueAsyncClient queueClient = queueClientBuilder.buildAsyncClient();
        // TODO (xiada): when used with connection string, this call will throw exception
        // TODO (xiada): https://github.com/Azure/azure-sdk-for-java/issues/15008
        queueClient.create().subscribe(
            response -> {
            },
            e -> LOGGER.error("Fail to create the queue.", e),
            () -> LOGGER.info("Complete creating the queue!")
        );

        return queueClient;
    }

}
