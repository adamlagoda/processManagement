package com.example.processmanagement.application.service;

import com.example.processmanagement.application.mapper.ProcessMapper;
import com.example.processmanagement.application.service.command.ProcessCreateCommand;
import com.example.processmanagement.application.service.criteria.ProcessSearchCriteria;
import com.example.processmanagement.boundary.api.response.ProcessDto;
import com.example.processmanagement.boundary.client.SERClient;
import com.example.processmanagement.boundary.client.request.SERProcessCreateRequest;
import com.example.processmanagement.boundary.client.request.SERProcessSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessService {

    private final SERClient serClient;
    private final ProcessMapper processMapper;

    public List<ProcessDto> search(ProcessSearchCriteria criteria) {
        var response = serClient.searchByCriteria(SERProcessSearchRequest.builder()
                .contractId(criteria.contractId())
                .clientId(criteria.clientId())
                .branch(criteria.branch())
                .gv1(criteria.gv1())
                .gv2(criteria.gv2())
                .currentNumber(criteria.currentNumber())
                .build());

        return processMapper.toDtos(response);
    }

    public ProcessDto create(ProcessCreateCommand command) {
        var response = serClient.create(SERProcessCreateRequest.builder()
                .contractId(command.contractId())
                .clientId(command.clientId())
                .branch(command.branch())
                .gv1(command.gv1())
                .gv2(command.gv2())
                .currentNumber(command.currentNumber())
                .build());

        return processMapper.toDto(response);
    }
}
