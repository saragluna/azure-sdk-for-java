// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices;

import com.azure.core.util.Context;
import com.azure.resourcemanager.mediaservices.models.AssetContainerPermission;
import com.azure.resourcemanager.mediaservices.models.ListContainerSasInput;
import java.time.OffsetDateTime;

/** Samples for Assets ListContainerSas. */
public final class AssetsListContainerSasSamples {
    /**
     * Sample code: List Asset SAS URLs.
     *
     * @param mediaServicesManager Entry point to MediaServicesManager. This Swagger was generated by the API Framework.
     */
    public static void listAssetSASURLs(
        com.azure.resourcemanager.mediaservices.MediaServicesManager mediaServicesManager) {
        mediaServicesManager
            .assets()
            .listContainerSasWithResponse(
                "contoso",
                "contosomedia",
                "ClimbingMountBaker",
                new ListContainerSasInput()
                    .withPermissions(AssetContainerPermission.READ_WRITE)
                    .withExpiryTime(OffsetDateTime.parse("2018-01-01T10:00:00.007Z")),
                Context.NONE);
    }
}
