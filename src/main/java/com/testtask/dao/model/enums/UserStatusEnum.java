package com.testtask.dao.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserStatusEnum {
    @JsonProperty("ONLINE")
    ONLINE("ONLINE"),
    @JsonProperty("OFFLINE")
    OFFLINE("OFFLINE");

    private final String value;

    UserStatusEnum(String value) { this.value = value; }
}
