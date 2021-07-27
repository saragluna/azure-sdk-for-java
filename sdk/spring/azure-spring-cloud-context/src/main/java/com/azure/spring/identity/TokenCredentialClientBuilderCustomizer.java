// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize TokenCredential for Azure SDK service client builder.
 */
@FunctionalInterface
public interface TokenCredentialClientBuilderCustomizer<B> {

    void tokenCredential(B clientBuilder);
}
