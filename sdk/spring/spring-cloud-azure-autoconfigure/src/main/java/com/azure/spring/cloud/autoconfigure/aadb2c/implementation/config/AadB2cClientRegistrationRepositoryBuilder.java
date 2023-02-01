// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.cloud.autoconfigure.aadb2c.implementation.config;

import com.azure.spring.cloud.autoconfigure.aadb2c.implementation.AadB2cClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A representation of a OAuth2 Client registration for Azure AD B2C.
 */
public class AadB2cClientRegistrationRepositoryBuilder {

    private final AtomicBoolean building = new AtomicBoolean();
    private final List<AadB2cClientRegistrationRepositoryBuilderConfigurer> configurers = new ArrayList<>();

    private final List<ClientRegistration> clientRegistrations = new ArrayList<>();

    private final Set<String> nonSignInClientRegistrationIds = new HashSet<>();

    public AadB2cClientRegistrationRepositoryBuilder b2cClientRegistrations(AadB2cClientRegistrationsBuilder builder) {
        final AadB2cClientRegistrations aadB2cClientRegistrations = builder.build();
        this.clientRegistrations(aadB2cClientRegistrations.getClientRegistrations().toArray(new ClientRegistration[0]));
        this.nonSignInClientRegistrationIds(aadB2cClientRegistrations.getNonSignInClientRegistrationIds().toArray(String[]::new));
        return this;
    }

    // configure  --> call method a -> return this
    // method a --> return wrap(this)  --> need to call configure

    public AadB2cClientRegistrationRepositoryBuilder configure(AadB2cClientRegistrationRepositoryBuilderConfigurer configurer) {
        this.configurers.add(configurer);
        return this;
    }

    public AadB2cClientRegistrationRepositoryBuilder clientRegistrations(ClientRegistration... clientRegistrations) {
        Arrays.stream(clientRegistrations).forEach(this.clientRegistrations::add);
        return this;
    }

    public AadB2cClientRegistrationRepositoryBuilder nonSignInClientRegistrationIds(String... clientRegistrationIds) {
        Arrays.stream(clientRegistrationIds).forEach(this.nonSignInClientRegistrationIds::add);
        return this;
    }

    public AadB2cClientRegistrationRepository build() {
        if (this.building.compareAndSet(false, true)) {
            return doBuild();
        }
        throw new IllegalStateException("This clientRegistrationRepository has already been built");
    }

    private AadB2cClientRegistrationRepository doBuild() {
        synchronized (this.configurers) {
            for (AadB2cClientRegistrationRepositoryBuilderConfigurer configurer : configurers) {
                configurer.configure(this);
            }
            return new AadB2cClientRegistrationRepository(this.clientRegistrations, this.nonSignInClientRegistrationIds);
        }
    }

}
