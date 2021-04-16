// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.datamigration.fluent.models.ProjectInner;

/** An instance of this class provides access to all the operations defined in ProjectsClient. */
public interface ProjectsClient {
    /**
     * The project resource is a nested resource representing a stored migration project. This method returns a list of
     * projects owned by a service resource.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return oData page of project resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ProjectInner> listByResourceGroup(String groupName, String serviceName);

    /**
     * The project resource is a nested resource representing a stored migration project. This method returns a list of
     * projects owned by a service resource.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return oData page of project resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ProjectInner> listByResourceGroup(String groupName, String serviceName, Context context);

    /**
     * The project resource is a nested resource representing a stored migration project. The PUT method creates a new
     * project or updates an existing one.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @param parameters Information about the project.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a project resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ProjectInner createOrUpdate(String groupName, String serviceName, String projectName, ProjectInner parameters);

    /**
     * The project resource is a nested resource representing a stored migration project. The PUT method creates a new
     * project or updates an existing one.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @param parameters Information about the project.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a project resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ProjectInner> createOrUpdateWithResponse(
        String groupName, String serviceName, String projectName, ProjectInner parameters, Context context);

    /**
     * The project resource is a nested resource representing a stored migration project. The GET method retrieves
     * information about a project.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a project resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ProjectInner get(String groupName, String serviceName, String projectName);

    /**
     * The project resource is a nested resource representing a stored migration project. The GET method retrieves
     * information about a project.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a project resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ProjectInner> getWithResponse(String groupName, String serviceName, String projectName, Context context);

    /**
     * The project resource is a nested resource representing a stored migration project. The DELETE method deletes a
     * project.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String groupName, String serviceName, String projectName);

    /**
     * The project resource is a nested resource representing a stored migration project. The DELETE method deletes a
     * project.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @param deleteRunningTasks Delete the resource even if it contains running tasks.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(
        String groupName, String serviceName, String projectName, Boolean deleteRunningTasks, Context context);

    /**
     * The project resource is a nested resource representing a stored migration project. The PATCH method updates an
     * existing project.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @param parameters Information about the project.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a project resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ProjectInner update(String groupName, String serviceName, String projectName, ProjectInner parameters);

    /**
     * The project resource is a nested resource representing a stored migration project. The PATCH method updates an
     * existing project.
     *
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param projectName Name of the project.
     * @param parameters Information about the project.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a project resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ProjectInner> updateWithResponse(
        String groupName, String serviceName, String projectName, ProjectInner parameters, Context context);
}
