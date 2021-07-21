// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Describes the partner that created the assessment. */
@Fluent
public final class SecurityAssessmentMetadataPartnerData {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SecurityAssessmentMetadataPartnerData.class);

    /*
     * Name of the company of the partner
     */
    @JsonProperty(value = "partnerName", required = true)
    private String partnerName;

    /*
     * Name of the product of the partner that created the assessment
     */
    @JsonProperty(value = "productName")
    private String productName;

    /*
     * Secret to authenticate the partner and verify it created the assessment
     * - write only
     */
    @JsonProperty(value = "secret", required = true)
    private String secret;

    /**
     * Get the partnerName property: Name of the company of the partner.
     *
     * @return the partnerName value.
     */
    public String partnerName() {
        return this.partnerName;
    }

    /**
     * Set the partnerName property: Name of the company of the partner.
     *
     * @param partnerName the partnerName value to set.
     * @return the SecurityAssessmentMetadataPartnerData object itself.
     */
    public SecurityAssessmentMetadataPartnerData withPartnerName(String partnerName) {
        this.partnerName = partnerName;
        return this;
    }

    /**
     * Get the productName property: Name of the product of the partner that created the assessment.
     *
     * @return the productName value.
     */
    public String productName() {
        return this.productName;
    }

    /**
     * Set the productName property: Name of the product of the partner that created the assessment.
     *
     * @param productName the productName value to set.
     * @return the SecurityAssessmentMetadataPartnerData object itself.
     */
    public SecurityAssessmentMetadataPartnerData withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * Get the secret property: Secret to authenticate the partner and verify it created the assessment - write only.
     *
     * @return the secret value.
     */
    public String secret() {
        return this.secret;
    }

    /**
     * Set the secret property: Secret to authenticate the partner and verify it created the assessment - write only.
     *
     * @param secret the secret value to set.
     * @return the SecurityAssessmentMetadataPartnerData object itself.
     */
    public SecurityAssessmentMetadataPartnerData withSecret(String secret) {
        this.secret = secret;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (partnerName() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property partnerName in model SecurityAssessmentMetadataPartnerData"));
        }
        if (secret() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property secret in model SecurityAssessmentMetadataPartnerData"));
        }
    }
}
