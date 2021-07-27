// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize AzureKeyCredential for Azure SDK service client builder.
 */
@FunctionalInterface
public interface AzureKeyCredentialClientBuilderCustomizer<T> {

    void keyCredential(T builder, AbstractClientBuilderConfigurer.SkipCredentialCallback callback);
}
