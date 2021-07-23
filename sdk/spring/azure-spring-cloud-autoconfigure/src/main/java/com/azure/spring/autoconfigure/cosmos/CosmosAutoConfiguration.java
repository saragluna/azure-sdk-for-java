// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.cosmos;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.credential.TokenCredential;
import com.azure.cosmos.ConnectionMode;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.MappingCredentialPropertiesProvider;
import com.azure.spring.autoconfigure.unity.identity.AzureDefaultTokenCredentialAutoConfiguration;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.core.CosmosTemplate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * Auto Configure Cosmos properties and connection policy.
 */
@Configuration
@ConditionalOnClass({ CosmosAsyncClient.class, CosmosTemplate.class })
@ConditionalOnResource(resources = "classpath:cosmos.enable.config")
@EnableConfigurationProperties(CosmosProperties.class)
@AutoConfigureAfter(AzureDefaultTokenCredentialAutoConfiguration.class)
public class CosmosAutoConfiguration extends AbstractCosmosConfiguration {
    private final CosmosProperties cosmosProperties;

    public CosmosAutoConfiguration(CosmosProperties cosmosProperties) {
        this.cosmosProperties = cosmosProperties;
    }

    @Override
    protected String getDatabaseName() {
        return cosmosProperties.getDatabase();
    }

    @Bean
    @ConditionalOnMissingBean
    public AzureKeyCredential azureKeyCredential() {
        return Optional.ofNullable(cosmosProperties.getKey())
                       .filter(StringUtils::hasText)
                       .map(AzureKeyCredential::new)
                       .orElse(null);
    }

    @Bean
    @ConditionalOnMissingBean
    public CosmosClientBuilder cosmosClientBuilder(
        ObjectProvider<AzureKeyCredential> azureKeyCredentials,
        ObjectProvider<MappingCredentialPropertiesProvider> mappingPropertiesProviders,
        ObjectProvider<TokenCredential> defaultTokenCredentials) {
        CosmosClientBuilder cosmosClientBuilder = new CosmosClientBuilder()
            .consistencyLevel(cosmosProperties.getConsistencyLevel())
            .endpoint(cosmosProperties.getUri());
        if (ConnectionMode.GATEWAY == cosmosProperties.getConnectionMode()) {
            cosmosClientBuilder.gatewayMode();
        }
        AzureKeyCredential azureKeyCredential = azureKeyCredentials.getIfAvailable();
        if (azureKeyCredential != null) {
            return cosmosClientBuilder.credential(azureKeyCredential);
        }

        MappingCredentialPropertiesProvider propertiesProvider = mappingPropertiesProviders.orderedStream()
                                                                                           .findFirst()
                                                                                           .orElse(null);
        if (propertiesProvider != null) {
            return cosmosClientBuilder.credential(propertiesProvider.mappingTokenCredential());
        }

        TokenCredential defaultTokenCredential = defaultTokenCredentials.orderedStream().findFirst().orElse(null);
        if (defaultTokenCredential != null) {
            cosmosClientBuilder.credential(defaultTokenCredential);
        }

        throw new IllegalStateException("Not found any credential properties configured.");
    }

    @Override
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
                           .enableQueryMetrics(cosmosProperties.isPopulateQueryMetrics())
                           .responseDiagnosticsProcessor(cosmosProperties.getResponseDiagnosticsProcessor())
                           .build();
    }
}
