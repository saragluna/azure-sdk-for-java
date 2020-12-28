// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Sysctl settings for Linux agent nodes. */
@Fluent
public final class SysctlConfig {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SysctlConfig.class);

    /*
     * Sysctl setting net.core.somaxconn.
     */
    @JsonProperty(value = "netCoreSomaxconn")
    private Integer netCoreSomaxconn;

    /*
     * Sysctl setting net.core.netdev_max_backlog.
     */
    @JsonProperty(value = "netCoreNetdevMaxBacklog")
    private Integer netCoreNetdevMaxBacklog;

    /*
     * Sysctl setting net.core.rmem_max.
     */
    @JsonProperty(value = "netCoreRmemMax")
    private Integer netCoreRmemMax;

    /*
     * Sysctl setting net.core.wmem_max.
     */
    @JsonProperty(value = "netCoreWmemMax")
    private Integer netCoreWmemMax;

    /*
     * Sysctl setting net.core.optmem_max.
     */
    @JsonProperty(value = "netCoreOptmemMax")
    private Integer netCoreOptmemMax;

    /*
     * Sysctl setting net.ipv4.tcp_max_syn_backlog.
     */
    @JsonProperty(value = "netIpv4TcpMaxSynBacklog")
    private Integer netIpv4TcpMaxSynBacklog;

    /*
     * Sysctl setting net.ipv4.tcp_max_tw_buckets.
     */
    @JsonProperty(value = "netIpv4TcpMaxTwBuckets")
    private Integer netIpv4TcpMaxTwBuckets;

    /*
     * Sysctl setting net.ipv4.tcp_fin_timeout.
     */
    @JsonProperty(value = "netIpv4TcpFinTimeout")
    private Integer netIpv4TcpFinTimeout;

    /*
     * Sysctl setting net.ipv4.tcp_keepalive_time.
     */
    @JsonProperty(value = "netIpv4TcpKeepaliveTime")
    private Integer netIpv4TcpKeepaliveTime;

    /*
     * Sysctl setting net.ipv4.tcp_keepalive_probes.
     */
    @JsonProperty(value = "netIpv4TcpKeepaliveProbes")
    private Integer netIpv4TcpKeepaliveProbes;

    /*
     * Sysctl setting net.ipv4.tcp_keepalive_intvl.
     */
    @JsonProperty(value = "netIpv4TcpkeepaliveIntvl")
    private Integer netIpv4TcpkeepaliveIntvl;

    /*
     * Sysctl setting net.ipv4.tcp_rmem.
     */
    @JsonProperty(value = "netIpv4TcpRmem")
    private Integer netIpv4TcpRmem;

    /*
     * Sysctl setting net.ipv4.tcp_wmem.
     */
    @JsonProperty(value = "netIpv4TcpWmem")
    private Integer netIpv4TcpWmem;

    /*
     * Sysctl setting net.ipv4.tcp_tw_reuse.
     */
    @JsonProperty(value = "netIpv4TcpTwReuse")
    private Boolean netIpv4TcpTwReuse;

    /*
     * Sysctl setting net.ipv4.ip_local_port_range.
     */
    @JsonProperty(value = "netIpv4IpLocalPortRange")
    private String netIpv4IpLocalPortRange;

    /*
     * Sysctl setting net.ipv4.neigh.default.gc_thresh1.
     */
    @JsonProperty(value = "netIpv4NeighDefaultGcThresh1")
    private Integer netIpv4NeighDefaultGcThresh1;

    /*
     * Sysctl setting net.ipv4.neigh.default.gc_thresh2.
     */
    @JsonProperty(value = "netIpv4NeighDefaultGcThresh2")
    private Integer netIpv4NeighDefaultGcThresh2;

    /*
     * Sysctl setting net.ipv4.neigh.default.gc_thresh3.
     */
    @JsonProperty(value = "netIpv4NeighDefaultGcThresh3")
    private Integer netIpv4NeighDefaultGcThresh3;

    /*
     * Sysctl setting net.netfilter.nf_conntrack_max.
     */
    @JsonProperty(value = "netNetfilterNfConntrackMax")
    private Integer netNetfilterNfConntrackMax;

    /*
     * Sysctl setting net.netfilter.nf_conntrack_buckets.
     */
    @JsonProperty(value = "netNetfilterNfConntrackBuckets")
    private Integer netNetfilterNfConntrackBuckets;

    /*
     * Sysctl setting fs.inotify.max_user_watches.
     */
    @JsonProperty(value = "fsInotifyMaxUserWatches")
    private Integer fsInotifyMaxUserWatches;

    /*
     * Sysctl setting fs.file-max.
     */
    @JsonProperty(value = "fsFileMax")
    private Integer fsFileMax;

    /*
     * Sysctl setting fs.aio-max-nr.
     */
    @JsonProperty(value = "fsAioMaxNr")
    private Integer fsAioMaxNr;

    /*
     * Sysctl setting fs.nr_open.
     */
    @JsonProperty(value = "fsNrOpen")
    private Integer fsNrOpen;

    /*
     * Sysctl setting kernel.threads-max.
     */
    @JsonProperty(value = "kernelThreadsMax")
    private Integer kernelThreadsMax;

    /*
     * Sysctl setting vm.max_map_count.
     */
    @JsonProperty(value = "vmMaxMapCount")
    private Integer vmMaxMapCount;

    /*
     * Sysctl setting vm.swappiness.
     */
    @JsonProperty(value = "vmSwappiness")
    private Integer vmSwappiness;

    /*
     * Sysctl setting vm.vfs_cache_pressure.
     */
    @JsonProperty(value = "vmVfsCachePressure")
    private Integer vmVfsCachePressure;

    /**
     * Get the netCoreSomaxconn property: Sysctl setting net.core.somaxconn.
     *
     * @return the netCoreSomaxconn value.
     */
    public Integer netCoreSomaxconn() {
        return this.netCoreSomaxconn;
    }

    /**
     * Set the netCoreSomaxconn property: Sysctl setting net.core.somaxconn.
     *
     * @param netCoreSomaxconn the netCoreSomaxconn value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetCoreSomaxconn(Integer netCoreSomaxconn) {
        this.netCoreSomaxconn = netCoreSomaxconn;
        return this;
    }

    /**
     * Get the netCoreNetdevMaxBacklog property: Sysctl setting net.core.netdev_max_backlog.
     *
     * @return the netCoreNetdevMaxBacklog value.
     */
    public Integer netCoreNetdevMaxBacklog() {
        return this.netCoreNetdevMaxBacklog;
    }

    /**
     * Set the netCoreNetdevMaxBacklog property: Sysctl setting net.core.netdev_max_backlog.
     *
     * @param netCoreNetdevMaxBacklog the netCoreNetdevMaxBacklog value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetCoreNetdevMaxBacklog(Integer netCoreNetdevMaxBacklog) {
        this.netCoreNetdevMaxBacklog = netCoreNetdevMaxBacklog;
        return this;
    }

    /**
     * Get the netCoreRmemMax property: Sysctl setting net.core.rmem_max.
     *
     * @return the netCoreRmemMax value.
     */
    public Integer netCoreRmemMax() {
        return this.netCoreRmemMax;
    }

    /**
     * Set the netCoreRmemMax property: Sysctl setting net.core.rmem_max.
     *
     * @param netCoreRmemMax the netCoreRmemMax value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetCoreRmemMax(Integer netCoreRmemMax) {
        this.netCoreRmemMax = netCoreRmemMax;
        return this;
    }

    /**
     * Get the netCoreWmemMax property: Sysctl setting net.core.wmem_max.
     *
     * @return the netCoreWmemMax value.
     */
    public Integer netCoreWmemMax() {
        return this.netCoreWmemMax;
    }

    /**
     * Set the netCoreWmemMax property: Sysctl setting net.core.wmem_max.
     *
     * @param netCoreWmemMax the netCoreWmemMax value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetCoreWmemMax(Integer netCoreWmemMax) {
        this.netCoreWmemMax = netCoreWmemMax;
        return this;
    }

    /**
     * Get the netCoreOptmemMax property: Sysctl setting net.core.optmem_max.
     *
     * @return the netCoreOptmemMax value.
     */
    public Integer netCoreOptmemMax() {
        return this.netCoreOptmemMax;
    }

    /**
     * Set the netCoreOptmemMax property: Sysctl setting net.core.optmem_max.
     *
     * @param netCoreOptmemMax the netCoreOptmemMax value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetCoreOptmemMax(Integer netCoreOptmemMax) {
        this.netCoreOptmemMax = netCoreOptmemMax;
        return this;
    }

    /**
     * Get the netIpv4TcpMaxSynBacklog property: Sysctl setting net.ipv4.tcp_max_syn_backlog.
     *
     * @return the netIpv4TcpMaxSynBacklog value.
     */
    public Integer netIpv4TcpMaxSynBacklog() {
        return this.netIpv4TcpMaxSynBacklog;
    }

    /**
     * Set the netIpv4TcpMaxSynBacklog property: Sysctl setting net.ipv4.tcp_max_syn_backlog.
     *
     * @param netIpv4TcpMaxSynBacklog the netIpv4TcpMaxSynBacklog value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpMaxSynBacklog(Integer netIpv4TcpMaxSynBacklog) {
        this.netIpv4TcpMaxSynBacklog = netIpv4TcpMaxSynBacklog;
        return this;
    }

    /**
     * Get the netIpv4TcpMaxTwBuckets property: Sysctl setting net.ipv4.tcp_max_tw_buckets.
     *
     * @return the netIpv4TcpMaxTwBuckets value.
     */
    public Integer netIpv4TcpMaxTwBuckets() {
        return this.netIpv4TcpMaxTwBuckets;
    }

    /**
     * Set the netIpv4TcpMaxTwBuckets property: Sysctl setting net.ipv4.tcp_max_tw_buckets.
     *
     * @param netIpv4TcpMaxTwBuckets the netIpv4TcpMaxTwBuckets value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpMaxTwBuckets(Integer netIpv4TcpMaxTwBuckets) {
        this.netIpv4TcpMaxTwBuckets = netIpv4TcpMaxTwBuckets;
        return this;
    }

    /**
     * Get the netIpv4TcpFinTimeout property: Sysctl setting net.ipv4.tcp_fin_timeout.
     *
     * @return the netIpv4TcpFinTimeout value.
     */
    public Integer netIpv4TcpFinTimeout() {
        return this.netIpv4TcpFinTimeout;
    }

    /**
     * Set the netIpv4TcpFinTimeout property: Sysctl setting net.ipv4.tcp_fin_timeout.
     *
     * @param netIpv4TcpFinTimeout the netIpv4TcpFinTimeout value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpFinTimeout(Integer netIpv4TcpFinTimeout) {
        this.netIpv4TcpFinTimeout = netIpv4TcpFinTimeout;
        return this;
    }

    /**
     * Get the netIpv4TcpKeepaliveTime property: Sysctl setting net.ipv4.tcp_keepalive_time.
     *
     * @return the netIpv4TcpKeepaliveTime value.
     */
    public Integer netIpv4TcpKeepaliveTime() {
        return this.netIpv4TcpKeepaliveTime;
    }

    /**
     * Set the netIpv4TcpKeepaliveTime property: Sysctl setting net.ipv4.tcp_keepalive_time.
     *
     * @param netIpv4TcpKeepaliveTime the netIpv4TcpKeepaliveTime value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpKeepaliveTime(Integer netIpv4TcpKeepaliveTime) {
        this.netIpv4TcpKeepaliveTime = netIpv4TcpKeepaliveTime;
        return this;
    }

    /**
     * Get the netIpv4TcpKeepaliveProbes property: Sysctl setting net.ipv4.tcp_keepalive_probes.
     *
     * @return the netIpv4TcpKeepaliveProbes value.
     */
    public Integer netIpv4TcpKeepaliveProbes() {
        return this.netIpv4TcpKeepaliveProbes;
    }

    /**
     * Set the netIpv4TcpKeepaliveProbes property: Sysctl setting net.ipv4.tcp_keepalive_probes.
     *
     * @param netIpv4TcpKeepaliveProbes the netIpv4TcpKeepaliveProbes value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpKeepaliveProbes(Integer netIpv4TcpKeepaliveProbes) {
        this.netIpv4TcpKeepaliveProbes = netIpv4TcpKeepaliveProbes;
        return this;
    }

    /**
     * Get the netIpv4TcpkeepaliveIntvl property: Sysctl setting net.ipv4.tcp_keepalive_intvl.
     *
     * @return the netIpv4TcpkeepaliveIntvl value.
     */
    public Integer netIpv4TcpkeepaliveIntvl() {
        return this.netIpv4TcpkeepaliveIntvl;
    }

    /**
     * Set the netIpv4TcpkeepaliveIntvl property: Sysctl setting net.ipv4.tcp_keepalive_intvl.
     *
     * @param netIpv4TcpkeepaliveIntvl the netIpv4TcpkeepaliveIntvl value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpkeepaliveIntvl(Integer netIpv4TcpkeepaliveIntvl) {
        this.netIpv4TcpkeepaliveIntvl = netIpv4TcpkeepaliveIntvl;
        return this;
    }

    /**
     * Get the netIpv4TcpRmem property: Sysctl setting net.ipv4.tcp_rmem.
     *
     * @return the netIpv4TcpRmem value.
     */
    public Integer netIpv4TcpRmem() {
        return this.netIpv4TcpRmem;
    }

    /**
     * Set the netIpv4TcpRmem property: Sysctl setting net.ipv4.tcp_rmem.
     *
     * @param netIpv4TcpRmem the netIpv4TcpRmem value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpRmem(Integer netIpv4TcpRmem) {
        this.netIpv4TcpRmem = netIpv4TcpRmem;
        return this;
    }

    /**
     * Get the netIpv4TcpWmem property: Sysctl setting net.ipv4.tcp_wmem.
     *
     * @return the netIpv4TcpWmem value.
     */
    public Integer netIpv4TcpWmem() {
        return this.netIpv4TcpWmem;
    }

    /**
     * Set the netIpv4TcpWmem property: Sysctl setting net.ipv4.tcp_wmem.
     *
     * @param netIpv4TcpWmem the netIpv4TcpWmem value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpWmem(Integer netIpv4TcpWmem) {
        this.netIpv4TcpWmem = netIpv4TcpWmem;
        return this;
    }

    /**
     * Get the netIpv4TcpTwReuse property: Sysctl setting net.ipv4.tcp_tw_reuse.
     *
     * @return the netIpv4TcpTwReuse value.
     */
    public Boolean netIpv4TcpTwReuse() {
        return this.netIpv4TcpTwReuse;
    }

    /**
     * Set the netIpv4TcpTwReuse property: Sysctl setting net.ipv4.tcp_tw_reuse.
     *
     * @param netIpv4TcpTwReuse the netIpv4TcpTwReuse value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4TcpTwReuse(Boolean netIpv4TcpTwReuse) {
        this.netIpv4TcpTwReuse = netIpv4TcpTwReuse;
        return this;
    }

    /**
     * Get the netIpv4IpLocalPortRange property: Sysctl setting net.ipv4.ip_local_port_range.
     *
     * @return the netIpv4IpLocalPortRange value.
     */
    public String netIpv4IpLocalPortRange() {
        return this.netIpv4IpLocalPortRange;
    }

    /**
     * Set the netIpv4IpLocalPortRange property: Sysctl setting net.ipv4.ip_local_port_range.
     *
     * @param netIpv4IpLocalPortRange the netIpv4IpLocalPortRange value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4IpLocalPortRange(String netIpv4IpLocalPortRange) {
        this.netIpv4IpLocalPortRange = netIpv4IpLocalPortRange;
        return this;
    }

    /**
     * Get the netIpv4NeighDefaultGcThresh1 property: Sysctl setting net.ipv4.neigh.default.gc_thresh1.
     *
     * @return the netIpv4NeighDefaultGcThresh1 value.
     */
    public Integer netIpv4NeighDefaultGcThresh1() {
        return this.netIpv4NeighDefaultGcThresh1;
    }

    /**
     * Set the netIpv4NeighDefaultGcThresh1 property: Sysctl setting net.ipv4.neigh.default.gc_thresh1.
     *
     * @param netIpv4NeighDefaultGcThresh1 the netIpv4NeighDefaultGcThresh1 value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4NeighDefaultGcThresh1(Integer netIpv4NeighDefaultGcThresh1) {
        this.netIpv4NeighDefaultGcThresh1 = netIpv4NeighDefaultGcThresh1;
        return this;
    }

    /**
     * Get the netIpv4NeighDefaultGcThresh2 property: Sysctl setting net.ipv4.neigh.default.gc_thresh2.
     *
     * @return the netIpv4NeighDefaultGcThresh2 value.
     */
    public Integer netIpv4NeighDefaultGcThresh2() {
        return this.netIpv4NeighDefaultGcThresh2;
    }

    /**
     * Set the netIpv4NeighDefaultGcThresh2 property: Sysctl setting net.ipv4.neigh.default.gc_thresh2.
     *
     * @param netIpv4NeighDefaultGcThresh2 the netIpv4NeighDefaultGcThresh2 value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4NeighDefaultGcThresh2(Integer netIpv4NeighDefaultGcThresh2) {
        this.netIpv4NeighDefaultGcThresh2 = netIpv4NeighDefaultGcThresh2;
        return this;
    }

    /**
     * Get the netIpv4NeighDefaultGcThresh3 property: Sysctl setting net.ipv4.neigh.default.gc_thresh3.
     *
     * @return the netIpv4NeighDefaultGcThresh3 value.
     */
    public Integer netIpv4NeighDefaultGcThresh3() {
        return this.netIpv4NeighDefaultGcThresh3;
    }

    /**
     * Set the netIpv4NeighDefaultGcThresh3 property: Sysctl setting net.ipv4.neigh.default.gc_thresh3.
     *
     * @param netIpv4NeighDefaultGcThresh3 the netIpv4NeighDefaultGcThresh3 value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetIpv4NeighDefaultGcThresh3(Integer netIpv4NeighDefaultGcThresh3) {
        this.netIpv4NeighDefaultGcThresh3 = netIpv4NeighDefaultGcThresh3;
        return this;
    }

    /**
     * Get the netNetfilterNfConntrackMax property: Sysctl setting net.netfilter.nf_conntrack_max.
     *
     * @return the netNetfilterNfConntrackMax value.
     */
    public Integer netNetfilterNfConntrackMax() {
        return this.netNetfilterNfConntrackMax;
    }

    /**
     * Set the netNetfilterNfConntrackMax property: Sysctl setting net.netfilter.nf_conntrack_max.
     *
     * @param netNetfilterNfConntrackMax the netNetfilterNfConntrackMax value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetNetfilterNfConntrackMax(Integer netNetfilterNfConntrackMax) {
        this.netNetfilterNfConntrackMax = netNetfilterNfConntrackMax;
        return this;
    }

    /**
     * Get the netNetfilterNfConntrackBuckets property: Sysctl setting net.netfilter.nf_conntrack_buckets.
     *
     * @return the netNetfilterNfConntrackBuckets value.
     */
    public Integer netNetfilterNfConntrackBuckets() {
        return this.netNetfilterNfConntrackBuckets;
    }

    /**
     * Set the netNetfilterNfConntrackBuckets property: Sysctl setting net.netfilter.nf_conntrack_buckets.
     *
     * @param netNetfilterNfConntrackBuckets the netNetfilterNfConntrackBuckets value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withNetNetfilterNfConntrackBuckets(Integer netNetfilterNfConntrackBuckets) {
        this.netNetfilterNfConntrackBuckets = netNetfilterNfConntrackBuckets;
        return this;
    }

    /**
     * Get the fsInotifyMaxUserWatches property: Sysctl setting fs.inotify.max_user_watches.
     *
     * @return the fsInotifyMaxUserWatches value.
     */
    public Integer fsInotifyMaxUserWatches() {
        return this.fsInotifyMaxUserWatches;
    }

    /**
     * Set the fsInotifyMaxUserWatches property: Sysctl setting fs.inotify.max_user_watches.
     *
     * @param fsInotifyMaxUserWatches the fsInotifyMaxUserWatches value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withFsInotifyMaxUserWatches(Integer fsInotifyMaxUserWatches) {
        this.fsInotifyMaxUserWatches = fsInotifyMaxUserWatches;
        return this;
    }

    /**
     * Get the fsFileMax property: Sysctl setting fs.file-max.
     *
     * @return the fsFileMax value.
     */
    public Integer fsFileMax() {
        return this.fsFileMax;
    }

    /**
     * Set the fsFileMax property: Sysctl setting fs.file-max.
     *
     * @param fsFileMax the fsFileMax value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withFsFileMax(Integer fsFileMax) {
        this.fsFileMax = fsFileMax;
        return this;
    }

    /**
     * Get the fsAioMaxNr property: Sysctl setting fs.aio-max-nr.
     *
     * @return the fsAioMaxNr value.
     */
    public Integer fsAioMaxNr() {
        return this.fsAioMaxNr;
    }

    /**
     * Set the fsAioMaxNr property: Sysctl setting fs.aio-max-nr.
     *
     * @param fsAioMaxNr the fsAioMaxNr value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withFsAioMaxNr(Integer fsAioMaxNr) {
        this.fsAioMaxNr = fsAioMaxNr;
        return this;
    }

    /**
     * Get the fsNrOpen property: Sysctl setting fs.nr_open.
     *
     * @return the fsNrOpen value.
     */
    public Integer fsNrOpen() {
        return this.fsNrOpen;
    }

    /**
     * Set the fsNrOpen property: Sysctl setting fs.nr_open.
     *
     * @param fsNrOpen the fsNrOpen value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withFsNrOpen(Integer fsNrOpen) {
        this.fsNrOpen = fsNrOpen;
        return this;
    }

    /**
     * Get the kernelThreadsMax property: Sysctl setting kernel.threads-max.
     *
     * @return the kernelThreadsMax value.
     */
    public Integer kernelThreadsMax() {
        return this.kernelThreadsMax;
    }

    /**
     * Set the kernelThreadsMax property: Sysctl setting kernel.threads-max.
     *
     * @param kernelThreadsMax the kernelThreadsMax value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withKernelThreadsMax(Integer kernelThreadsMax) {
        this.kernelThreadsMax = kernelThreadsMax;
        return this;
    }

    /**
     * Get the vmMaxMapCount property: Sysctl setting vm.max_map_count.
     *
     * @return the vmMaxMapCount value.
     */
    public Integer vmMaxMapCount() {
        return this.vmMaxMapCount;
    }

    /**
     * Set the vmMaxMapCount property: Sysctl setting vm.max_map_count.
     *
     * @param vmMaxMapCount the vmMaxMapCount value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withVmMaxMapCount(Integer vmMaxMapCount) {
        this.vmMaxMapCount = vmMaxMapCount;
        return this;
    }

    /**
     * Get the vmSwappiness property: Sysctl setting vm.swappiness.
     *
     * @return the vmSwappiness value.
     */
    public Integer vmSwappiness() {
        return this.vmSwappiness;
    }

    /**
     * Set the vmSwappiness property: Sysctl setting vm.swappiness.
     *
     * @param vmSwappiness the vmSwappiness value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withVmSwappiness(Integer vmSwappiness) {
        this.vmSwappiness = vmSwappiness;
        return this;
    }

    /**
     * Get the vmVfsCachePressure property: Sysctl setting vm.vfs_cache_pressure.
     *
     * @return the vmVfsCachePressure value.
     */
    public Integer vmVfsCachePressure() {
        return this.vmVfsCachePressure;
    }

    /**
     * Set the vmVfsCachePressure property: Sysctl setting vm.vfs_cache_pressure.
     *
     * @param vmVfsCachePressure the vmVfsCachePressure value to set.
     * @return the SysctlConfig object itself.
     */
    public SysctlConfig withVmVfsCachePressure(Integer vmVfsCachePressure) {
        this.vmVfsCachePressure = vmVfsCachePressure;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
