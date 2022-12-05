// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.data.cosmos.core.convert;

import com.azure.spring.data.cosmos.core.mapping.CosmosSimpleTypes;
import org.springframework.data.convert.CustomConversions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CosmosCustomConventions extends CustomConversions {

    private static final StoreConversions STORE_CONVERSIONS;
    private static final List<Object> STORE_CONVERTERS;

    static {

        List<Object> converters = new ArrayList<>();

        STORE_CONVERTERS = Collections.unmodifiableList(converters);
        STORE_CONVERSIONS = StoreConversions.of(CosmosSimpleTypes.HOLDER, STORE_CONVERTERS);
    }


    public CosmosCustomConventions() {
        this(Collections.emptyList());
    }

    public CosmosCustomConventions(List<?> converters) {
        super(STORE_CONVERSIONS, converters);
    }

}
