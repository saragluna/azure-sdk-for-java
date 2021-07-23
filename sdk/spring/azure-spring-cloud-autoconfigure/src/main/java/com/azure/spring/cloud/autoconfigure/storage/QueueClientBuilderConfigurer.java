package com.azure.spring.cloud.autoconfigure.storage;

import com.azure.spring.integration.storage.queue.QueueClientBuilderCustomizer;
import com.azure.storage.queue.QueueClientBuilder;

import java.util.List;

public class QueueClientBuilderConfigurer {

    private List<QueueClientBuilderCustomizer> queueClientBuilderCustomizerList;

    public List<QueueClientBuilderCustomizer> getQueueClientBuilderCustomizerList() {
        return queueClientBuilderCustomizerList;
    }

    public void setQueueClientBuilderCustomizerList(List<QueueClientBuilderCustomizer> queueClientBuilderCustomizerList) {
        this.queueClientBuilderCustomizerList = queueClientBuilderCustomizerList;
    }

    public QueueClientBuilder configure(QueueClientBuilder builder) {
        queueClientBuilderCustomizerList.forEach(clientBuilder -> clientBuilder.customize(builder));
        return builder;
    }
}
