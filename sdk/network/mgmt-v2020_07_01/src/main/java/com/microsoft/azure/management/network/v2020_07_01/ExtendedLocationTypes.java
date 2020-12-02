/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_07_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for ExtendedLocationTypes.
 */
public final class ExtendedLocationTypes extends ExpandableStringEnum<ExtendedLocationTypes> {
    /** Static value EdgeZone for ExtendedLocationTypes. */
    public static final ExtendedLocationTypes EDGE_ZONE = fromString("EdgeZone");

    /**
     * Creates or finds a ExtendedLocationTypes from its string representation.
     * @param name a name to look for
     * @return the corresponding ExtendedLocationTypes
     */
    @JsonCreator
    public static ExtendedLocationTypes fromString(String name) {
        return fromString(name, ExtendedLocationTypes.class);
    }

    /**
     * @return known ExtendedLocationTypes values
     */
    public static Collection<ExtendedLocationTypes> values() {
        return values(ExtendedLocationTypes.class);
    }
}
