/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_11_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for VirtualNetworkGatewaySkuName.
 */
public final class VirtualNetworkGatewaySkuName extends ExpandableStringEnum<VirtualNetworkGatewaySkuName> {
    /** Static value Basic for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName BASIC = fromString("Basic");

    /** Static value HighPerformance for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName HIGH_PERFORMANCE = fromString("HighPerformance");

    /** Static value Standard for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName STANDARD = fromString("Standard");

    /** Static value UltraPerformance for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName ULTRA_PERFORMANCE = fromString("UltraPerformance");

    /** Static value VpnGw1 for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName VPN_GW1 = fromString("VpnGw1");

    /** Static value VpnGw2 for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName VPN_GW2 = fromString("VpnGw2");

    /** Static value VpnGw3 for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName VPN_GW3 = fromString("VpnGw3");

    /** Static value VpnGw1AZ for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName VPN_GW1AZ = fromString("VpnGw1AZ");

    /** Static value VpnGw2AZ for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName VPN_GW2AZ = fromString("VpnGw2AZ");

    /** Static value VpnGw3AZ for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName VPN_GW3AZ = fromString("VpnGw3AZ");

    /** Static value ErGw1AZ for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName ER_GW1AZ = fromString("ErGw1AZ");

    /** Static value ErGw2AZ for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName ER_GW2AZ = fromString("ErGw2AZ");

    /** Static value ErGw3AZ for VirtualNetworkGatewaySkuName. */
    public static final VirtualNetworkGatewaySkuName ER_GW3AZ = fromString("ErGw3AZ");

    /**
     * Creates or finds a VirtualNetworkGatewaySkuName from its string representation.
     * @param name a name to look for
     * @return the corresponding VirtualNetworkGatewaySkuName
     */
    @JsonCreator
    public static VirtualNetworkGatewaySkuName fromString(String name) {
        return fromString(name, VirtualNetworkGatewaySkuName.class);
    }

    /**
     * @return known VirtualNetworkGatewaySkuName values
     */
    public static Collection<VirtualNetworkGatewaySkuName> values() {
        return values(VirtualNetworkGatewaySkuName.class);
    }
}
