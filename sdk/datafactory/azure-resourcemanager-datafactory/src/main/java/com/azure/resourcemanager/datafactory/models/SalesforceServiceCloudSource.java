// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/** A copy activity Salesforce Service Cloud source. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("SalesforceServiceCloudSource")
@Fluent
public final class SalesforceServiceCloudSource extends CopySource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SalesforceServiceCloudSource.class);

    /*
     * Database query. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "query")
    private Object query;

    /*
     * The read behavior for the operation. Default is Query.
     */
    @JsonProperty(value = "readBehavior")
    private SalesforceSourceReadBehavior readBehavior;

    /*
     * Specifies the additional columns to be added to source data. Type: array
     * of objects (or Expression with resultType array of objects).
     */
    @JsonProperty(value = "additionalColumns")
    private List<AdditionalColumns> additionalColumns;

    /**
     * Get the query property: Database query. Type: string (or Expression with resultType string).
     *
     * @return the query value.
     */
    public Object query() {
        return this.query;
    }

    /**
     * Set the query property: Database query. Type: string (or Expression with resultType string).
     *
     * @param query the query value to set.
     * @return the SalesforceServiceCloudSource object itself.
     */
    public SalesforceServiceCloudSource withQuery(Object query) {
        this.query = query;
        return this;
    }

    /**
     * Get the readBehavior property: The read behavior for the operation. Default is Query.
     *
     * @return the readBehavior value.
     */
    public SalesforceSourceReadBehavior readBehavior() {
        return this.readBehavior;
    }

    /**
     * Set the readBehavior property: The read behavior for the operation. Default is Query.
     *
     * @param readBehavior the readBehavior value to set.
     * @return the SalesforceServiceCloudSource object itself.
     */
    public SalesforceServiceCloudSource withReadBehavior(SalesforceSourceReadBehavior readBehavior) {
        this.readBehavior = readBehavior;
        return this;
    }

    /**
     * Get the additionalColumns property: Specifies the additional columns to be added to source data. Type: array of
     * objects (or Expression with resultType array of objects).
     *
     * @return the additionalColumns value.
     */
    public List<AdditionalColumns> additionalColumns() {
        return this.additionalColumns;
    }

    /**
     * Set the additionalColumns property: Specifies the additional columns to be added to source data. Type: array of
     * objects (or Expression with resultType array of objects).
     *
     * @param additionalColumns the additionalColumns value to set.
     * @return the SalesforceServiceCloudSource object itself.
     */
    public SalesforceServiceCloudSource withAdditionalColumns(List<AdditionalColumns> additionalColumns) {
        this.additionalColumns = additionalColumns;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SalesforceServiceCloudSource withSourceRetryCount(Object sourceRetryCount) {
        super.withSourceRetryCount(sourceRetryCount);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SalesforceServiceCloudSource withSourceRetryWait(Object sourceRetryWait) {
        super.withSourceRetryWait(sourceRetryWait);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SalesforceServiceCloudSource withMaxConcurrentConnections(Object maxConcurrentConnections) {
        super.withMaxConcurrentConnections(maxConcurrentConnections);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SalesforceServiceCloudSource withDisableMetricsCollection(Object disableMetricsCollection) {
        super.withDisableMetricsCollection(disableMetricsCollection);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (additionalColumns() != null) {
            additionalColumns().forEach(e -> e.validate());
        }
    }
}
