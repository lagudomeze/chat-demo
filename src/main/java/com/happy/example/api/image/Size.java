package com.happy.example.api.image;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Size {
    _256x256("256x256"),
    _512x512("512x512"),
    _1024x1024("1024x1024");

    private final String value;

    Size(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
