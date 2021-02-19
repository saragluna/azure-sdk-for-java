// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.integration.eventhub.converter;

import com.azure.messaging.eventhubs.EventData;
import com.azure.spring.integration.core.AzureHeaders;
import com.azure.spring.integration.core.EventHubHeaders;
import com.azure.spring.integration.core.converter.AzureMessageConverter;
import com.azure.spring.integration.test.support.AzureMessageConverterTest;
import org.junit.Test;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.NativeMessageHeaderAccessor;
import org.springframework.util.LinkedMultiValueMap;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventHubMessageConverterTest extends AzureMessageConverterTest<EventData> {

    private static final String EVENT_DATA = "event-hub-test-string";
    private static final String RAW_PARTITION_ID = "1";
    private static final String NATIVE_HEADERS_SPAN_ID_KEY = "spanId";
    private static final List<String> NATIVE_HEADERS_SPAN_ID_VALUE = Arrays.asList("spanId-1", "spanId-2");
    private static final String NATIVE_HEADERS_SPAN_TRACE_ID_KEY = "spanTraceId";
    private static final List<String> NATIVE_HEADERS_SPAN_TRACE_ID_VALUE = Arrays
            .asList("spanTraceId-1", "spanTraceId-2");
    private static final Instant ENQUEUED_TIME = Instant.now().minus(1, ChronoUnit.DAYS);
    private static final Long OFFSET = 1234567890L;
    private static final Long SEQUENCE_NUMBER = 1234567890L;
    
    @Override
    protected EventData getInstance() {
        return new EventData(this.payload.getBytes());
    }

    @Override
    public AzureMessageConverter<EventData> getConverter() {
        return new EventHubMessageConverter();
    }

    @Override
    protected Class<EventData> getTargetClass() {
        return EventData.class;
    }

    private static class MyEventHubMessageConverter extends EventHubMessageConverter {

        public void setCustomHeaders(MessageHeaders headers, EventData azureMessage) {
            super.setCustomHeaders(headers, azureMessage);
        }

        public Map<String, Object> buildCustomHeaders(EventData azureMessage) {
            return super.buildCustomHeaders(azureMessage);
        }
    }

    @Test
    public void testSetCustomHeadersWithCommon() {
        EventData eventData = new EventData(EVENT_DATA);
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put(AzureHeaders.RAW_PARTITION_ID, RAW_PARTITION_ID);
        MessageHeaders headers = new MessageHeaders(headerMap);

        MyEventHubMessageConverter convert = new MyEventHubMessageConverter();
        convert.setCustomHeaders(headers, eventData);
        assertEquals(eventData.getProperties().get(AzureHeaders.RAW_PARTITION_ID), RAW_PARTITION_ID);
        assertEquals(eventData.getBodyAsString(), EVENT_DATA);
    }

    @Test
    public void testSetCustomHeadersWithNativesHeader() {
        EventData eventData = new EventData(EVENT_DATA);
        Map<String, Object> headerMap = new HashMap<>();
        LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<>();
        linkedMultiValueMap.put(NATIVE_HEADERS_SPAN_ID_KEY, NATIVE_HEADERS_SPAN_ID_VALUE);
        linkedMultiValueMap.put(NATIVE_HEADERS_SPAN_TRACE_ID_KEY, NATIVE_HEADERS_SPAN_TRACE_ID_VALUE);
        headerMap.put(NativeMessageHeaderAccessor.NATIVE_HEADERS, linkedMultiValueMap);
        MessageHeaders headers = new MessageHeaders(headerMap);

        MyEventHubMessageConverter convert = new MyEventHubMessageConverter();
        convert.setCustomHeaders(headers, eventData);
        assertEquals(eventData.getProperties().get(NativeMessageHeaderAccessor.NATIVE_HEADERS).getClass(),
                String.class);
    }

    @Test
    public void testBuildCustomHeadersWithCommon() {
        EventData eventData = new EventData(EVENT_DATA);
        eventData.getProperties().put(AzureHeaders.RAW_PARTITION_ID, RAW_PARTITION_ID);
        MyEventHubMessageConverter convert = new MyEventHubMessageConverter();
        Map<String, Object> headerHeadersMap = convert.buildCustomHeaders(eventData);
        assertEquals(headerHeadersMap.get(AzureHeaders.RAW_PARTITION_ID), RAW_PARTITION_ID);
        assertEquals(eventData.getBodyAsString(), EVENT_DATA);
    }

    @Test
    public void testBuildCustomHeadersWithNativeHeaders() {
        EventData eventData = new EventData(EVENT_DATA);
        String nativeHeadersString = "{\"spanId\":[\"spanId-1\", \"spanId-2\"],"
            + "\"spanTraceId\":[\"spanTraceId-1\", \"spanTraceId-2\"]}";
        eventData.getProperties().put(NativeMessageHeaderAccessor.NATIVE_HEADERS, nativeHeadersString);

        MyEventHubMessageConverter convert = new MyEventHubMessageConverter();
        Map<String, Object> headerHeadersMap = convert.buildCustomHeaders(eventData);
        assertEquals(headerHeadersMap.get(NativeMessageHeaderAccessor.NATIVE_HEADERS).getClass(),
                LinkedMultiValueMap.class);
    }

    @Test
    public void testSetCustomHeadersWithSystemProperties() {
        EventData eventData = new EventData(EVENT_DATA);
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put(EventHubHeaders.ENQUEUED_TIME, ENQUEUED_TIME);
        headerMap.put(EventHubHeaders.OFFSET, OFFSET);
        headerMap.put(EventHubHeaders.SEQUENCE_NUMBER, SEQUENCE_NUMBER);
        headerMap.put(AzureHeaders.RAW_PARTITION_ID, RAW_PARTITION_ID);
        MessageHeaders headers = new MessageHeaders(headerMap);

        MyEventHubMessageConverter convert = new MyEventHubMessageConverter();
        convert.setCustomHeaders(headers, eventData);
        assertFalse(eventData.getSystemProperties().containsKey(EventHubHeaders.ENQUEUED_TIME));
        assertFalse(eventData.getSystemProperties().containsKey(EventHubHeaders.OFFSET));
        assertFalse(eventData.getSystemProperties().containsKey(EventHubHeaders.SEQUENCE_NUMBER));
        assertFalse(eventData.getSystemProperties().containsKey(AzureHeaders.RAW_PARTITION_ID));

        assertFalse(eventData.getProperties().containsKey(EventHubHeaders.ENQUEUED_TIME));
        assertFalse(eventData.getProperties().containsKey(EventHubHeaders.OFFSET));
        assertFalse(eventData.getProperties().containsKey(EventHubHeaders.SEQUENCE_NUMBER));
        assertTrue(eventData.getProperties().containsKey(AzureHeaders.RAW_PARTITION_ID));
        assertEquals(eventData.getProperties().get(AzureHeaders.RAW_PARTITION_ID), RAW_PARTITION_ID);
    }

    @Test
    public void testBuildCustomHeadersWithSystemProperties() {
        EventData eventData = new EventData(EVENT_DATA);
        eventData.getProperties().put(AzureHeaders.RAW_PARTITION_ID, RAW_PARTITION_ID);
        MyEventHubMessageConverter convert = new MyEventHubMessageConverter();
        Map<String, Object> headerHeadersMap = convert.buildCustomHeaders(eventData);
        assertEquals(headerHeadersMap.get(AzureHeaders.RAW_PARTITION_ID), RAW_PARTITION_ID);
        assertTrue(headerHeadersMap.containsKey(EventHubHeaders.ENQUEUED_TIME));
        assertTrue(headerHeadersMap.containsKey(EventHubHeaders.OFFSET));
        assertTrue(headerHeadersMap.containsKey(EventHubHeaders.SEQUENCE_NUMBER));
    }
}
