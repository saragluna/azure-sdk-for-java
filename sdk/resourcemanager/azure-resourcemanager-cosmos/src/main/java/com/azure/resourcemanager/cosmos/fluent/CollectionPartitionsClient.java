// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.resourcemanager.cosmos.fluent.models.PartitionMetricInner;
import com.azure.resourcemanager.cosmos.fluent.models.PartitionUsageInner;

/** An instance of this class provides access to all the operations defined in CollectionPartitionsClient. */
public interface CollectionPartitionsClient {
    /**
     * Retrieves the metrics determined by the given filter for the given collection, split by partition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName Cosmos DB database account name.
     * @param databaseRid Cosmos DB database rid.
     * @param collectionRid Cosmos DB collection rid.
     * @param filter An OData filter expression that describes a subset of metrics to return. The parameters that can be
     *     filtered are name.value (name of the metric, can have an or of multiple names), startTime, endTime, and
     *     timeGrain. The supported operator is eq.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a list partition metrics request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<PartitionMetricInner> listMetricsAsync(
        String resourceGroupName, String accountName, String databaseRid, String collectionRid, String filter);

    /**
     * Retrieves the metrics determined by the given filter for the given collection, split by partition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName Cosmos DB database account name.
     * @param databaseRid Cosmos DB database rid.
     * @param collectionRid Cosmos DB collection rid.
     * @param filter An OData filter expression that describes a subset of metrics to return. The parameters that can be
     *     filtered are name.value (name of the metric, can have an or of multiple names), startTime, endTime, and
     *     timeGrain. The supported operator is eq.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a list partition metrics request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<PartitionMetricInner> listMetrics(
        String resourceGroupName, String accountName, String databaseRid, String collectionRid, String filter);

    /**
     * Retrieves the metrics determined by the given filter for the given collection, split by partition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName Cosmos DB database account name.
     * @param databaseRid Cosmos DB database rid.
     * @param collectionRid Cosmos DB collection rid.
     * @param filter An OData filter expression that describes a subset of metrics to return. The parameters that can be
     *     filtered are name.value (name of the metric, can have an or of multiple names), startTime, endTime, and
     *     timeGrain. The supported operator is eq.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a list partition metrics request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<PartitionMetricInner> listMetrics(
        String resourceGroupName,
        String accountName,
        String databaseRid,
        String collectionRid,
        String filter,
        Context context);

    /**
     * Retrieves the usages (most recent storage data) for the given collection, split by partition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName Cosmos DB database account name.
     * @param databaseRid Cosmos DB database rid.
     * @param collectionRid Cosmos DB collection rid.
     * @param filter An OData filter expression that describes a subset of usages to return. The supported parameter is
     *     name.value (name of the metric, can have an or of multiple names).
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a list partition level usage request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<PartitionUsageInner> listUsagesAsync(
        String resourceGroupName, String accountName, String databaseRid, String collectionRid, String filter);

    /**
     * Retrieves the usages (most recent storage data) for the given collection, split by partition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName Cosmos DB database account name.
     * @param databaseRid Cosmos DB database rid.
     * @param collectionRid Cosmos DB collection rid.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a list partition level usage request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<PartitionUsageInner> listUsagesAsync(
        String resourceGroupName, String accountName, String databaseRid, String collectionRid);

    /**
     * Retrieves the usages (most recent storage data) for the given collection, split by partition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName Cosmos DB database account name.
     * @param databaseRid Cosmos DB database rid.
     * @param collectionRid Cosmos DB collection rid.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a list partition level usage request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<PartitionUsageInner> listUsages(
        String resourceGroupName, String accountName, String databaseRid, String collectionRid);

    /**
     * Retrieves the usages (most recent storage data) for the given collection, split by partition.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName Cosmos DB database account name.
     * @param databaseRid Cosmos DB database rid.
     * @param collectionRid Cosmos DB collection rid.
     * @param filter An OData filter expression that describes a subset of usages to return. The supported parameter is
     *     name.value (name of the metric, can have an or of multiple names).
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a list partition level usage request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<PartitionUsageInner> listUsages(
        String resourceGroupName,
        String accountName,
        String databaseRid,
        String collectionRid,
        String filter,
        Context context);
}
