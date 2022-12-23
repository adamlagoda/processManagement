package com.example.processmanagement.boundary.api.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "TODO", requiredProperties = {"processId"})
public record ProcessDto(

        @Schema(description = "TODO", example = "864004")
        long processId,

        @Schema(description = "TODO", example = "123")
        String delay,

        @Schema(description = "TODO", example = "action")
        String delayerAction,

        @Schema(description = "TODO", example = "DIR")
        String direction,

        @Schema(description = "TODO", example = "user")
        String drsUser,

        @Schema(description = "TODO", example = "7")
        String subject,

        @Schema(description = "TODO", example = "21")
        String company,

        @Schema(description = "TODO", example = "appointed")
        String gmsStatement,

        @Schema(description = "TODO", example = "MPM mit b030 43 zum 15.11.13 sto.")
        String reason,

        @Schema(description = "TODO", example = "GS")
        String gst,

        @Schema(description = "TODO", example = "20")
        String infoKz,

        @Schema(description = "TODO", example = "Start Standardvorgang")
        String infoText,

        @Schema(description = "TODO", example = "1020304")
        String customerNumber,

        @Schema(description = "TODO", example = "Cengiz")
        String lastEmpGvnName,

        @Schema(description = "TODO", example = "IVK")
        String lastEmployeeId,

        @Schema(description = "TODO", example = "surname")
        String lastEmplSurname,

        @Schema(description = "TODO", example = "1569")
        String lastStepTypeId,

        @Schema(description = "TODO", example = "31")
        String currentNumber,

        @Schema(description = "TODO", example = "9")
        String mseStatus,

        @Schema(description = "TODO", example = "1")
        String priority,

        @Schema(description = "TODO", example = "Start")
        String testMark,

        @Schema(description = "TODO", example = "12.09.2012 11:00")
        String resumedAtTimestamp,

        @Schema(description = "TODO", example = "VOS_S/CB-HKS")
        String roleId1,

        @Schema(description = "TODO", example = "roleId2")
        String roleId2,

        @Schema(name = "roleId3", description = "TODO", example = "roleId3")
        String roleId3,

        @Schema(description = "TODO", example = "roleIdN")
        String roleIdN,

        @Schema(description = "TODO", example = "Schaden-Clearing-BO")
        String roleName,

        @Schema(description = "TODO", example = "2011")
        String accidentYear,

        @Schema(description = "TODO", example = "number")
        String accidentNumber,

        @Schema(description = "TODO", example = "number")
        String accidentNumberZurich,

        @Schema(description = "TODO", example = "instantiated")
        String sendType,

        @Schema(description = "TODO", example = "K1")
        String branch,

        @Schema(description = "TODO", example = "Schrank")
        String status,

        @Schema(description = "TODO", example = "4966")
        String stepTypeId,

        @Schema(description = "TODO", example = "Vorbereitung Rule-Engine-Test")
        String stepTypeName,

        @Schema(description = "TODO", example = "mvshost")
        String userId,

        @Schema(description = "TODO", example = "20128")
        String gv2,

        @Schema(description = "TODO", example = "variante2")
        String gv3,

        @Schema(description = "TODO", example = "21-524511-42701-K1")
        String contractNumber,

        @Schema(description = "TODO", example = "524511042701")
        String contractId,

        @Schema(description = "TODO", example = "1")
        String vis,

        @Schema(description = "TODO", example = "START")
        String processControlFlag,

        @Schema(description = "TODO", example = "ser-1016646")
        String vosId,

        @Schema(description = "TODO", example = "AUSmB")
        String vosType,

        @Schema(description = "TODO", example = "20099")
        String gv1,

        @Schema(description = "TODO", example = "1")
        String forwardable,

        @Schema(description = "TODO", example = "DE")
        String clientOrgId,

        @Schema(description = "TODO", example = "00")
        String clientId) {
}
