// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.unity.identity;

import com.azure.core.credential.TokenCredential;
import com.azure.spring.AbstractMappingCredentialPropertiesProvider;
import com.azure.spring.autoconfigure.unity.AzureProperties;
import com.azure.spring.identity.SpringEnvironmentCredentialBuilder;
import org.springframework.core.Ordered;

public class SpringMappingCredentialPropertiesProvider extends AbstractMappingCredentialPropertiesProvider implements Ordered {

    public SpringMappingCredentialPropertiesProvider(AzureProperties azureProperties) {
        if (azureProperties != null) {
            mapAzureProperties(azureProperties.getCredential(), azureProperties.getEnvironment());
        }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public TokenCredential mappingTokenCredential() {
        SpringEnvironmentCredentialBuilder mapEnvironmentCredentialBuilder =
            new SpringEnvironmentCredentialBuilder().credentialPropertiesProvider(this);
        return mapEnvironmentCredentialBuilder.build();
    }
}
