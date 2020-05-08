/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_04_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SKU of nat gateway.
 */
public class NatGatewaySku {
    /**
     * Name of Nat Gateway SKU. Possible values include: 'Standard'.
     */
    @JsonProperty(value = "name")
    private NatGatewaySkuName name;

    /**
     * Get name of Nat Gateway SKU. Possible values include: 'Standard'.
     *
     * @return the name value
     */
    public NatGatewaySkuName name() {
        return this.name;
    }

    /**
     * Set name of Nat Gateway SKU. Possible values include: 'Standard'.
     *
     * @param name the name value to set
     * @return the NatGatewaySku object itself.
     */
    public NatGatewaySku withName(NatGatewaySkuName name) {
        this.name = name;
        return this;
    }

}
