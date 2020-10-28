/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_11_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import com.microsoft.azure.arm.resources.collection.SupportsDeletingByResourceGroup;
import com.microsoft.azure.arm.resources.collection.SupportsBatchDeletion;
import com.microsoft.azure.arm.resources.collection.SupportsGettingByResourceGroup;
import rx.Observable;
import com.microsoft.azure.arm.resources.collection.SupportsListingByResourceGroup;
import com.microsoft.azure.arm.collection.SupportsListing;
import com.microsoft.azure.management.network.v2018_11_01.implementation.P2sVpnGatewaysInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing P2sVpnGateways.
 */
public interface P2sVpnGateways extends SupportsCreating<P2SVpnGateway.DefinitionStages.Blank>, SupportsDeletingByResourceGroup, SupportsBatchDeletion, SupportsGettingByResourceGroup<P2SVpnGateway>, SupportsListingByResourceGroup<P2SVpnGateway>, SupportsListing<P2SVpnGateway>, HasInner<P2sVpnGatewaysInner> {
    /**
     * Generates VPN profile for P2S client of the P2SVpnGateway in the specified resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param gatewayName The name of the P2SVpnGateway.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<VpnProfileResponse> generateVpnProfileAsync(String resourceGroupName, String gatewayName);

}
