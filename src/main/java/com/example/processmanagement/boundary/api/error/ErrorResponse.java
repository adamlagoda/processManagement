package com.example.processmanagement.boundary.api.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorResponse(

        @JsonProperty("message")
        String message,

        @JsonProperty("code")
        String code
) {
}
