/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_07_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The operation for configuring intrusion detection.
 */
public class FirewallPolicyIntrusionDetectionConfiguration {
    /**
     * List of specific signatures states.
     */
    @JsonProperty(value = "signatureOverrides")
    private List<FirewallPolicyIntrusionDetectionSignatureSpecification> signatureOverrides;

    /**
     * List of rules for traffic to bypass.
     */
    @JsonProperty(value = "bypassTrafficSettings")
    private List<FirewallPolicyIntrusionDetectionBypassTrafficSpecifications> bypassTrafficSettings;

    /**
     * Get list of specific signatures states.
     *
     * @return the signatureOverrides value
     */
    public List<FirewallPolicyIntrusionDetectionSignatureSpecification> signatureOverrides() {
        return this.signatureOverrides;
    }

    /**
     * Set list of specific signatures states.
     *
     * @param signatureOverrides the signatureOverrides value to set
     * @return the FirewallPolicyIntrusionDetectionConfiguration object itself.
     */
    public FirewallPolicyIntrusionDetectionConfiguration withSignatureOverrides(List<FirewallPolicyIntrusionDetectionSignatureSpecification> signatureOverrides) {
        this.signatureOverrides = signatureOverrides;
        return this;
    }

    /**
     * Get list of rules for traffic to bypass.
     *
     * @return the bypassTrafficSettings value
     */
    public List<FirewallPolicyIntrusionDetectionBypassTrafficSpecifications> bypassTrafficSettings() {
        return this.bypassTrafficSettings;
    }

    /**
     * Set list of rules for traffic to bypass.
     *
     * @param bypassTrafficSettings the bypassTrafficSettings value to set
     * @return the FirewallPolicyIntrusionDetectionConfiguration object itself.
     */
    public FirewallPolicyIntrusionDetectionConfiguration withBypassTrafficSettings(List<FirewallPolicyIntrusionDetectionBypassTrafficSpecifications> bypassTrafficSettings) {
        this.bypassTrafficSettings = bypassTrafficSettings;
        return this;
    }

}
