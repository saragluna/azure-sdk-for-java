// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security;

import com.azure.core.util.Context;

/** Samples for IngestionSettings ListConnectionStrings. */
public final class IngestionSettingsListConnectionStringsSamples {
    /**
     * Sample code: List connection strings for ingesting security data and logs.
     *
     * @param securityManager Entry point to SecurityManager. API spec for Microsoft.Security (Azure Security Center)
     *     resource provider.
     */
    public static void listConnectionStringsForIngestingSecurityDataAndLogs(
        com.azure.resourcemanager.security.SecurityManager securityManager) {
        securityManager.ingestionSettings().listConnectionStringsWithResponse("default", Context.NONE);
    }
}
