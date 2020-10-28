/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databoxedge.v2019_08_01.implementation;

import com.microsoft.azure.management.databoxedge.v2019_08_01.DataBoxEdgeDeviceExtendedInfo;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;

class DataBoxEdgeDeviceExtendedInfoImpl extends WrapperImpl<DataBoxEdgeDeviceExtendedInfoInner> implements DataBoxEdgeDeviceExtendedInfo {
    private final DataBoxEdgeManager manager;
    DataBoxEdgeDeviceExtendedInfoImpl(DataBoxEdgeDeviceExtendedInfoInner inner, DataBoxEdgeManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public DataBoxEdgeManager manager() {
        return this.manager;
    }

    @Override
    public String encryptionKey() {
        return this.inner().encryptionKey();
    }

    @Override
    public String encryptionKeyThumbprint() {
        return this.inner().encryptionKeyThumbprint();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String resourceKey() {
        return this.inner().resourceKey();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
