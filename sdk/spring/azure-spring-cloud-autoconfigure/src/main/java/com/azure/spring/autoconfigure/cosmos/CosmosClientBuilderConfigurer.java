// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.cosmos;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.identity.AbstractClientBuilderConfigurer;
import com.azure.spring.identity.AzureKeyCredentialClientBuilderCustomizer;
import com.azure.spring.identity.ClientBuilderCustomizer;

/**
 * Configurer for extending Azure Cosmos service client builder configuration.
 */
public class CosmosClientBuilderConfigurer extends AbstractClientBuilderConfigurer<ClientBuilderCustomizer, CosmosClientBuilder> {

    private AzureKeyCredentialClientBuilderCustomizer azureKeyCredentialCustomizer;

    public AzureKeyCredentialClientBuilderCustomizer getAzureKeyCredentialCustomizer() {
        return azureKeyCredentialCustomizer;
    }

    public void setAzureKeyCredentialCustomizer(AzureKeyCredentialClientBuilderCustomizer azureKeyCredentialCustomizer) {
        this.azureKeyCredentialCustomizer = azureKeyCredentialCustomizer;
    }

    @Override
    public CosmosClientBuilder configure(CosmosClientBuilder builder) {
        configureClientBuilder(builder);
        if (azureKeyCredentialCustomizer != null) {
            azureKeyCredentialCustomizer.keyCredential(builder, new SkipCredentialCallback());
        }
        configureTokenCredential(builder);
        return builder;
    }
}
