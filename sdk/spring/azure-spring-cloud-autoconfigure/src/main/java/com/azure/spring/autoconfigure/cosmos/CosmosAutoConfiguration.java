// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.cosmos;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.credential.TokenCredential;
import com.azure.cosmos.ConnectionMode;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.identity.ChainedTokenCredential;
import com.azure.identity.ChainedTokenCredentialBuilder;
import com.azure.spring.SpringMappingCredentialPropertiesProvider;
import com.azure.spring.autoconfigure.unity.identity.AzureDefaultTokenCredentialAutoConfiguration;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.core.CosmosTemplate;
import com.azure.spring.identity.AzureKeyCredentialClientBuilderCustomizer;
import com.azure.spring.identity.TokenCredentialClientBuilderCustomizer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static com.azure.spring.autoconfigure.unity.identity.AzureDefaultTokenCredentialAutoConfiguration.DEFAULT_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME;

/**
 * Auto Configure Cosmos properties and connection policy.
 */
@Configuration
@ConditionalOnClass({ CosmosAsyncClient.class, CosmosTemplate.class })
@ConditionalOnResource(resources = "classpath:cosmos.enable.config")
@EnableConfigurationProperties(CosmosProperties.class)
@AutoConfigureAfter(AzureDefaultTokenCredentialAutoConfiguration.class)
public class CosmosAutoConfiguration extends AbstractCosmosConfiguration {
    private final CosmosProperties properties;
    private static final String COSMOS_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME = "cosmosChainedTokenCredential";
    private static final String COSMOS_AZURE_KEY_CREDENTIAL_BEAN_NAME = "cosmosAzureKeyCredential";

    public CosmosAutoConfiguration(CosmosProperties properties) {
        this.properties = properties;
    }

    @Override
    protected String getDatabaseName() {
        return properties.getDatabase();
    }

    @Bean(COSMOS_AZURE_KEY_CREDENTIAL_BEAN_NAME)
    @ConditionalOnMissingBean(name = COSMOS_AZURE_KEY_CREDENTIAL_BEAN_NAME)
    public AzureKeyCredential cosmosAzureKeyCredential() {
        return Optional.ofNullable(properties.getKey())
                       .filter(StringUtils::hasText)
                       .map(AzureKeyCredential::new)
                       .orElse(null);
    }

    @Bean(COSMOS_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME)
    @ConditionalOnMissingBean(name = COSMOS_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME)
    public ChainedTokenCredential cosmosChainedTokenCredential(
        @Qualifier(DEFAULT_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME) TokenCredential defaultTokenCredential) {
        SpringMappingCredentialPropertiesProvider provider = new SpringMappingCredentialPropertiesProvider(properties);
        final ChainedTokenCredentialBuilder chainedTokenCredentialBuilder = new ChainedTokenCredentialBuilder();
        chainedTokenCredentialBuilder.addLast(provider.mappingTokenCredential())
                                     .addLast(defaultTokenCredential);
        return chainedTokenCredentialBuilder.build();
    }

    @Bean
    @ConditionalOnMissingBean
    public AzureKeyCredentialClientBuilderCustomizer<CosmosClientBuilder> azureKeyCredentialCustomizer(
        @Autowired(required = false) @Qualifier(COSMOS_AZURE_KEY_CREDENTIAL_BEAN_NAME) AzureKeyCredential cosmosAzureKeyCredential) {
        if (cosmosAzureKeyCredential != null) {
            return builder -> builder.credential(cosmosAzureKeyCredential);
        }
        return null;
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenCredentialClientBuilderCustomizer<CosmosClientBuilder> tokenCredentialCustomizer(
        @Qualifier(COSMOS_CHAINED_TOKEN_CREDENTIAL_BEAN_NAME) ChainedTokenCredential cosmosChainedTokenCredential) {
        return builder -> builder.credential(cosmosChainedTokenCredential);
    }

    /**
     * Cosmos client builder configurer
     * @param azureKeyCredentialCustomizers Customize key credential
     * @param tokenCredentialCustomizers Customize token credential.
     * @return Cosmos client builder configurer
     */
    @Bean
    public CosmosClientBuilderConfigurer cosmosClientBuilderConfigurer(
        ObjectProvider<AzureKeyCredentialClientBuilderCustomizer<CosmosClientBuilder>> azureKeyCredentialCustomizers,
        ObjectProvider<TokenCredentialClientBuilderCustomizer<CosmosClientBuilder>> tokenCredentialCustomizers) {
        CosmosClientBuilderConfigurer configurer = new CosmosClientBuilderConfigurer();
        configurer.setAzureKeyCredentialCustomizer(azureKeyCredentialCustomizers.orderedStream().findFirst().orElse(null));
        configurer.setTokenCredentialCustomizer(tokenCredentialCustomizers.orderedStream().findFirst().orElse(null));
        return configurer;
    }

    /**
     * Create default CosmosClientBuilder
     * @param cosmosClientBuilderConfigurer Cosmos client builder configurer bean.
     * @return Default CosmosClientBuilder
     */
    @Bean
    @ConditionalOnMissingBean
    public CosmosClientBuilder cosmosClientBuilderCustomizer(CosmosClientBuilderConfigurer cosmosClientBuilderConfigurer) {
        CosmosClientBuilder builder = new CosmosClientBuilder();
        builder.consistencyLevel(properties.getConsistencyLevel())
               .endpoint(properties.getUri());
        if (ConnectionMode.GATEWAY == properties.getConnectionMode()) {
            builder.gatewayMode();
        }
        return cosmosClientBuilderConfigurer.configure(builder);
    }

    @Override
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
                           .enableQueryMetrics(properties.isPopulateQueryMetrics())
                           .responseDiagnosticsProcessor(properties.getResponseDiagnosticsProcessor())
                           .build();
    }
}
