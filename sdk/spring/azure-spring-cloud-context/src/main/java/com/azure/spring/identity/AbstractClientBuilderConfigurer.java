// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Configurer for extending Azure service client builder configuration.
 */
public abstract class AbstractClientBuilderConfigurer
    <ClientBuilderCustomizerType extends ClientBuilderCustomizer<ClientBuilderType>, ClientBuilderType> {

    private TokenCredentialClientBuilderCustomizer<ClientBuilderType> tokenCredentialCustomizer;

    private ClientBuilderCustomizerType clientBuilderCustomizer;

    private boolean skipCredential;

    public AbstractClientBuilderConfigurer() {
        this.clientBuilderCustomizer = null;
        this.tokenCredentialCustomizer = null;
        this.skipCredential = false;
    }

    public ClientBuilderType configure(ClientBuilderType builder) {
        clientBuilderCustomizer.customize(builder);
        return builder;
    }

    public ClientBuilderType configureClientBuilder(ClientBuilderType builder) {
        clientBuilderCustomizer.customize(builder);
        return builder;
    }

    public ClientBuilderType configureTokenCredential(ClientBuilderType builder) {
        if (!skipCredential) {
            tokenCredentialCustomizer.tokenCredential(builder);
        }
        return builder;
    }

    public boolean isSkipCredential() {
        return skipCredential;
    }

    public void setSkipCredential(boolean skipCredential) {
        this.skipCredential = skipCredential;
    }

    public TokenCredentialClientBuilderCustomizer<ClientBuilderType> getTokenCredentialCustomizer() {
        return tokenCredentialCustomizer;
    }

    public void setTokenCredentialCustomizer(TokenCredentialClientBuilderCustomizer<ClientBuilderType> tokenCredentialCustomizer) {
        this.tokenCredentialCustomizer = tokenCredentialCustomizer;
    }

    public ClientBuilderCustomizerType getClientBuilderCustomizer() {
        return clientBuilderCustomizer;
    }

    public void setClientBuilderCustomizer(ClientBuilderCustomizerType clientBuilderCustomizer) {
        this.clientBuilderCustomizer = clientBuilderCustomizer;
    }
}
