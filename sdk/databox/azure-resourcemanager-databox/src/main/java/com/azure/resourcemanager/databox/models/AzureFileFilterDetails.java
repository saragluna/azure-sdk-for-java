// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databox.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Filter details to transfer Azure files. */
@Fluent
public final class AzureFileFilterDetails {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(AzureFileFilterDetails.class);

    /*
     * Prefix list of the Azure files to be transferred.
     */
    @JsonProperty(value = "filePrefixList")
    private List<String> filePrefixList;

    /*
     * List of full path of the files to be transferred.
     */
    @JsonProperty(value = "filePathList")
    private List<String> filePathList;

    /*
     * List of file shares to be transferred.
     */
    @JsonProperty(value = "fileShareList")
    private List<String> fileShareList;

    /**
     * Get the filePrefixList property: Prefix list of the Azure files to be transferred.
     *
     * @return the filePrefixList value.
     */
    public List<String> filePrefixList() {
        return this.filePrefixList;
    }

    /**
     * Set the filePrefixList property: Prefix list of the Azure files to be transferred.
     *
     * @param filePrefixList the filePrefixList value to set.
     * @return the AzureFileFilterDetails object itself.
     */
    public AzureFileFilterDetails withFilePrefixList(List<String> filePrefixList) {
        this.filePrefixList = filePrefixList;
        return this;
    }

    /**
     * Get the filePathList property: List of full path of the files to be transferred.
     *
     * @return the filePathList value.
     */
    public List<String> filePathList() {
        return this.filePathList;
    }

    /**
     * Set the filePathList property: List of full path of the files to be transferred.
     *
     * @param filePathList the filePathList value to set.
     * @return the AzureFileFilterDetails object itself.
     */
    public AzureFileFilterDetails withFilePathList(List<String> filePathList) {
        this.filePathList = filePathList;
        return this;
    }

    /**
     * Get the fileShareList property: List of file shares to be transferred.
     *
     * @return the fileShareList value.
     */
    public List<String> fileShareList() {
        return this.fileShareList;
    }

    /**
     * Set the fileShareList property: List of file shares to be transferred.
     *
     * @param fileShareList the fileShareList value to set.
     * @return the AzureFileFilterDetails object itself.
     */
    public AzureFileFilterDetails withFileShareList(List<String> fileShareList) {
        this.fileShareList = fileShareList;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
