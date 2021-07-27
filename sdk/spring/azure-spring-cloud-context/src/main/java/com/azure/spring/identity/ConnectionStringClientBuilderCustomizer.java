// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize connectionString for Azure SDK service client builder.
 */
@FunctionalInterface
public interface ConnectionStringClientBuilderCustomizer<T> {

    void connectionString(T clientBuilder, AbstractClientBuilderConfigurer.SkipCredentialCallback callback);
}
