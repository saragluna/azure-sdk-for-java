// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs;

import com.azure.core.util.Context;

/** Samples for Locations CheckTrialAvailability. */
public final class LocationsCheckTrialAvailabilitySamples {
    /**
     * Sample code: Locations_CheckTrialAvailability.
     *
     * @param avsManager Entry point to AvsManager. Azure VMware Solution API.
     */
    public static void locationsCheckTrialAvailability(com.azure.resourcemanager.avs.AvsManager avsManager) {
        avsManager.locations().checkTrialAvailabilityWithResponse("eastus", Context.NONE);
    }
}
