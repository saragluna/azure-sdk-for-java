// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.integration.storage.queue;

import com.azure.storage.queue.QueueClientBuilder;

public interface QueueClientBuilderCustomizer {

    void customize(QueueClientBuilder builder);
}
