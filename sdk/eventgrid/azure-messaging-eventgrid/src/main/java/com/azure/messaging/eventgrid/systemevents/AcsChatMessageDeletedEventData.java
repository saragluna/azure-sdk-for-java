// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The AcsChatMessageDeletedEventData model. */
@Fluent
public final class AcsChatMessageDeletedEventData extends AcsChatMessageEventBaseProperties {
    /*
     * The time at which the message was deleted
     */
    @JsonProperty(value = "deleteTime")
    private OffsetDateTime deleteTime;

    /**
     * Get the deleteTime property: The time at which the message was deleted.
     *
     * @return the deleteTime value.
     */
    public OffsetDateTime getDeleteTime() {
        return this.deleteTime;
    }

    /**
     * Set the deleteTime property: The time at which the message was deleted.
     *
     * @param deleteTime the deleteTime value to set.
     * @return the AcsChatMessageDeletedEventData object itself.
     */
    public AcsChatMessageDeletedEventData setDeleteTime(OffsetDateTime deleteTime) {
        this.deleteTime = deleteTime;
        return this;
    }
}