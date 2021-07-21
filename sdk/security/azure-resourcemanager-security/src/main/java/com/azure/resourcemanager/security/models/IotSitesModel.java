// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.resourcemanager.security.fluent.models.IotSitesModelInner;
import java.util.Map;

/** An immutable client-side representation of IotSitesModel. */
public interface IotSitesModel {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the displayName property: Display name of the IoT site.
     *
     * @return the displayName value.
     */
    String displayName();

    /**
     * Gets the tags property: Tags of the IoT site.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the inner com.azure.resourcemanager.security.fluent.models.IotSitesModelInner object.
     *
     * @return the inner object.
     */
    IotSitesModelInner innerModel();
}
