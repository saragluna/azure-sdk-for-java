// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.JobCancellationsClient;
import com.azure.resourcemanager.recoveryservicesbackup.models.JobCancellations;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class JobCancellationsImpl implements JobCancellations {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(JobCancellationsImpl.class);

    private final JobCancellationsClient innerClient;

    private final com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager;

    public JobCancellationsImpl(
        JobCancellationsClient innerClient,
        com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public void trigger(String vaultName, String resourceGroupName, String jobName) {
        this.serviceClient().trigger(vaultName, resourceGroupName, jobName);
    }

    public Response<Void> triggerWithResponse(
        String vaultName, String resourceGroupName, String jobName, Context context) {
        return this.serviceClient().triggerWithResponse(vaultName, resourceGroupName, jobName, context);
    }

    private JobCancellationsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager manager() {
        return this.serviceManager;
    }
}
