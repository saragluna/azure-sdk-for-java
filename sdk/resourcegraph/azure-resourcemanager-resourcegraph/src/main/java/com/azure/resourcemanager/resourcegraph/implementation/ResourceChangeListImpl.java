// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcegraph.implementation;

import com.azure.resourcemanager.resourcegraph.fluent.models.ResourceChangeDataInner;
import com.azure.resourcemanager.resourcegraph.fluent.models.ResourceChangeListInner;
import com.azure.resourcemanager.resourcegraph.models.ResourceChangeData;
import com.azure.resourcemanager.resourcegraph.models.ResourceChangeList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class ResourceChangeListImpl implements ResourceChangeList {
    private ResourceChangeListInner innerObject;

    private final com.azure.resourcemanager.resourcegraph.ResourceGraphManager serviceManager;

    ResourceChangeListImpl(
        ResourceChangeListInner innerObject,
        com.azure.resourcemanager.resourcegraph.ResourceGraphManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public List<ResourceChangeData> changes() {
        List<ResourceChangeDataInner> inner = this.innerModel().changes();
        if (inner != null) {
            return Collections
                .unmodifiableList(
                    inner
                        .stream()
                        .map(inner1 -> new ResourceChangeDataImpl(inner1, this.manager()))
                        .collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public Object skipToken() {
        return this.innerModel().skipToken();
    }

    public ResourceChangeListInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.resourcegraph.ResourceGraphManager manager() {
        return this.serviceManager;
    }
}
