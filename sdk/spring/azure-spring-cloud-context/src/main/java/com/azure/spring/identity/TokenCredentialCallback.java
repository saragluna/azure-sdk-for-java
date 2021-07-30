// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.identity;

/**
 * Configure token credential callback interface
 */
public interface TokenCredentialCallback {

    void skipCredential();

    boolean isSkipCredential();
}
