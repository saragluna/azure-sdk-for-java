// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.context.core.storage;

import com.azure.core.management.AzureEnvironment;
import com.azure.resourcemanager.resources.fluentcore.utils.ResourceManagerUtils;
import com.azure.resourcemanager.storage.models.StorageAccount;
import org.springframework.core.Ordered;

/**
 * A provider that holds the storage account connection string.
 */
public class StorageConnectionStringProvider implements Ordered {

    private final String connectionString;

    public StorageConnectionStringProvider(StorageAccount storageAccount) {
        this.connectionString = buildConnectionString(storageAccount);
    }

    public StorageConnectionStringProvider(String accountName, String accountKey, AzureEnvironment environment) {
        this.connectionString = ResourceManagerUtils.getStorageConnectionString(accountName, accountKey, environment);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    private static String buildConnectionString(StorageAccount storageAccount) {
        return storageAccount.getKeys()
                             .stream()
                             .findFirst()
                             .map(key -> ResourceManagerUtils.getStorageConnectionString(storageAccount.name(),
                                 key.value(),
                                 storageAccount.manager().environment()))
                             .orElseThrow(() -> new RuntimeException("Storage account key is empty."));
    }

    public String getConnectionString() {
        return connectionString;
    }
}
