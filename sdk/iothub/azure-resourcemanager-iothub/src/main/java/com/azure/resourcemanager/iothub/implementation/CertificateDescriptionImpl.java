// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.iothub.implementation;

import com.azure.core.util.Context;
import com.azure.resourcemanager.iothub.fluent.models.CertificateDescriptionInner;
import com.azure.resourcemanager.iothub.models.CertificateBodyDescription;
import com.azure.resourcemanager.iothub.models.CertificateDescription;
import com.azure.resourcemanager.iothub.models.CertificateProperties;

public final class CertificateDescriptionImpl
    implements CertificateDescription, CertificateDescription.Definition, CertificateDescription.Update {
    private CertificateDescriptionInner innerObject;

    private final com.azure.resourcemanager.iothub.IotHubManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public CertificateProperties properties() {
        return this.innerModel().properties();
    }

    public String etag() {
        return this.innerModel().etag();
    }

    public CertificateDescriptionInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.iothub.IotHubManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String resourceName;

    private String certificateName;

    private String createIfMatch;

    private CertificateBodyDescription createCertificateDescription;

    private String updateIfMatch;

    private CertificateBodyDescription updateCertificateDescription;

    public CertificateDescriptionImpl withExistingIotHub(String resourceGroupName, String resourceName) {
        this.resourceGroupName = resourceGroupName;
        this.resourceName = resourceName;
        return this;
    }

    public CertificateDescription create() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getCertificates()
                .createOrUpdateWithResponse(
                    resourceGroupName,
                    resourceName,
                    certificateName,
                    createCertificateDescription,
                    createIfMatch,
                    Context.NONE)
                .getValue();
        return this;
    }

    public CertificateDescription create(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getCertificates()
                .createOrUpdateWithResponse(
                    resourceGroupName,
                    resourceName,
                    certificateName,
                    createCertificateDescription,
                    createIfMatch,
                    context)
                .getValue();
        return this;
    }

    CertificateDescriptionImpl(String name, com.azure.resourcemanager.iothub.IotHubManager serviceManager) {
        this.innerObject = new CertificateDescriptionInner();
        this.serviceManager = serviceManager;
        this.certificateName = name;
        this.createIfMatch = null;
        this.createCertificateDescription = new CertificateBodyDescription();
    }

    public CertificateDescriptionImpl update() {
        this.updateIfMatch = null;
        this.updateCertificateDescription = new CertificateBodyDescription();
        return this;
    }

    public CertificateDescription apply() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getCertificates()
                .createOrUpdateWithResponse(
                    resourceGroupName,
                    resourceName,
                    certificateName,
                    updateCertificateDescription,
                    updateIfMatch,
                    Context.NONE)
                .getValue();
        return this;
    }

    public CertificateDescription apply(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getCertificates()
                .createOrUpdateWithResponse(
                    resourceGroupName,
                    resourceName,
                    certificateName,
                    updateCertificateDescription,
                    updateIfMatch,
                    context)
                .getValue();
        return this;
    }

    CertificateDescriptionImpl(
        CertificateDescriptionInner innerObject, com.azure.resourcemanager.iothub.IotHubManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = Utils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.resourceName = Utils.getValueFromIdByName(innerObject.id(), "IotHubs");
        this.certificateName = Utils.getValueFromIdByName(innerObject.id(), "certificates");
    }

    public CertificateDescription refresh() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getCertificates()
                .getWithResponse(resourceGroupName, resourceName, certificateName, Context.NONE)
                .getValue();
        return this;
    }

    public CertificateDescription refresh(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getCertificates()
                .getWithResponse(resourceGroupName, resourceName, certificateName, context)
                .getValue();
        return this;
    }

    public CertificateDescriptionImpl withCertificate(String certificate) {
        if (isInCreateMode()) {
            this.createCertificateDescription.withCertificate(certificate);
            return this;
        } else {
            this.updateCertificateDescription.withCertificate(certificate);
            return this;
        }
    }

    public CertificateDescriptionImpl withIfMatch(String ifMatch) {
        if (isInCreateMode()) {
            this.createIfMatch = ifMatch;
            return this;
        } else {
            this.updateIfMatch = ifMatch;
            return this;
        }
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
