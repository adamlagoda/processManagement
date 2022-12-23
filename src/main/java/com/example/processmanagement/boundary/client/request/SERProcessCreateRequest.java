package com.example.processmanagement.boundary.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SERProcessCreateRequest(

        @JsonProperty("KUNDENNR")
        String contractId,

        @JsonProperty(value = "CLIENT_ORG_ID", defaultValue = "DE")
        String clientOrgId,

        @JsonProperty("CLIENT_ID")
        String clientId,

        @JsonProperty("SPARTE")
        String branch,

        @JsonProperty("VOS_MOP_TYPE_NAME")
        String gv1,

        @JsonProperty("VARIANTE1")
        String gv2,

        @JsonProperty("LFDNR")
        String currentNumber
) {
}
