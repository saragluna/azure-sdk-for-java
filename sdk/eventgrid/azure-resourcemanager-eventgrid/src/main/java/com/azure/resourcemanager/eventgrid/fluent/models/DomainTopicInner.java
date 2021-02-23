// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.eventgrid.models.DomainTopicProvisioningState;
import com.azure.resourcemanager.eventgrid.models.SystemData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Domain Topic. */
@JsonFlatten
@Fluent
public class DomainTopicInner extends ProxyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DomainTopicInner.class);

    /*
     * The system metadata relating to Domain Topic resource.
     */
    @JsonProperty(value = "systemData", access = JsonProperty.Access.WRITE_ONLY)
    private SystemData systemData;

    /*
     * Provisioning state of the domain topic.
     */
    @JsonProperty(value = "properties.provisioningState")
    private DomainTopicProvisioningState provisioningState;

    /**
     * Get the systemData property: The system metadata relating to Domain Topic resource.
     *
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the provisioningState property: Provisioning state of the domain topic.
     *
     * @return the provisioningState value.
     */
    public DomainTopicProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioningState property: Provisioning state of the domain topic.
     *
     * @param provisioningState the provisioningState value to set.
     * @return the DomainTopicInner object itself.
     */
    public DomainTopicInner withProvisioningState(DomainTopicProvisioningState provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (systemData() != null) {
            systemData().validate();
        }
    }
}
