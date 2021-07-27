// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Configurer for extending Azure service client builder configuration.
 */
public abstract class AbstractClientBuilderConfigurer<C extends ClientBuilderCustomizer, B> {

    private TokenCredentialClientBuilderCustomizer tokenCredentialCustomizer;

    private C clientBuilderCustomizer;

    private boolean skipCredential;

    public B configure(B builder) {
        clientBuilderCustomizer.customize(builder);
        return builder;
    }

    public B configureClientBuilder(B builder) {
        clientBuilderCustomizer.customize(builder);
        return builder;
    }

    public B configureTokenCredential(B builder) {
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

    public TokenCredentialClientBuilderCustomizer getTokenCredentialCustomizer() {
        return tokenCredentialCustomizer;
    }

    public void setTokenCredentialCustomizer(TokenCredentialClientBuilderCustomizer tokenCredentialCustomizer) {
        this.tokenCredentialCustomizer = tokenCredentialCustomizer;
    }

    public C getClientBuilderCustomizer() {
        return clientBuilderCustomizer;
    }

    public void setClientBuilderCustomizer(C clientBuilderCustomizer) {
        this.clientBuilderCustomizer = clientBuilderCustomizer;
    }

    public class SkipCredentialCallback {
        public void skipCredential() {
            setSkipCredential(true);
        }

        public boolean isSkipCredential() {
            return skipCredential;
        }
    }
}
