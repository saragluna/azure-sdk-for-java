// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Default implementation to configure token credential callback interface
 * @param <Configurer> Service builder configurer
 */
public class DefaultSkipCredentialCallback<Configurer extends AbstractClientBuilderConfigurer<? extends ClientBuilderCustomizer<?>, ?>>
    implements TokenCredentialCallback {

    private final Configurer configurer;

    public DefaultSkipCredentialCallback(Configurer configurer) {
        this.configurer = configurer;
    }

    @Override
    public void skipCredential() {
        configurer.setSkipCredential(true);
    }

    @Override
    public boolean isSkipCredential() {
        return configurer.isSkipCredential();
    }
}
