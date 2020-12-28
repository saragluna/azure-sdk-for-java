/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appplatform.v2020_11_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifications of the Log for Azure Monitoring.
 */
public class LogSpecification {
    /**
     * Name of the log.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Localized friendly display name of the log.
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /**
     * Blob duration of the log.
     */
    @JsonProperty(value = "blobDuration")
    private String blobDuration;

    /**
     * Get name of the log.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set name of the log.
     *
     * @param name the name value to set
     * @return the LogSpecification object itself.
     */
    public LogSpecification withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get localized friendly display name of the log.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set localized friendly display name of the log.
     *
     * @param displayName the displayName value to set
     * @return the LogSpecification object itself.
     */
    public LogSpecification withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get blob duration of the log.
     *
     * @return the blobDuration value
     */
    public String blobDuration() {
        return this.blobDuration;
    }

    /**
     * Set blob duration of the log.
     *
     * @param blobDuration the blobDuration value to set
     * @return the LogSpecification object itself.
     */
    public LogSpecification withBlobDuration(String blobDuration) {
        this.blobDuration = blobDuration;
        return this;
    }

}
