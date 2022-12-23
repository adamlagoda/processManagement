package com.example.processmanagement.boundary.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

public record CreateRequestDto(

        @JsonProperty("contractId") String contractId,
        @JsonProperty("branch") String branch,
        @JsonProperty("type") String type,
        @JsonProperty("clientId") String clientId,
        @JsonProperty("gv1") String gv1,
        @JsonProperty("gv2") String gv2,
        @JsonProperty("currentNumber") String currentNumber
){}
