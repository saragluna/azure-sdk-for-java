// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.microsoft.azure.test.oauth;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter
@Setter
public class OAuthResponse {

    private String tokenType;
    private String scope;
    private long expiresIn;
    private long extExpiresIn;
    private String accessToken;
    private String refreshToken;
    private String idToken;

}
