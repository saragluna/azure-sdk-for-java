// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.cosmos;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.identity.AbstractClientBuilderConfigurer;
import com.azure.spring.identity.AzureKeyCredentialClientBuilderCustomizer;

/**
 * Configurer for extending Azure Cosmos service client builder configuration.
 */
public class CosmosClientBuilderConfigurer extends AbstractClientBuilderConfigurer<CosmosClientBuilder> {

    private AzureKeyCredentialClientBuilderCustomizer<CosmosClientBuilder> azureKeyCredentialCustomizer;

    public void setAzureKeyCredentialCustomizer(AzureKeyCredentialClientBuilderCustomizer<CosmosClientBuilder> azureKeyCredentialCustomizer) {
        this.azureKeyCredentialCustomizer = azureKeyCredentialCustomizer;
    }

    @Override
    public CosmosClientBuilder configure(CosmosClientBuilder builder) {
        super.configure(builder);
        if (azureKeyCredentialCustomizer != null) {
            azureKeyCredentialCustomizer.keyCredential(builder);
        }
        return builder;
    }
}
