/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.v2019_11_01;

import rx.Observable;
import com.microsoft.azure.management.monitor.v2019_11_01.implementation.MetricDefinitionsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing MetricDefinitions.
 */
public interface MetricDefinitions extends HasInner<MetricDefinitionsInner> {
    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<MetricDefinition> listAsync(String resourceUri);

}
