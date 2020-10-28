/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.healthcareapis.v2020_03_30.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Beta.SinceVersion;
import com.microsoft.azure.arm.resources.AzureConfigurable;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;
import com.microsoft.azure.management.healthcareapis.v2020_03_30.Services;
import com.microsoft.azure.management.healthcareapis.v2020_03_30.Operations;
import com.microsoft.azure.management.healthcareapis.v2020_03_30.OperationResults;
import com.microsoft.azure.management.healthcareapis.v2020_03_30.PrivateEndpointConnections;
import com.microsoft.azure.management.healthcareapis.v2020_03_30.PrivateLinkResources;
import com.microsoft.azure.arm.resources.implementation.AzureConfigurableCoreImpl;
import com.microsoft.azure.arm.resources.implementation.ManagerCore;

/**
 * Entry point to Azure HealthcareApis resource management.
 */
public final class HealthcareApisManager extends ManagerCore<HealthcareApisManager, HealthcareApisManagementClientImpl> {
    private Services services;
    private Operations operations;
    private OperationResults operationResults;
    private PrivateEndpointConnections privateEndpointConnections;
    private PrivateLinkResources privateLinkResources;
    /**
    * Get a Configurable instance that can be used to create HealthcareApisManager with optional configuration.
    *
    * @return the instance allowing configurations
    */
    public static Configurable configure() {
        return new HealthcareApisManager.ConfigurableImpl();
    }
    /**
    * Creates an instance of HealthcareApisManager that exposes HealthcareApis resource management API entry points.
    *
    * @param credentials the credentials to use
    * @param subscriptionId the subscription UUID
    * @return the HealthcareApisManager
    */
    public static HealthcareApisManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
        return new HealthcareApisManager(new RestClient.Builder()
            .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
            .withCredentials(credentials)
            .withSerializerAdapter(new AzureJacksonAdapter())
            .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
            .build(), subscriptionId);
    }
    /**
    * Creates an instance of HealthcareApisManager that exposes HealthcareApis resource management API entry points.
    *
    * @param restClient the RestClient to be used for API calls.
    * @param subscriptionId the subscription UUID
    * @return the HealthcareApisManager
    */
    public static HealthcareApisManager authenticate(RestClient restClient, String subscriptionId) {
        return new HealthcareApisManager(restClient, subscriptionId);
    }
    /**
    * The interface allowing configurations to be set.
    */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
        * Creates an instance of HealthcareApisManager that exposes HealthcareApis management API entry points.
        *
        * @param credentials the credentials to use
        * @param subscriptionId the subscription UUID
        * @return the interface exposing HealthcareApis management API entry points that work across subscriptions
        */
        HealthcareApisManager authenticate(AzureTokenCredentials credentials, String subscriptionId);
    }

    /**
     * @return Entry point to manage Services.
     */
    public Services services() {
        if (this.services == null) {
            this.services = new ServicesImpl(this);
        }
        return this.services;
    }

    /**
     * @return Entry point to manage Operations.
     */
    public Operations operations() {
        if (this.operations == null) {
            this.operations = new OperationsImpl(this);
        }
        return this.operations;
    }

    /**
     * @return Entry point to manage OperationResults.
     */
    public OperationResults operationResults() {
        if (this.operationResults == null) {
            this.operationResults = new OperationResultsImpl(this);
        }
        return this.operationResults;
    }

    /**
     * @return Entry point to manage PrivateEndpointConnections.
     */
    public PrivateEndpointConnections privateEndpointConnections() {
        if (this.privateEndpointConnections == null) {
            this.privateEndpointConnections = new PrivateEndpointConnectionsImpl(this);
        }
        return this.privateEndpointConnections;
    }

    /**
     * @return Entry point to manage PrivateLinkResources.
     */
    public PrivateLinkResources privateLinkResources() {
        if (this.privateLinkResources == null) {
            this.privateLinkResources = new PrivateLinkResourcesImpl(this);
        }
        return this.privateLinkResources;
    }

    /**
    * The implementation for Configurable interface.
    */
    private static final class ConfigurableImpl extends AzureConfigurableCoreImpl<Configurable> implements Configurable {
        public HealthcareApisManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
           return HealthcareApisManager.authenticate(buildRestClient(credentials), subscriptionId);
        }
     }
    private HealthcareApisManager(RestClient restClient, String subscriptionId) {
        super(
            restClient,
            subscriptionId,
            new HealthcareApisManagementClientImpl(restClient).withSubscriptionId(subscriptionId));
    }
}
