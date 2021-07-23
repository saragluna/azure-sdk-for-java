// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring;

import com.azure.spring.autoconfigure.unity.CredentialProperties;
import com.azure.spring.autoconfigure.unity.EnvironmentProperties;

import java.util.Optional;

/**
 * An abstract implementation to provide all credential related properties based on properties subclass.
 */
public abstract class AbstractMappingCredentialPropertiesProvider implements MappingCredentialPropertiesProvider {

    CredentialProperties credentialProperties;
    EnvironmentProperties environment;

    @Override
    public void mapAzureProperties(
        CredentialProperties credentialProperties,
        EnvironmentProperties environment) {
        this.credentialProperties = credentialProperties;
        this.environment = environment;
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
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getClientId).orElse(null);
    }

    @Override
    public String getClientCertificatePath() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getClientId).orElse(null);
    }

    @Override
    public String getUsername() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getClientId).orElse(null);
    }

    @Override
    public String getPassword() {
        return Optional.ofNullable(credentialProperties).map(CredentialProperties::getClientId).orElse(null);
    }

    @Override
    public String getAuthorityHost() {
        return Optional.ofNullable(environment)
                       .map(EnvironmentProperties::getAuthorityHost).orElse(null);
    }
}
