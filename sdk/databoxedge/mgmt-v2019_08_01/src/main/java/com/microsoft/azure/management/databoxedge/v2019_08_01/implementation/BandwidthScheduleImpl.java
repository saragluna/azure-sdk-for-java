/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databoxedge.v2019_08_01.implementation;

import com.microsoft.azure.management.databoxedge.v2019_08_01.BandwidthSchedule;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import java.util.List;
import com.microsoft.azure.management.databoxedge.v2019_08_01.DayOfWeek;

class BandwidthScheduleImpl extends CreatableUpdatableImpl<BandwidthSchedule, BandwidthScheduleInner, BandwidthScheduleImpl> implements BandwidthSchedule, BandwidthSchedule.Definition, BandwidthSchedule.Update {
    private final DataBoxEdgeManager manager;
    private String deviceName;
    private String name;
    private String resourceGroupName;

    BandwidthScheduleImpl(String name, DataBoxEdgeManager manager) {
        super(name, new BandwidthScheduleInner());
        this.manager = manager;
        // Set resource name
        this.name = name;
        //
    }

    BandwidthScheduleImpl(BandwidthScheduleInner inner, DataBoxEdgeManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.name = inner.name();
        // set resource ancestor and positional variables
        this.deviceName = IdParsingUtils.getValueFromIdByName(inner.id(), "dataBoxEdgeDevices");
        this.name = IdParsingUtils.getValueFromIdByName(inner.id(), "bandwidthSchedules");
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        //
    }

    @Override
    public DataBoxEdgeManager manager() {
        return this.manager;
    }

    @Override
    public Observable<BandwidthSchedule> createResourceAsync() {
        BandwidthSchedulesInner client = this.manager().inner().bandwidthSchedules();
        return client.createOrUpdateAsync(this.deviceName, this.name, this.resourceGroupName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<BandwidthSchedule> updateResourceAsync() {
        BandwidthSchedulesInner client = this.manager().inner().bandwidthSchedules();
        return client.createOrUpdateAsync(this.deviceName, this.name, this.resourceGroupName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<BandwidthScheduleInner> getInnerAsync() {
        BandwidthSchedulesInner client = this.manager().inner().bandwidthSchedules();
        return client.getAsync(this.deviceName, this.name, this.resourceGroupName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public List<DayOfWeek> days() {
        return this.inner().days();
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
    public int rateInMbps() {
        return this.inner().rateInMbps();
    }

    @Override
    public String start() {
        return this.inner().start();
    }

    @Override
    public String stop() {
        return this.inner().stop();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public BandwidthScheduleImpl withExistingDataBoxEdgeDevice(String deviceName, String resourceGroupName) {
        this.deviceName = deviceName;
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    @Override
    public BandwidthScheduleImpl withDays(List<DayOfWeek> days) {
        this.inner().withDays(days);
        return this;
    }

    @Override
    public BandwidthScheduleImpl withRateInMbps(int rateInMbps) {
        this.inner().withRateInMbps(rateInMbps);
        return this;
    }

    @Override
    public BandwidthScheduleImpl withStart(String start) {
        this.inner().withStart(start);
        return this;
    }

    @Override
    public BandwidthScheduleImpl withStop(String stop) {
        this.inner().withStop(stop);
        return this;
    }

}
