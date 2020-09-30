// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.servicebus.stream.binder.provisioning;

import org.springframework.cloud.stream.provisioning.ProvisioningException;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import com.microsoft.azure.management.servicebus.Queue;
import com.microsoft.azure.management.servicebus.ServiceBusNamespace;
import com.microsoft.azure.spring.cloud.context.core.impl.ServiceBusNamespaceManager;
import com.microsoft.azure.spring.cloud.context.core.impl.ServiceBusQueueManager;
import com.microsoft.azure.spring.cloud.context.core.util.Tuple;

/**
 * @author Warren Zhu
 */
public class ServiceBusQueueChannelResourceManagerProvisioner extends ServiceBusChannelProvisioner {

    private final String namespace;
    private final ServiceBusNamespaceManager serviceBusNamespaceManager;
    private final ServiceBusQueueManager serviceBusQueueManager;

    public ServiceBusQueueChannelResourceManagerProvisioner(
            @NonNull ServiceBusNamespaceManager serviceBusNamespaceManager,
            @NonNull ServiceBusQueueManager serviceBusQueueManager, @NonNull String namespace) {
        Assert.hasText(namespace, "The namespace can't be null or empty");
        this.serviceBusNamespaceManager = serviceBusNamespaceManager;
        this.serviceBusQueueManager = serviceBusQueueManager;
        this.namespace = namespace;
    }

    @Override
    protected void validateOrCreateForConsumer(String name, String group) {
        ServiceBusNamespace namespace = serviceBusNamespaceManager.getOrCreate(this.namespace);
        Queue queue = serviceBusQueueManager.getOrCreate(Tuple.of(namespace, name));
        if (queue == null) {
            throw new ProvisioningException(
                    String.format("Event hub with name '%s' in namespace '%s' not existed", name, namespace));
        }
    }

    @Override
    protected void validateOrCreateForProducer(String name) {
        ServiceBusNamespace namespace = serviceBusNamespaceManager.getOrCreate(this.namespace);
        serviceBusQueueManager.getOrCreate(Tuple.of(namespace, name));
    }
}
