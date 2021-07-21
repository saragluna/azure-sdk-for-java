// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for AadConnectivityStateValue. */
public final class AadConnectivityStateValue extends ExpandableStringEnum<AadConnectivityStateValue> {
    /** Static value Discovered for AadConnectivityStateValue. */
    public static final AadConnectivityStateValue DISCOVERED = fromString("Discovered");

    /** Static value NotLicensed for AadConnectivityStateValue. */
    public static final AadConnectivityStateValue NOT_LICENSED = fromString("NotLicensed");

    /** Static value Connected for AadConnectivityStateValue. */
    public static final AadConnectivityStateValue CONNECTED = fromString("Connected");

    /**
     * Creates or finds a AadConnectivityStateValue from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AadConnectivityStateValue.
     */
    @JsonCreator
    public static AadConnectivityStateValue fromString(String name) {
        return fromString(name, AadConnectivityStateValue.class);
    }

    /** @return known AadConnectivityStateValue values. */
    public static Collection<AadConnectivityStateValue> values() {
        return values(AadConnectivityStateValue.class);
    }
}
