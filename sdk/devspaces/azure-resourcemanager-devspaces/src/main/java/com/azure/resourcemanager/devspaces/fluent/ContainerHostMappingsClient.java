// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devspaces.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.devspaces.fluent.models.ContainerHostMappingInner;

/** An instance of this class provides access to all the operations defined in ContainerHostMappingsClient. */
public interface ContainerHostMappingsClient {
    /**
     * Returns container host mapping object for a container host resource ID if an associated controller exists.
     *
     * @param resourceGroupName Resource group to which the resource belongs.
     * @param location Location of the container host.
     * @param containerHostMapping Container host mapping object specifying the Container host resource ID and its
     *     associated Controller resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return container host mapping object specifying the Container host resource ID and its associated Controller
     *     resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ContainerHostMappingInner getContainerHostMapping(
        String resourceGroupName, String location, ContainerHostMappingInner containerHostMapping);

    /**
     * Returns container host mapping object for a container host resource ID if an associated controller exists.
     *
     * @param resourceGroupName Resource group to which the resource belongs.
     * @param location Location of the container host.
     * @param containerHostMapping Container host mapping object specifying the Container host resource ID and its
     *     associated Controller resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return container host mapping object specifying the Container host resource ID and its associated Controller
     *     resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ContainerHostMappingInner> getContainerHostMappingWithResponse(
        String resourceGroupName, String location, ContainerHostMappingInner containerHostMapping, Context context);
}
