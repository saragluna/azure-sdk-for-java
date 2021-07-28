// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize connectionString for Azure SDK service client builder.
 */
public interface ConnectionStringClientBuilderCustomizer<ClientBuilderType> {

    void connectionString(ClientBuilderType clientBuilder,
                          AbstractClientBuilderConfigurer<?, ClientBuilderType>.SkipCredentialCallback callback);
}
