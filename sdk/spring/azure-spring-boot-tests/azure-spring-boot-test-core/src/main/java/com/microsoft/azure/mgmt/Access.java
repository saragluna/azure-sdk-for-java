// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.microsoft.azure.mgmt;

import com.microsoft.azure.credentials.AzureTokenCredentials;

public interface Access {

    AzureTokenCredentials credentials();

    String subscription();

    String servicePrincipal();

}
