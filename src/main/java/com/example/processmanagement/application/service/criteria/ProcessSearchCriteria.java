package com.example.processmanagement.application.service.criteria;

import com.example.processmanagement.application.model.ProcessType;
import lombok.Builder;

@Builder
public record ProcessSearchCriteria(
        String contractId,
        String branch,
        ProcessType type,
        String clientId,
        String gv1,
        String gv2,
        String currentNumber) {
}
