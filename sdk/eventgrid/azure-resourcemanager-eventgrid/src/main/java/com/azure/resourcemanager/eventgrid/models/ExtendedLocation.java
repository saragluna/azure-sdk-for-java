// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Definition of an Extended Location. */
@Fluent
public final class ExtendedLocation {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ExtendedLocation.class);

    /*
     * Fully qualified name of the extended location.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Type of the extended location.
     */
    @JsonProperty(value = "type")
    private String type;

    /**
     * Get the name property: Fully qualified name of the extended location.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Fully qualified name of the extended location.
     *
     * @param name the name value to set.
     * @return the ExtendedLocation object itself.
     */
    public ExtendedLocation withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the type property: Type of the extended location.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type property: Type of the extended location.
     *
     * @param type the type value to set.
     * @return the ExtendedLocation object itself.
     */
    public ExtendedLocation withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
