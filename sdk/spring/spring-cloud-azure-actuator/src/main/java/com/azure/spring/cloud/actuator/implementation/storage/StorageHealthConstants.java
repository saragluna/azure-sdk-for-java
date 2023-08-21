// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.actuator.implementation.storage;

import org.springframework.boot.actuate.health.Status;

/**
 * Azure Storage actuator related constants.
 */
public final class StorageHealthConstants {

    private StorageHealthConstants() {
    }

    public static final String URL_FIELD = "URL";

    public static final String NOT_EXISTING_CONTAINER = "spring-cloud-azure-not-existing-container";

    public static final Status NOT_CONFIGURED_STATUS = new Status("Not configured");
}
