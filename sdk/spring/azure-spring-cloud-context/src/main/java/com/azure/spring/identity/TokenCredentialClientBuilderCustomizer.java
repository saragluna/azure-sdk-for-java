// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize TokenCredential for Azure SDK service client builder.
 */
public interface TokenCredentialClientBuilderCustomizer<ClientBuilderType> {

    void tokenCredential(ClientBuilderType clientBuilder);
}
