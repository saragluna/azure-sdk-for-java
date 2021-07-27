// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize AzureKeyCredential for Azure SDK service client builder.
 */
@FunctionalInterface
public interface SharedKeyCredentialClientBuilderCustomizer<B> {

    void sharedKeyCredential(B builder, AbstractClientBuilderConfigurer.SkipCredentialCallback callback);
}
