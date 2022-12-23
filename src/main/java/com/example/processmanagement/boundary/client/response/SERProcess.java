package com.example.processmanagement.boundary.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SERProcess {

    @JsonProperty("PI_ID")
    private long processId;

    @JsonProperty("DELAY")
    private String delay;

    @JsonProperty("DELAYER_ACTION")
    private String delayerAction;

    @JsonProperty("DIRECTION")
    private String direction;

    @JsonProperty("DRSUSER")
    private String drsUser;

    @JsonProperty("FACH")
    private String subject;

    @JsonProperty("GESELLSCHAFT")
    private String company;

    @JsonProperty("GMSSTATENAME")
    private String gmsStatement;

    @JsonProperty("GRUND")
    private String reason;

    @JsonProperty("GST")
    private String gst;

    @JsonProperty("INFOKZ")
    private String infoKz;

    @JsonProperty("INFOTEXT")
    private String infoText;

    @JsonProperty("KUNDENNR")
    private String customerNumber;

    @JsonProperty("LASTEMPLGVNNAME")
    private String lastEmpGvnName; // TODO think of better name

    @JsonProperty("LASTEMPLOYEEID")
    private String lastEmployeeId;

    @JsonProperty("LASTEMPLSURNAME")
    private String lastEmplSurname;

    @JsonProperty("LASTSTEPTYPEID")
    private String lastStepTypeId;

    @JsonProperty("LFDNR")
    private String currentNumber;

    @JsonProperty("MSE_STATUS")
    private String mseStatus;

    @JsonProperty("PRIORITY")
    private String priority;

    @JsonProperty("PRUEFKZ")
    private String testMark;

    @JsonProperty("RESUMED_AT_TIMESTAMP")
    private String resumedAtTimestamp;

    @JsonProperty("ROLEID_1")
    private String roleId1;

    @JsonProperty("ROLEID_2")
    private String roleId2;

    @JsonProperty("ROLEID_3")
    private String roleId3;

    @JsonProperty("ROLEID_N")
    private String roleIdN;

    @JsonProperty("ROLENAME")
    private String roleName;

    @JsonProperty("SCHADENJAHR")
    private String accidentYear;

    @JsonProperty("SCHADENNR")
    private String accidentNumber;

    @JsonProperty("SCHADENNR_ZUERICH")
    private String accidentNumberZurich;

    @JsonProperty("SENDTYPE")
    private String sendType;

    @JsonProperty("SPARTE")
    private String branch;

    @JsonProperty("STATUS")
    private String status;

    @JsonProperty("STEPTYPEID")
    private String stepTypeId;

    @JsonProperty("STEPTYPENAME")
    private String stepTypeName;

    @JsonProperty("USERID")
    private String userId;

    @JsonProperty("VARIANTE1")
    private String gv2;

    @JsonProperty("VARIANTE2")
    private String gv3;

    @JsonProperty("VERTRAGSNR")
    private String contractNumber;

    @JsonProperty("VERTRAGS_ID")
    private String contractId;

    @JsonProperty("VIS")
    private String vis;

    @JsonProperty("VORGANG_STEUERFLAG")
    private String processControlFlag;

    @JsonProperty("VOSID")
    private String vosId;

    @JsonProperty("VOSTYPE")
    private String vosType;

    @JsonProperty("VOS_MOP_TYPE_NAME")
    private String gv1;

    @JsonProperty("WEITERLEITBAR")
    private String forwardable;

    @JsonProperty("CLIENT_ORG_ID")
    private String clientOrgId;

    @JsonProperty("CLIENT_ID")
    private String clientId;
}
