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
import java.util.Map;

/** A copy activity SQL server source. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("SqlServerSource")
@Fluent
public final class SqlServerSource extends TabularSource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SqlServerSource.class);

    /*
     * SQL reader query. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "sqlReaderQuery")
    private Object sqlReaderQuery;

    /*
     * Name of the stored procedure for a SQL Database source. This cannot be
     * used at the same time as SqlReaderQuery. Type: string (or Expression
     * with resultType string).
     */
    @JsonProperty(value = "sqlReaderStoredProcedureName")
    private Object sqlReaderStoredProcedureName;

    /*
     * Value and type setting for stored procedure parameters. Example:
     * "{Parameter1: {value: "1", type: "int"}}".
     */
    @JsonProperty(value = "storedProcedureParameters")
    private Map<String, StoredProcedureParameter> storedProcedureParameters;

    /*
     * Which additional types to produce.
     */
    @JsonProperty(value = "produceAdditionalTypes")
    private Object produceAdditionalTypes;

    /*
     * The partition mechanism that will be used for Sql read in parallel.
     * Possible values include: "None", "PhysicalPartitionsOfTable",
     * "DynamicRange".
     */
    @JsonProperty(value = "partitionOption")
    private Object partitionOption;

    /*
     * The settings that will be leveraged for Sql source partitioning.
     */
    @JsonProperty(value = "partitionSettings")
    private SqlPartitionSettings partitionSettings;

    /**
     * Get the sqlReaderQuery property: SQL reader query. Type: string (or Expression with resultType string).
     *
     * @return the sqlReaderQuery value.
     */
    public Object sqlReaderQuery() {
        return this.sqlReaderQuery;
    }

    /**
     * Set the sqlReaderQuery property: SQL reader query. Type: string (or Expression with resultType string).
     *
     * @param sqlReaderQuery the sqlReaderQuery value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource withSqlReaderQuery(Object sqlReaderQuery) {
        this.sqlReaderQuery = sqlReaderQuery;
        return this;
    }

    /**
     * Get the sqlReaderStoredProcedureName property: Name of the stored procedure for a SQL Database source. This
     * cannot be used at the same time as SqlReaderQuery. Type: string (or Expression with resultType string).
     *
     * @return the sqlReaderStoredProcedureName value.
     */
    public Object sqlReaderStoredProcedureName() {
        return this.sqlReaderStoredProcedureName;
    }

    /**
     * Set the sqlReaderStoredProcedureName property: Name of the stored procedure for a SQL Database source. This
     * cannot be used at the same time as SqlReaderQuery. Type: string (or Expression with resultType string).
     *
     * @param sqlReaderStoredProcedureName the sqlReaderStoredProcedureName value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource withSqlReaderStoredProcedureName(Object sqlReaderStoredProcedureName) {
        this.sqlReaderStoredProcedureName = sqlReaderStoredProcedureName;
        return this;
    }

    /**
     * Get the storedProcedureParameters property: Value and type setting for stored procedure parameters. Example:
     * "{Parameter1: {value: "1", type: "int"}}".
     *
     * @return the storedProcedureParameters value.
     */
    public Map<String, StoredProcedureParameter> storedProcedureParameters() {
        return this.storedProcedureParameters;
    }

    /**
     * Set the storedProcedureParameters property: Value and type setting for stored procedure parameters. Example:
     * "{Parameter1: {value: "1", type: "int"}}".
     *
     * @param storedProcedureParameters the storedProcedureParameters value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource withStoredProcedureParameters(
        Map<String, StoredProcedureParameter> storedProcedureParameters) {
        this.storedProcedureParameters = storedProcedureParameters;
        return this;
    }

    /**
     * Get the produceAdditionalTypes property: Which additional types to produce.
     *
     * @return the produceAdditionalTypes value.
     */
    public Object produceAdditionalTypes() {
        return this.produceAdditionalTypes;
    }

    /**
     * Set the produceAdditionalTypes property: Which additional types to produce.
     *
     * @param produceAdditionalTypes the produceAdditionalTypes value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource withProduceAdditionalTypes(Object produceAdditionalTypes) {
        this.produceAdditionalTypes = produceAdditionalTypes;
        return this;
    }

    /**
     * Get the partitionOption property: The partition mechanism that will be used for Sql read in parallel. Possible
     * values include: "None", "PhysicalPartitionsOfTable", "DynamicRange".
     *
     * @return the partitionOption value.
     */
    public Object partitionOption() {
        return this.partitionOption;
    }

    /**
     * Set the partitionOption property: The partition mechanism that will be used for Sql read in parallel. Possible
     * values include: "None", "PhysicalPartitionsOfTable", "DynamicRange".
     *
     * @param partitionOption the partitionOption value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource withPartitionOption(Object partitionOption) {
        this.partitionOption = partitionOption;
        return this;
    }

    /**
     * Get the partitionSettings property: The settings that will be leveraged for Sql source partitioning.
     *
     * @return the partitionSettings value.
     */
    public SqlPartitionSettings partitionSettings() {
        return this.partitionSettings;
    }

    /**
     * Set the partitionSettings property: The settings that will be leveraged for Sql source partitioning.
     *
     * @param partitionSettings the partitionSettings value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource withPartitionSettings(SqlPartitionSettings partitionSettings) {
        this.partitionSettings = partitionSettings;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SqlServerSource withQueryTimeout(Object queryTimeout) {
        super.withQueryTimeout(queryTimeout);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SqlServerSource withAdditionalColumns(List<AdditionalColumns> additionalColumns) {
        super.withAdditionalColumns(additionalColumns);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SqlServerSource withSourceRetryCount(Object sourceRetryCount) {
        super.withSourceRetryCount(sourceRetryCount);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SqlServerSource withSourceRetryWait(Object sourceRetryWait) {
        super.withSourceRetryWait(sourceRetryWait);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SqlServerSource withMaxConcurrentConnections(Object maxConcurrentConnections) {
        super.withMaxConcurrentConnections(maxConcurrentConnections);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SqlServerSource withDisableMetricsCollection(Object disableMetricsCollection) {
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
        if (storedProcedureParameters() != null) {
            storedProcedureParameters()
                .values()
                .forEach(
                    e -> {
                        if (e != null) {
                            e.validate();
                        }
                    });
        }
        if (partitionSettings() != null) {
            partitionSettings().validate();
        }
    }
}
