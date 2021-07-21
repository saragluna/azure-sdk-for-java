// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices;

import com.azure.core.util.Context;

/** Samples for PrivateEndpointConnections List. */
public final class PrivateEndpointConnectionsListSamples {
    /**
     * Sample code: Get all private endpoint connections.
     *
     * @param mediaServicesManager Entry point to MediaServicesManager. This Swagger was generated by the API Framework.
     */
    public static void getAllPrivateEndpointConnections(
        com.azure.resourcemanager.mediaservices.MediaServicesManager mediaServicesManager) {
        mediaServicesManager.privateEndpointConnections().listWithResponse("contoso", "contososports", Context.NONE);
    }
}
