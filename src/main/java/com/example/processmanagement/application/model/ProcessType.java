package com.example.processmanagement.application.model;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum ProcessType {
    OPEN("OPEN");

    private final String stringValue;

    public static ProcessType from(String type) {
        return Arrays.stream(ProcessType.values())
                .filter(enumValue -> enumValue.stringValue.equals(type))
                .findFirst()
                .orElse(OPEN);
    }
}
