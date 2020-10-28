/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.netapp.v2020_07_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.netapp.v2020_07_01.BackupPolicies;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import java.util.List;
import com.microsoft.azure.management.netapp.v2020_07_01.BackupPolicy;

class BackupPoliciesImpl extends WrapperImpl<BackupPoliciesInner> implements BackupPolicies {
    private final NetAppManager manager;

    BackupPoliciesImpl(NetAppManager manager) {
        super(manager.inner().backupPolicies());
        this.manager = manager;
    }

    public NetAppManager manager() {
        return this.manager;
    }

    @Override
    public BackupPolicyImpl define(String name) {
        return wrapModel(name);
    }

    private BackupPolicyImpl wrapModel(BackupPolicyInner inner) {
        return  new BackupPolicyImpl(inner, manager());
    }

    private BackupPolicyImpl wrapModel(String name) {
        return new BackupPolicyImpl(name, this.manager());
    }

    @Override
    public Observable<BackupPolicy> listAsync(String resourceGroupName, String accountName) {
        BackupPoliciesInner client = this.inner();
        return client.listAsync(resourceGroupName, accountName)
        .flatMap(new Func1<List<BackupPolicyInner>, Observable<BackupPolicyInner>>() {
            @Override
            public Observable<BackupPolicyInner> call(List<BackupPolicyInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<BackupPolicyInner, BackupPolicy>() {
            @Override
            public BackupPolicy call(BackupPolicyInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<BackupPolicy> getAsync(String resourceGroupName, String accountName, String backupPolicyName) {
        BackupPoliciesInner client = this.inner();
        return client.getAsync(resourceGroupName, accountName, backupPolicyName)
        .flatMap(new Func1<BackupPolicyInner, Observable<BackupPolicy>>() {
            @Override
            public Observable<BackupPolicy> call(BackupPolicyInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((BackupPolicy)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String accountName, String backupPolicyName) {
        BackupPoliciesInner client = this.inner();
        return client.deleteAsync(resourceGroupName, accountName, backupPolicyName).toCompletable();
    }

}
