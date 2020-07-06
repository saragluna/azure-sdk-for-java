// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.spring.data.gremlin.common.domain;

import com.microsoft.spring.data.gremlin.annotation.Vertex;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Vertex
public class GroupOwner {

    @Id
    private String name;

    private Integer expireDays;

    public GroupOwner() {
    }

    public GroupOwner(String name, Integer expireDays) {
        this.name = name;
        this.expireDays = expireDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(Integer expireDays) {
        this.expireDays = expireDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupOwner that = (GroupOwner) o;
        return Objects.equals(name, that.name)
            && Objects.equals(expireDays, that.expireDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expireDays);
    }
}
