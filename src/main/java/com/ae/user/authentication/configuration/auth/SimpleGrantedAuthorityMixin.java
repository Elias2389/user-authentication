package com.ae.user.authentication.configuration.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

abstract public class SimpleGrantedAuthorityMixin {

    @JsonCreator
    public SimpleGrantedAuthorityMixin(@JsonProperty("authority") String role) {
    }
}
