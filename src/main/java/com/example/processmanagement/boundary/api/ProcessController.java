package com.example.processmanagement.boundary.api;

import com.example.processmanagement.boundary.api.response.ProcessDto;
import com.example.processmanagement.application.model.ProcessType;
import com.example.processmanagement.application.service.ProcessService;
import com.example.processmanagement.application.service.criteria.ProcessSearchCriteria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;

    @Operation(summary = "Search for processes in SER by given criteria")
    @Parameters(value = {
            @Parameter(name = "contractId", description = "TODO", required = true, example = "4509516"),
            @Parameter(name = "branch", description = "TODO", required = true, example = "AV"),
            @Parameter(name = "type", description = "TODO", required = true, example = "OPEN"),
            @Parameter(name = "clientId", description = "TODO", example = "00"),
            @Parameter(name = "gv1", description = "TODO", example = "21632"),
            @Parameter(name = "gv2", description = "TODO", example = "21687"),
            @Parameter(name = "currentNumber", description = "TODO", required = true, example = "01"),
    })
    @GetMapping(path = "search")
    public List<ProcessDto> searchProcesses(
            @RequestParam String contractId,
            @RequestParam String branch,
            @RequestParam String type,
            @RequestParam String clientId,
            @RequestParam String gv1,
            @RequestParam String gv2,
            @RequestParam String currentNumber
    ) {
        var criteria = ProcessSearchCriteria.builder()
                .contractId(contractId)
                .branch(branch)
                .type(ProcessType.from(type))
                .clientId(clientId)
                .gv1(gv1)
                .gv2(gv2)
                .currentNumber(currentNumber).build();
        return processService.search(criteria);
    }
}
