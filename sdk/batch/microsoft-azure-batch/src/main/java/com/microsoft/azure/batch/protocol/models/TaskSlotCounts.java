/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The TaskSlot counts for a Job.
 */
public class TaskSlotCounts {
    /**
     * The number of TaskSlots for active Tasks.
     */
    @JsonProperty(value = "active", required = true)
    private int active;

    /**
     * The number of TaskSlots for running Tasks.
     */
    @JsonProperty(value = "running", required = true)
    private int running;

    /**
     * The number of TaskSlots for completed Tasks.
     */
    @JsonProperty(value = "completed", required = true)
    private int completed;

    /**
     * The number of TaskSlots for succeeded Tasks.
     */
    @JsonProperty(value = "succeeded", required = true)
    private int succeeded;

    /**
     * The number of TaskSlots for failed Tasks.
     */
    @JsonProperty(value = "failed", required = true)
    private int failed;

    /**
     * Get the active value.
     *
     * @return the active value
     */
    public int active() {
        return this.active;
    }

    /**
     * Set the active value.
     *
     * @param active the active value to set
     * @return the TaskSlotCounts object itself.
     */
    public TaskSlotCounts withActive(int active) {
        this.active = active;
        return this;
    }

    /**
     * Get the running value.
     *
     * @return the running value
     */
    public int running() {
        return this.running;
    }

    /**
     * Set the running value.
     *
     * @param running the running value to set
     * @return the TaskSlotCounts object itself.
     */
    public TaskSlotCounts withRunning(int running) {
        this.running = running;
        return this;
    }

    /**
     * Get the completed value.
     *
     * @return the completed value
     */
    public int completed() {
        return this.completed;
    }

    /**
     * Set the completed value.
     *
     * @param completed the completed value to set
     * @return the TaskSlotCounts object itself.
     */
    public TaskSlotCounts withCompleted(int completed) {
        this.completed = completed;
        return this;
    }

    /**
     * Get the succeeded value.
     *
     * @return the succeeded value
     */
    public int succeeded() {
        return this.succeeded;
    }

    /**
     * Set the succeeded value.
     *
     * @param succeeded the succeeded value to set
     * @return the TaskSlotCounts object itself.
     */
    public TaskSlotCounts withSucceeded(int succeeded) {
        this.succeeded = succeeded;
        return this;
    }

    /**
     * Get the failed value.
     *
     * @return the failed value
     */
    public int failed() {
        return this.failed;
    }

    /**
     * Set the failed value.
     *
     * @param failed the failed value to set
     * @return the TaskSlotCounts object itself.
     */
    public TaskSlotCounts withFailed(int failed) {
        this.failed = failed;
        return this;
    }

}
