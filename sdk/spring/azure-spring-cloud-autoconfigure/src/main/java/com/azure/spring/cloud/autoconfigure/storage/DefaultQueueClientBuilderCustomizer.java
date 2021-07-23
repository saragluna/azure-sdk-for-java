package com.azure.spring.cloud.autoconfigure.storage;

import com.azure.core.credential.TokenCredential;
import com.azure.spring.MappingCredentialPropertiesProvider;
import com.azure.spring.cloud.context.core.storage.StorageConnectionStringProvider;
import com.azure.spring.integration.storage.queue.QueueClientBuilderCustomizer;
import com.azure.storage.queue.QueueClientBuilder;
import org.springframework.core.Ordered;

import javax.annotation.Nullable;
import java.util.Optional;

public class DefaultQueueClientBuilderCustomizer implements QueueClientBuilderCustomizer, Ordered {

    @Nullable
    private final StorageConnectionStringProvider storageConnectionStringProvider;
    @Nullable
    private final MappingCredentialPropertiesProvider mappingPropertiesProvider;
    @Nullable
    private final TokenCredential tokenCredential;

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    public DefaultQueueClientBuilderCustomizer(StorageConnectionStringProvider storageConnectionStringProvider,
                                               MappingCredentialPropertiesProvider mappingPropertiesProvider,
                                               TokenCredential tokenCredential) {
        this.storageConnectionStringProvider = storageConnectionStringProvider;
        this.mappingPropertiesProvider = mappingPropertiesProvider;
        this.tokenCredential = tokenCredential;
    }

    @Override
    public void customize(QueueClientBuilder builder) {
        Optional.ofNullable(storageConnectionStringProvider)
                .ifPresentOrElse((provider) -> builder.connectionString(provider.getConnectionString()),
                    () -> Optional.ofNullable(tokenCredential));
        if (storageConnectionStringProvider != null) {
            builder.connectionString(storageConnectionStringProvider.getConnectionString());
        } else if (mappingPropertiesProvider != null) {
            builder.credential(mappingPropertiesProvider.mappingTokenCredential());
        } else {
            builder.credential(tokenCredential);
        }
    }
}
