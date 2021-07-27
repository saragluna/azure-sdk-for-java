// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring;

import com.azure.core.credential.TokenCredential;
import com.azure.spring.autoconfigure.unity.AzureProperties;
import com.azure.spring.autoconfigure.unity.CredentialProperties;
import com.azure.spring.autoconfigure.unity.EnvironmentProperties;
import com.azure.spring.identity.SpringEnvironmentCredentialBuilder;

import java.util.Optional;

/**
 * An implementation to provide all credential related properties based on properties subclass.
 */
public class SpringMappingCredentialPropertiesProvider implements MappingCredentialPropertiesProvider {

    CredentialProperties credentialProperties;
    EnvironmentProperties environment;

    public SpringMappingCredentialPropertiesProvider(AzureProperties azureProperties) {
        if (azureProperties != null) {
            mapAzureProperties(azureProperties.getCredential(), azureProperties.getEnvironment());
        }
    }

    @Override
    public void mapAzureProperties(CredentialProperties credentialProperties,
                                   EnvironmentProperties environment) {
        this.credentialProperties = credentialProperties;
        this.environment = environment;
    }


    @Override
    public TokenCredential mappingTokenCredential() {
        SpringEnvironmentCredentialBuilder mapEnvironmentCredentialBuilder =
            new SpringEnvironmentCredentialBuilder().credentialPropertiesProvider(this);
        return mapEnvironmentCredentialBuilder.build();
    }

    @Override
    public String getTenantId() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getTenantId).orElse(null);
    }

    @Override
    public String getClientId() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getClientId).orElse(null);
    }

    @Override
    public String getClientSecret() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getClientSecret).orElse(null);
    }

    @Override
    public String getClientCertificatePath() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getCertificatePath).orElse(null);
    }

    @Override
    public String getCertificatePassword() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getCertificatePassword).orElse(null);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getAuthorityHost() {
        return null;
    }
}
