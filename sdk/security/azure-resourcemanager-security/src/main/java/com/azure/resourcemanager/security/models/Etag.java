// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Entity tag is used for comparing two or more entities from the same requested resource. */
@Fluent
public class Etag {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(Etag.class);

    /*
     * Entity tag is used for comparing two or more entities from the same
     * requested resource.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /**
     * Get the etag property: Entity tag is used for comparing two or more entities from the same requested resource.
     *
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set the etag property: Entity tag is used for comparing two or more entities from the same requested resource.
     *
     * @param etag the etag value to set.
     * @return the Etag object itself.
     */
    public Etag withEtag(String etag) {
        this.etag = etag;
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
