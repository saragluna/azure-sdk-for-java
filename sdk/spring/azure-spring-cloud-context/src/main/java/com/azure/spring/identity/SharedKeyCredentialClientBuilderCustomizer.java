// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize SharedAzureKeyCredential for Azure SDK service client builder.
 */
public interface SharedKeyCredentialClientBuilderCustomizer<T> {

    void sharedKeyCredential(T clientBuilder);
}
