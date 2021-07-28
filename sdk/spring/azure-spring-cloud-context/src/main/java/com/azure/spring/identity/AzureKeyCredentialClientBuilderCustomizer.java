// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize AzureKeyCredential for Azure SDK service client builder.
 */
public interface AzureKeyCredentialClientBuilderCustomizer<ClientBuilderType> {

    void keyCredential(ClientBuilderType builder,
                       AbstractClientBuilderConfigurer<?, ClientBuilderType>.SkipCredentialCallback callback);
}
