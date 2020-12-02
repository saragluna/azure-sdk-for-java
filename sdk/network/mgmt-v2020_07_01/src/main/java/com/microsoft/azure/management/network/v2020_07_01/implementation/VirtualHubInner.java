/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_07_01.implementation;

import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.v2020_07_01.VirtualHubRouteTable;
import com.microsoft.azure.management.network.v2020_07_01.ProvisioningState;
import java.util.List;
import com.microsoft.azure.management.network.v2020_07_01.RoutingState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * VirtualHub Resource.
 */
@JsonFlatten
@SkipParentValidation
public class VirtualHubInner extends Resource {
    /**
     * The VirtualWAN to which the VirtualHub belongs.
     */
    @JsonProperty(value = "properties.virtualWan")
    private SubResource virtualWan;

    /**
     * The VpnGateway associated with this VirtualHub.
     */
    @JsonProperty(value = "properties.vpnGateway")
    private SubResource vpnGateway;

    /**
     * The P2SVpnGateway associated with this VirtualHub.
     */
    @JsonProperty(value = "properties.p2SVpnGateway")
    private SubResource p2SVpnGateway;

    /**
     * The expressRouteGateway associated with this VirtualHub.
     */
    @JsonProperty(value = "properties.expressRouteGateway")
    private SubResource expressRouteGateway;

    /**
     * The azureFirewall associated with this VirtualHub.
     */
    @JsonProperty(value = "properties.azureFirewall")
    private SubResource azureFirewall;

    /**
     * The securityPartnerProvider associated with this VirtualHub.
     */
    @JsonProperty(value = "properties.securityPartnerProvider")
    private SubResource securityPartnerProvider;

    /**
     * Address-prefix for this VirtualHub.
     */
    @JsonProperty(value = "properties.addressPrefix")
    private String addressPrefix;

    /**
     * The routeTable associated with this virtual hub.
     */
    @JsonProperty(value = "properties.routeTable")
    private VirtualHubRouteTable routeTable;

    /**
     * The provisioning state of the virtual hub resource. Possible values
     * include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The Security Provider name.
     */
    @JsonProperty(value = "properties.securityProviderName")
    private String securityProviderName;

    /**
     * List of all virtual hub route table v2s associated with this VirtualHub.
     */
    @JsonProperty(value = "properties.virtualHubRouteTableV2s")
    private List<VirtualHubRouteTableV2Inner> virtualHubRouteTableV2s;

    /**
     * The sku of this VirtualHub.
     */
    @JsonProperty(value = "properties.sku")
    private String sku;

    /**
     * The routing state. Possible values include: 'None', 'Provisioned',
     * 'Provisioning', 'Failed'.
     */
    @JsonProperty(value = "properties.routingState")
    private RoutingState routingState;

    /**
     * List of references to Bgp Connections.
     */
    @JsonProperty(value = "properties.bgpConnections", access = JsonProperty.Access.WRITE_ONLY)
    private List<SubResource> bgpConnections;

    /**
     * List of references to IpConfigurations.
     */
    @JsonProperty(value = "properties.ipConfigurations", access = JsonProperty.Access.WRITE_ONLY)
    private List<SubResource> ipConfigurations;

    /**
     * VirtualRouter ASN.
     */
    @JsonProperty(value = "properties.virtualRouterAsn")
    private Long virtualRouterAsn;

    /**
     * VirtualRouter IPs.
     */
    @JsonProperty(value = "properties.virtualRouterIps")
    private List<String> virtualRouterIps;

    /**
     * Flag to control transit for VirtualRouter hub.
     */
    @JsonProperty(value = "properties.allowBranchToBranchTraffic")
    private Boolean allowBranchToBranchTraffic;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get the VirtualWAN to which the VirtualHub belongs.
     *
     * @return the virtualWan value
     */
    public SubResource virtualWan() {
        return this.virtualWan;
    }

    /**
     * Set the VirtualWAN to which the VirtualHub belongs.
     *
     * @param virtualWan the virtualWan value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withVirtualWan(SubResource virtualWan) {
        this.virtualWan = virtualWan;
        return this;
    }

    /**
     * Get the VpnGateway associated with this VirtualHub.
     *
     * @return the vpnGateway value
     */
    public SubResource vpnGateway() {
        return this.vpnGateway;
    }

    /**
     * Set the VpnGateway associated with this VirtualHub.
     *
     * @param vpnGateway the vpnGateway value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withVpnGateway(SubResource vpnGateway) {
        this.vpnGateway = vpnGateway;
        return this;
    }

    /**
     * Get the P2SVpnGateway associated with this VirtualHub.
     *
     * @return the p2SVpnGateway value
     */
    public SubResource p2SVpnGateway() {
        return this.p2SVpnGateway;
    }

    /**
     * Set the P2SVpnGateway associated with this VirtualHub.
     *
     * @param p2SVpnGateway the p2SVpnGateway value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withP2SVpnGateway(SubResource p2SVpnGateway) {
        this.p2SVpnGateway = p2SVpnGateway;
        return this;
    }

    /**
     * Get the expressRouteGateway associated with this VirtualHub.
     *
     * @return the expressRouteGateway value
     */
    public SubResource expressRouteGateway() {
        return this.expressRouteGateway;
    }

    /**
     * Set the expressRouteGateway associated with this VirtualHub.
     *
     * @param expressRouteGateway the expressRouteGateway value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withExpressRouteGateway(SubResource expressRouteGateway) {
        this.expressRouteGateway = expressRouteGateway;
        return this;
    }

    /**
     * Get the azureFirewall associated with this VirtualHub.
     *
     * @return the azureFirewall value
     */
    public SubResource azureFirewall() {
        return this.azureFirewall;
    }

    /**
     * Set the azureFirewall associated with this VirtualHub.
     *
     * @param azureFirewall the azureFirewall value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withAzureFirewall(SubResource azureFirewall) {
        this.azureFirewall = azureFirewall;
        return this;
    }

    /**
     * Get the securityPartnerProvider associated with this VirtualHub.
     *
     * @return the securityPartnerProvider value
     */
    public SubResource securityPartnerProvider() {
        return this.securityPartnerProvider;
    }

    /**
     * Set the securityPartnerProvider associated with this VirtualHub.
     *
     * @param securityPartnerProvider the securityPartnerProvider value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withSecurityPartnerProvider(SubResource securityPartnerProvider) {
        this.securityPartnerProvider = securityPartnerProvider;
        return this;
    }

    /**
     * Get address-prefix for this VirtualHub.
     *
     * @return the addressPrefix value
     */
    public String addressPrefix() {
        return this.addressPrefix;
    }

    /**
     * Set address-prefix for this VirtualHub.
     *
     * @param addressPrefix the addressPrefix value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withAddressPrefix(String addressPrefix) {
        this.addressPrefix = addressPrefix;
        return this;
    }

    /**
     * Get the routeTable associated with this virtual hub.
     *
     * @return the routeTable value
     */
    public VirtualHubRouteTable routeTable() {
        return this.routeTable;
    }

    /**
     * Set the routeTable associated with this virtual hub.
     *
     * @param routeTable the routeTable value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withRouteTable(VirtualHubRouteTable routeTable) {
        this.routeTable = routeTable;
        return this;
    }

    /**
     * Get the provisioning state of the virtual hub resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the Security Provider name.
     *
     * @return the securityProviderName value
     */
    public String securityProviderName() {
        return this.securityProviderName;
    }

    /**
     * Set the Security Provider name.
     *
     * @param securityProviderName the securityProviderName value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withSecurityProviderName(String securityProviderName) {
        this.securityProviderName = securityProviderName;
        return this;
    }

    /**
     * Get list of all virtual hub route table v2s associated with this VirtualHub.
     *
     * @return the virtualHubRouteTableV2s value
     */
    public List<VirtualHubRouteTableV2Inner> virtualHubRouteTableV2s() {
        return this.virtualHubRouteTableV2s;
    }

    /**
     * Set list of all virtual hub route table v2s associated with this VirtualHub.
     *
     * @param virtualHubRouteTableV2s the virtualHubRouteTableV2s value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withVirtualHubRouteTableV2s(List<VirtualHubRouteTableV2Inner> virtualHubRouteTableV2s) {
        this.virtualHubRouteTableV2s = virtualHubRouteTableV2s;
        return this;
    }

    /**
     * Get the sku of this VirtualHub.
     *
     * @return the sku value
     */
    public String sku() {
        return this.sku;
    }

    /**
     * Set the sku of this VirtualHub.
     *
     * @param sku the sku value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withSku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the routing state. Possible values include: 'None', 'Provisioned', 'Provisioning', 'Failed'.
     *
     * @return the routingState value
     */
    public RoutingState routingState() {
        return this.routingState;
    }

    /**
     * Set the routing state. Possible values include: 'None', 'Provisioned', 'Provisioning', 'Failed'.
     *
     * @param routingState the routingState value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withRoutingState(RoutingState routingState) {
        this.routingState = routingState;
        return this;
    }

    /**
     * Get list of references to Bgp Connections.
     *
     * @return the bgpConnections value
     */
    public List<SubResource> bgpConnections() {
        return this.bgpConnections;
    }

    /**
     * Get list of references to IpConfigurations.
     *
     * @return the ipConfigurations value
     */
    public List<SubResource> ipConfigurations() {
        return this.ipConfigurations;
    }

    /**
     * Get virtualRouter ASN.
     *
     * @return the virtualRouterAsn value
     */
    public Long virtualRouterAsn() {
        return this.virtualRouterAsn;
    }

    /**
     * Set virtualRouter ASN.
     *
     * @param virtualRouterAsn the virtualRouterAsn value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withVirtualRouterAsn(Long virtualRouterAsn) {
        this.virtualRouterAsn = virtualRouterAsn;
        return this;
    }

    /**
     * Get virtualRouter IPs.
     *
     * @return the virtualRouterIps value
     */
    public List<String> virtualRouterIps() {
        return this.virtualRouterIps;
    }

    /**
     * Set virtualRouter IPs.
     *
     * @param virtualRouterIps the virtualRouterIps value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withVirtualRouterIps(List<String> virtualRouterIps) {
        this.virtualRouterIps = virtualRouterIps;
        return this;
    }

    /**
     * Get flag to control transit for VirtualRouter hub.
     *
     * @return the allowBranchToBranchTraffic value
     */
    public Boolean allowBranchToBranchTraffic() {
        return this.allowBranchToBranchTraffic;
    }

    /**
     * Set flag to control transit for VirtualRouter hub.
     *
     * @param allowBranchToBranchTraffic the allowBranchToBranchTraffic value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withAllowBranchToBranchTraffic(Boolean allowBranchToBranchTraffic) {
        this.allowBranchToBranchTraffic = allowBranchToBranchTraffic;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get resource ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set resource ID.
     *
     * @param id the id value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withId(String id) {
        this.id = id;
        return this;
    }

}
