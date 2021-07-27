// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Customize Azure SDK service client builder with basic properties setting.
 */
@FunctionalInterface
public interface ClientBuilderCustomizer<B> {

    void customize(B builder);
}
