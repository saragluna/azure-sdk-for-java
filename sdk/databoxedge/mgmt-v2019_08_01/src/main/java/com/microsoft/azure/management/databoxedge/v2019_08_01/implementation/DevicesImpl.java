/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.databoxedge.v2019_08_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.databoxedge.v2019_08_01.Devices;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.management.databoxedge.v2019_08_01.DataBoxEdgeDevice;
import com.microsoft.azure.Page;
import rx.Completable;
import com.microsoft.azure.management.databoxedge.v2019_08_01.DataBoxEdgeDeviceExtendedInfo;
import com.microsoft.azure.management.databoxedge.v2019_08_01.UpdateSummary;
import com.microsoft.azure.management.databoxedge.v2019_08_01.UploadCertificateResponse;
import com.microsoft.azure.management.databoxedge.v2019_08_01.UploadCertificateRequest;
import com.microsoft.azure.management.databoxedge.v2019_08_01.NetworkSettings;
import com.microsoft.azure.management.databoxedge.v2019_08_01.SecuritySettings;

class DevicesImpl extends WrapperImpl<DevicesInner> implements Devices {
    private final DataBoxEdgeManager manager;

    DevicesImpl(DataBoxEdgeManager manager) {
        super(manager.inner().devices());
        this.manager = manager;
    }

    public DataBoxEdgeManager manager() {
        return this.manager;
    }

    @Override
    public DataBoxEdgeDeviceImpl defineDataBoxEdgeDevice(String name) {
        return wrapDataBoxEdgeDeviceModel(name);
    }

    private DataBoxEdgeDeviceImpl wrapDataBoxEdgeDeviceModel(String name) {
        return new DataBoxEdgeDeviceImpl(name, new DataBoxEdgeDeviceInner(), this.manager());
    }

    private DataBoxEdgeDeviceImpl wrapDataBoxEdgeDeviceModel(DataBoxEdgeDeviceInner inner) {
        return  new DataBoxEdgeDeviceImpl(inner.name(), inner, manager());
    }

    private Observable<DataBoxEdgeDeviceInner> getDataBoxEdgeDeviceInnerUsingDevicesInnerAsync(String resourceGroupName, String name) {
        DevicesInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    public Observable<DataBoxEdgeDevice> getByResourceGroupAsync(String resourceGroupName, String name) {
        return this.getDataBoxEdgeDeviceInnerUsingDevicesInnerAsync(resourceGroupName, name).flatMap(new Func1<DataBoxEdgeDeviceInner, Observable<DataBoxEdgeDevice>> () {
            @Override
            public Observable<DataBoxEdgeDevice> call(DataBoxEdgeDeviceInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return  Observable.just((DataBoxEdgeDevice)wrapDataBoxEdgeDeviceModel(inner));
                }
            }
        });
    }

    @Override
    public Observable<DataBoxEdgeDevice> listByResourceGroupAsync(String resourceGroupName) {
        DevicesInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<DataBoxEdgeDeviceInner>, Iterable<DataBoxEdgeDeviceInner>>() {
            @Override
            public Iterable<DataBoxEdgeDeviceInner> call(Page<DataBoxEdgeDeviceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<DataBoxEdgeDeviceInner, DataBoxEdgeDevice>() {
            @Override
            public DataBoxEdgeDevice call(DataBoxEdgeDeviceInner inner) {
                return wrapDataBoxEdgeDeviceModel(inner);
            }
        });
    }

    @Override
    public Observable<DataBoxEdgeDevice> listAsync() {
        DevicesInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<DataBoxEdgeDeviceInner>, Iterable<DataBoxEdgeDeviceInner>>() {
            @Override
            public Iterable<DataBoxEdgeDeviceInner> call(Page<DataBoxEdgeDeviceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<DataBoxEdgeDeviceInner, DataBoxEdgeDevice>() {
            @Override
            public DataBoxEdgeDevice call(DataBoxEdgeDeviceInner inner) {
                return wrapDataBoxEdgeDeviceModel(inner);
            }
        });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String name) {
        return this.inner().deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Completable downloadUpdatesAsync(String deviceName, String resourceGroupName) {
        DevicesInner client = this.inner();
        return client.downloadUpdatesAsync(deviceName, resourceGroupName).toCompletable();
    }

    @Override
    public Observable<DataBoxEdgeDeviceExtendedInfo> getExtendedInformationAsync(String deviceName, String resourceGroupName) {
        DevicesInner client = this.inner();
        return client.getExtendedInformationAsync(deviceName, resourceGroupName)
        .map(new Func1<DataBoxEdgeDeviceExtendedInfoInner, DataBoxEdgeDeviceExtendedInfo>() {
            @Override
            public DataBoxEdgeDeviceExtendedInfo call(DataBoxEdgeDeviceExtendedInfoInner inner) {
                return new DataBoxEdgeDeviceExtendedInfoImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable installUpdatesAsync(String deviceName, String resourceGroupName) {
        DevicesInner client = this.inner();
        return client.installUpdatesAsync(deviceName, resourceGroupName).toCompletable();
    }

    @Override
    public Completable scanForUpdatesAsync(String deviceName, String resourceGroupName) {
        DevicesInner client = this.inner();
        return client.scanForUpdatesAsync(deviceName, resourceGroupName).toCompletable();
    }

    @Override
    public Observable<UpdateSummary> getUpdateSummaryAsync(String deviceName, String resourceGroupName) {
        DevicesInner client = this.inner();
        return client.getUpdateSummaryAsync(deviceName, resourceGroupName)
        .map(new Func1<UpdateSummaryInner, UpdateSummary>() {
            @Override
            public UpdateSummary call(UpdateSummaryInner inner) {
                return new UpdateSummaryImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<UploadCertificateResponse> uploadCertificateAsync(String deviceName, String resourceGroupName, UploadCertificateRequest parameters) {
        DevicesInner client = this.inner();
        return client.uploadCertificateAsync(deviceName, resourceGroupName, parameters)
        .map(new Func1<UploadCertificateResponseInner, UploadCertificateResponse>() {
            @Override
            public UploadCertificateResponse call(UploadCertificateResponseInner inner) {
                return new UploadCertificateResponseImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<NetworkSettings> getNetworkSettingsAsync(String deviceName, String resourceGroupName) {
        DevicesInner client = this.inner();
        return client.getNetworkSettingsAsync(deviceName, resourceGroupName)
        .map(new Func1<NetworkSettingsInner, NetworkSettings>() {
            @Override
            public NetworkSettings call(NetworkSettingsInner inner) {
                return new NetworkSettingsImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable createOrUpdateSecuritySettingsAsync(String deviceName, String resourceGroupName, SecuritySettings securitySettings) {
        DevicesInner client = this.inner();
        return client.createOrUpdateSecuritySettingsAsync(deviceName, resourceGroupName, securitySettings).toCompletable();
    }

}
