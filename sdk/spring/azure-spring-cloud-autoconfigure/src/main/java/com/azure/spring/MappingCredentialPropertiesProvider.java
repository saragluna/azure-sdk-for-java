// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring;

import com.azure.core.credential.TokenCredential;
import com.azure.spring.autoconfigure.unity.CredentialProperties;
import com.azure.spring.autoconfigure.unity.EnvironmentProperties;
import com.azure.spring.identity.CredentialPropertiesProvider;

/**
 * An interface to provide all credential related properties based on the properties subclass.
 */
public interface MappingCredentialPropertiesProvider extends CredentialPropertiesProvider {

    void mapAzureProperties(CredentialProperties credentialProperties, EnvironmentProperties environment);

    TokenCredential mappingTokenCredential();
}
