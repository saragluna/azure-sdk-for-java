package com.azure.spring.cloud.autoconfigure.aadb2c.implementation.config;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A builder for {@link AadB2cClientRegistrationRepositoryBuilder}.
 */
final class AadB2cClientRegistrations {
    private List<ClientRegistration> clientRegistrations;
    private final Set<String> nonSignInClientRegistrationIds = new HashSet<>();

    AadB2cClientRegistrations(Collection<ClientRegistration> clientRegistrations) {
        this(clientRegistrations, null);
    }

    AadB2cClientRegistrations(Collection<ClientRegistration> clientRegistrations,
                              Set<String> nonSignInClientRegistrationIds) {
        this.clientRegistrations = new ArrayList<>(clientRegistrations);
        if (!CollectionUtils.isEmpty(nonSignInClientRegistrationIds)) {
            this.nonSignInClientRegistrationIds.addAll(nonSignInClientRegistrationIds);
        }
    }

    List<ClientRegistration> getClientRegistrations() {
        return Collections.unmodifiableList(clientRegistrations);
    }

    Set<String> getNonSignInClientRegistrationIds() {
        return Collections.unmodifiableSet(nonSignInClientRegistrationIds);
    }
}
