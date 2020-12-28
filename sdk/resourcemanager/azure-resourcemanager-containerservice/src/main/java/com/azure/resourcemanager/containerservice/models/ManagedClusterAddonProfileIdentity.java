// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** Information of user assigned identity used by this add-on. */
@Immutable
public class ManagedClusterAddonProfileIdentity extends UserAssignedIdentity {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ManagedClusterAddonProfileIdentity.class);

    /** {@inheritDoc} */
    @Override
    public ManagedClusterAddonProfileIdentity withResourceId(String resourceId) {
        super.withResourceId(resourceId);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ManagedClusterAddonProfileIdentity withClientId(String clientId) {
        super.withClientId(clientId);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ManagedClusterAddonProfileIdentity withObjectId(String objectId) {
        super.withObjectId(objectId);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
