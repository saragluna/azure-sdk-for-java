/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2020_09_18;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.kusto.v2020_09_18.implementation.DataConnectionInner;

/**
 * Class representing an Event Grid data connection.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind", defaultImpl = EventGridDataConnection.class)
@JsonTypeName("EventGrid")
@JsonFlatten
public class EventGridDataConnection extends DataConnectionInner {
    /**
     * The resource ID of the storage account where the data resides.
     */
    @JsonProperty(value = "properties.storageAccountResourceId", required = true)
    private String storageAccountResourceId;

    /**
     * The resource ID where the event grid is configured to send events.
     */
    @JsonProperty(value = "properties.eventHubResourceId", required = true)
    private String eventHubResourceId;

    /**
     * The event hub consumer group.
     */
    @JsonProperty(value = "properties.consumerGroup", required = true)
    private String consumerGroup;

    /**
     * The table where the data should be ingested. Optionally the table
     * information can be added to each message.
     */
    @JsonProperty(value = "properties.tableName")
    private String tableName;

    /**
     * The mapping rule to be used to ingest the data. Optionally the mapping
     * information can be added to each message.
     */
    @JsonProperty(value = "properties.mappingRuleName")
    private String mappingRuleName;

    /**
     * The data format of the message. Optionally the data format can be added
     * to each message. Possible values include: 'MULTIJSON', 'JSON', 'CSV',
     * 'TSV', 'SCSV', 'SOHSV', 'PSV', 'TXT', 'RAW', 'SINGLEJSON', 'AVRO',
     * 'TSVE', 'PARQUET', 'ORC', 'APACHEAVRO', 'W3CLOGFILE'.
     */
    @JsonProperty(value = "properties.dataFormat")
    private EventGridDataFormat dataFormat;

    /**
     * A Boolean value that, if set to true, indicates that ingestion should
     * ignore the first record of every file.
     */
    @JsonProperty(value = "properties.ignoreFirstRecord")
    private Boolean ignoreFirstRecord;

    /**
     * The name of blob storage event type to process. Possible values include:
     * 'Microsoft.Storage.BlobCreated', 'Microsoft.Storage.BlobRenamed'.
     */
    @JsonProperty(value = "properties.blobStorageEventType")
    private BlobStorageEventType blobStorageEventType;

    /**
     * The provisioned state of the resource. Possible values include:
     * 'Running', 'Creating', 'Deleting', 'Succeeded', 'Failed', 'Moving'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * Get the resource ID of the storage account where the data resides.
     *
     * @return the storageAccountResourceId value
     */
    public String storageAccountResourceId() {
        return this.storageAccountResourceId;
    }

    /**
     * Set the resource ID of the storage account where the data resides.
     *
     * @param storageAccountResourceId the storageAccountResourceId value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withStorageAccountResourceId(String storageAccountResourceId) {
        this.storageAccountResourceId = storageAccountResourceId;
        return this;
    }

    /**
     * Get the resource ID where the event grid is configured to send events.
     *
     * @return the eventHubResourceId value
     */
    public String eventHubResourceId() {
        return this.eventHubResourceId;
    }

    /**
     * Set the resource ID where the event grid is configured to send events.
     *
     * @param eventHubResourceId the eventHubResourceId value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withEventHubResourceId(String eventHubResourceId) {
        this.eventHubResourceId = eventHubResourceId;
        return this;
    }

    /**
     * Get the event hub consumer group.
     *
     * @return the consumerGroup value
     */
    public String consumerGroup() {
        return this.consumerGroup;
    }

    /**
     * Set the event hub consumer group.
     *
     * @param consumerGroup the consumerGroup value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
        return this;
    }

    /**
     * Get the table where the data should be ingested. Optionally the table information can be added to each message.
     *
     * @return the tableName value
     */
    public String tableName() {
        return this.tableName;
    }

    /**
     * Set the table where the data should be ingested. Optionally the table information can be added to each message.
     *
     * @param tableName the tableName value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * Get the mapping rule to be used to ingest the data. Optionally the mapping information can be added to each message.
     *
     * @return the mappingRuleName value
     */
    public String mappingRuleName() {
        return this.mappingRuleName;
    }

    /**
     * Set the mapping rule to be used to ingest the data. Optionally the mapping information can be added to each message.
     *
     * @param mappingRuleName the mappingRuleName value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withMappingRuleName(String mappingRuleName) {
        this.mappingRuleName = mappingRuleName;
        return this;
    }

    /**
     * Get the data format of the message. Optionally the data format can be added to each message. Possible values include: 'MULTIJSON', 'JSON', 'CSV', 'TSV', 'SCSV', 'SOHSV', 'PSV', 'TXT', 'RAW', 'SINGLEJSON', 'AVRO', 'TSVE', 'PARQUET', 'ORC', 'APACHEAVRO', 'W3CLOGFILE'.
     *
     * @return the dataFormat value
     */
    public EventGridDataFormat dataFormat() {
        return this.dataFormat;
    }

    /**
     * Set the data format of the message. Optionally the data format can be added to each message. Possible values include: 'MULTIJSON', 'JSON', 'CSV', 'TSV', 'SCSV', 'SOHSV', 'PSV', 'TXT', 'RAW', 'SINGLEJSON', 'AVRO', 'TSVE', 'PARQUET', 'ORC', 'APACHEAVRO', 'W3CLOGFILE'.
     *
     * @param dataFormat the dataFormat value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withDataFormat(EventGridDataFormat dataFormat) {
        this.dataFormat = dataFormat;
        return this;
    }

    /**
     * Get a Boolean value that, if set to true, indicates that ingestion should ignore the first record of every file.
     *
     * @return the ignoreFirstRecord value
     */
    public Boolean ignoreFirstRecord() {
        return this.ignoreFirstRecord;
    }

    /**
     * Set a Boolean value that, if set to true, indicates that ingestion should ignore the first record of every file.
     *
     * @param ignoreFirstRecord the ignoreFirstRecord value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withIgnoreFirstRecord(Boolean ignoreFirstRecord) {
        this.ignoreFirstRecord = ignoreFirstRecord;
        return this;
    }

    /**
     * Get the name of blob storage event type to process. Possible values include: 'Microsoft.Storage.BlobCreated', 'Microsoft.Storage.BlobRenamed'.
     *
     * @return the blobStorageEventType value
     */
    public BlobStorageEventType blobStorageEventType() {
        return this.blobStorageEventType;
    }

    /**
     * Set the name of blob storage event type to process. Possible values include: 'Microsoft.Storage.BlobCreated', 'Microsoft.Storage.BlobRenamed'.
     *
     * @param blobStorageEventType the blobStorageEventType value to set
     * @return the EventGridDataConnection object itself.
     */
    public EventGridDataConnection withBlobStorageEventType(BlobStorageEventType blobStorageEventType) {
        this.blobStorageEventType = blobStorageEventType;
        return this;
    }

    /**
     * Get the provisioned state of the resource. Possible values include: 'Running', 'Creating', 'Deleting', 'Succeeded', 'Failed', 'Moving'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

}
