// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.integration.eventhub.converter;

import com.azure.messaging.eventhubs.EventData;
import com.azure.spring.integration.core.EventHubHeaders;
import com.azure.spring.integration.core.converter.AbstractAzureMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.NativeMessageHeaderAccessor;
import org.springframework.util.LinkedMultiValueMap;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A converter to turn a {@link Message} to {@link EventData} and vice versa.
 *
 * @author Warren Zhu
 */
public class EventHubMessageConverter extends AbstractAzureMessageConverter<EventData> {

    private static final Logger LOG = LoggerFactory.getLogger(EventHubMessageConverter.class);

    private static final Set<String> SYSTEM_HEADERS = Collections.unmodifiableSet(new HashSet<>(
        Arrays.asList(EventHubHeaders.ENQUEUED_TIME, EventHubHeaders.OFFSET, EventHubHeaders.SEQUENCE_NUMBER)));

    @Override
    protected byte[] getPayload(EventData azureMessage) {
        return azureMessage.getBody();
    }

    @Override
    protected EventData fromString(String payload) {
        return new EventData(payload.getBytes(Charset.defaultCharset()));
    }

    @Override
    protected EventData fromByte(byte[] payload) {
        return new EventData(payload);
    }

    @Override
    protected void setCustomHeaders(MessageHeaders headers, EventData azureMessage) {
        super.setCustomHeaders(headers, azureMessage);
        headers.forEach((key, value) -> {
            if (key.equals(NativeMessageHeaderAccessor.NATIVE_HEADERS)
                    && value instanceof LinkedMultiValueMap) {
                azureMessage.getProperties().put(key, toJson(value));
            } else {
                if (!SYSTEM_HEADERS.contains(key)) {
                    azureMessage.getProperties().put(key, value.toString());
                } else {
                    LOG.warn("System property {}({}) is not allowed to be defined and will be ignored.", key, value);
                }
            }
        });
    }

    @Override
    protected Map<String, Object> buildCustomHeaders(EventData azureMessage) {
        Map<String, Object> headers = super.buildCustomHeaders(azureMessage);

        headers.putAll(getSystemProperties(azureMessage));

        Map<String, Object> properties = azureMessage.getProperties();
        if (properties.containsKey(NativeMessageHeaderAccessor.NATIVE_HEADERS)
                && isValidJson(properties.get(NativeMessageHeaderAccessor.NATIVE_HEADERS))) {
            String nativeHeader = (String) properties.remove(NativeMessageHeaderAccessor.NATIVE_HEADERS);
            properties.put(NativeMessageHeaderAccessor.NATIVE_HEADERS,
                    readValue(nativeHeader, LinkedMultiValueMap.class));
        }
        headers.putAll(azureMessage.getProperties());
        return headers;
    }

    private Map<String, Object> getSystemProperties(EventData azureMessage) {
        Map<String, Object> result = new HashMap<>();
        result.put(EventHubHeaders.ENQUEUED_TIME, azureMessage.getEnqueuedTime());
        result.put(EventHubHeaders.OFFSET, azureMessage.getOffset());
        result.put(EventHubHeaders.SEQUENCE_NUMBER, azureMessage.getSequenceNumber());
        result.put(EventHubHeaders.PARTITION_KEY, azureMessage.getPartitionKey());
        return result;
    }
}
