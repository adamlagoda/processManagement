package com.example.processmanagement.boundary.api;

import com.example.processmanagement.application.error.SERApiException;
import com.example.processmanagement.application.model.ProcessType;
import com.example.processmanagement.application.service.ProcessService;
import com.example.processmanagement.application.service.command.ProcessCreateCommand;
import com.example.processmanagement.application.service.criteria.ProcessSearchCriteria;
import com.example.processmanagement.boundary.api.error.ErrorResponse;
import com.example.processmanagement.boundary.api.request.CreateRequestDto;
import com.example.processmanagement.boundary.api.response.ProcessDto;
import com.example.processmanagement.boundary.client.error.ProcessNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;

    @Operation(summary = "Search for existing processes in SER by given criteria")
    @Parameters(value = {
            @Parameter(name = "contractId", description = "TODO", required = true, example = "4509516"),
            @Parameter(name = "branch", description = "TODO", required = true, example = "AV"),
            @Parameter(name = "type", description = "TODO", required = true, example = "OPEN"),
            @Parameter(name = "clientId", description = "TODO", example = "00"),
            @Parameter(name = "gv1", description = "TODO", example = "21632"),
            @Parameter(name = "gv2", description = "TODO", example = "21687"),
            @Parameter(name = "currentNumber", description = "TODO", required = true, example = "01"),
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Process found",
                    content = @Content(schema = @Schema(implementation = ProcessDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Process not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class, example =
                            //language=json
                            """
                                    {
                                        "message": "No process found by given criteria",
                                        "code": "SERProcessNotFound"
                                    }
                                    """), mediaType = "application/json"))
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

    @Operation(summary = "Create process in SER")
    @Parameter(name = "createRequestBody", content = @Content(schema = @Schema(implementation = CreateRequestDto.class,
            description = "TODO"), mediaType = "application/json", examples = {
            @ExampleObject(value =
                    //language=json
                    """
                            {
                                "contractId": "4509516",
                                "branch": "AV",
                                "type": "OPEN",
                                "clientId": "00",
                                "gv1": "21632",
                                "gv2": "21687",
                                "currentNumber": "01"
                            }
                            """)}))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Process created",
                    content = @Content(schema = @Schema(implementation = ProcessDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "502", description = "Api unavailable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class, example =
                            //language=json
                            """
                                    {
                                        "message": "SER API not available",
                                        "code": "SERAPIUnavailable"
                                    }
                                    """), mediaType = "application/json"))
    })
    @PostMapping(path = "create")
    public ProcessDto createProcess(@io.swagger.v3.oas.annotations.parameters.RequestBody @RequestBody CreateRequestDto requestDto) {
        var command = ProcessCreateCommand.builder()
                .contractId(requestDto.contractId())
                .branch(requestDto.branch())
                .type(ProcessType.from(requestDto.type()))
                .clientId(requestDto.clientId())
                .gv1(requestDto.gv1())
                .gv2(requestDto.gv2())
                .currentNumber(requestDto.currentNumber()).build();
        return processService.create(command);
    }

    @ExceptionHandler(SERApiException.class)
    protected ResponseEntity<ErrorResponse> handleSERApiException(SERApiException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(new ErrorResponse(exception.getMessage(), "SERAPIUnavailable"));
    }

    @ExceptionHandler(ProcessNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleProcessNotFoundException(ProcessNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(exception.getMessage(), "SERProcessNotFound"));
    }
}
