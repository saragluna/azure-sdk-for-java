// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Configurer for extending Azure service client builder configuration.
 */
public abstract class AbstractClientBuilderConfigurer<T> {

    private TokenCredentialClientBuilderCustomizer<T> tokenCredentialCustomizer;

    public AbstractClientBuilderConfigurer() {
        this.tokenCredentialCustomizer = null;
    }

    public T configure(T builder) {
        if (tokenCredentialCustomizer != null) {
            tokenCredentialCustomizer.tokenCredential(builder);
        }
        return builder;
    }

    public void setTokenCredentialCustomizer(TokenCredentialClientBuilderCustomizer<T> tokenCredentialCustomizer) {
        this.tokenCredentialCustomizer = tokenCredentialCustomizer;
    }
}
