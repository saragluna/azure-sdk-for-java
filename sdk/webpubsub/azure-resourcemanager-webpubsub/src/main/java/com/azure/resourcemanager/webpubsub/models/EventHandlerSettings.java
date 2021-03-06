// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.webpubsub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** The settings for event handler in webpubsub service. */
@Fluent
public final class EventHandlerSettings {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(EventHandlerSettings.class);

    /*
     * Get or set the EventHandler items. The key is the hub name and the value
     * is the corresponding EventHandlerTemplate.
     */
    @JsonProperty(value = "items")
    private Map<String, List<EventHandlerTemplate>> items;

    /**
     * Get the items property: Get or set the EventHandler items. The key is the hub name and the value is the
     * corresponding EventHandlerTemplate.
     *
     * @return the items value.
     */
    public Map<String, List<EventHandlerTemplate>> items() {
        return this.items;
    }

    /**
     * Set the items property: Get or set the EventHandler items. The key is the hub name and the value is the
     * corresponding EventHandlerTemplate.
     *
     * @param items the items value to set.
     * @return the EventHandlerSettings object itself.
     */
    public EventHandlerSettings withItems(Map<String, List<EventHandlerTemplate>> items) {
        this.items = items;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (items() != null) {
            items()
                .values()
                .forEach(
                    e -> {
                        if (e != null) {
                            e.forEach(e1 -> e1.validate());
                        }
                    });
        }
    }
}
