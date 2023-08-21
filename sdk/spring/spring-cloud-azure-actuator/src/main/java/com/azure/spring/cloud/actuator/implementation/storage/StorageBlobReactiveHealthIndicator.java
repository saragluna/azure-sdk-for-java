// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.actuator.implementation.storage;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import org.springframework.boot.actuate.health.AbstractReactiveHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import reactor.core.publisher.Mono;

import static com.azure.spring.cloud.actuator.implementation.storage.StorageHealthConstants.NOT_CONFIGURED_STATUS;
import static com.azure.spring.cloud.actuator.implementation.storage.StorageHealthConstants.NOT_EXISTING_CONTAINER;
import static com.azure.spring.cloud.actuator.implementation.storage.StorageHealthConstants.URL_FIELD;

public class StorageBlobReactiveHealthIndicator extends AbstractReactiveHealthIndicator {

    private final BlobServiceAsyncClient blobServiceAsyncClient;

    public StorageBlobReactiveHealthIndicator(BlobServiceAsyncClient blobServiceAsyncClient) {
        this.blobServiceAsyncClient = blobServiceAsyncClient;
    }

    @Override
    protected Mono<Health> doHealthCheck(Health.Builder builder) {
        if (blobServiceAsyncClient == null) {
            builder.status(NOT_CONFIGURED_STATUS);
            return Mono.just(builder.build());
        }

        BlobContainerAsyncClient containerAsyncClient = blobServiceAsyncClient.getBlobContainerAsyncClient(
            NOT_EXISTING_CONTAINER);
        return containerAsyncClient.existsWithResponse().map(response -> builder
            .up()
            .withDetail(URL_FIELD, blobServiceAsyncClient.getAccountUrl())
            .build());
    }
}
