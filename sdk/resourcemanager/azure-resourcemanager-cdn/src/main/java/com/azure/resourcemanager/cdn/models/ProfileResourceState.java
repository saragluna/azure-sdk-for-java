// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ProfileResourceState. */
public final class ProfileResourceState extends ExpandableStringEnum<ProfileResourceState> {
    /** Static value Creating for ProfileResourceState. */
    public static final ProfileResourceState CREATING = fromString("Creating");

    /** Static value Active for ProfileResourceState. */
    public static final ProfileResourceState ACTIVE = fromString("Active");

    /** Static value Deleting for ProfileResourceState. */
    public static final ProfileResourceState DELETING = fromString("Deleting");

    /** Static value Disabled for ProfileResourceState. */
    public static final ProfileResourceState DISABLED = fromString("Disabled");

    /**
     * Creates or finds a ProfileResourceState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ProfileResourceState.
     */
    @JsonCreator
    public static ProfileResourceState fromString(String name) {
        return fromString(name, ProfileResourceState.class);
    }

    /** @return known ProfileResourceState values. */
    public static Collection<ProfileResourceState> values() {
        return values(ProfileResourceState.class);
    }
}