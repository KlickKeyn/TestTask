package com.testtask.dao.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserStateEnum {
    @JsonProperty("ONLINE")
    ONLINE("ONLINE"),
    @JsonProperty("OFFLINE")
    OFFLINE("OFFLINE");

    private final String value;

    UserStateEnum(String value) { this.value = value; }
}
