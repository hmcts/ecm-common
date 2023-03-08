package uk.gov.hmcts.ecm.common.servicebus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.hmcts.ecm.common.helpers.ServiceBusHelper;
import uk.gov.hmcts.ecm.common.model.ccd.CaseDetails;
import uk.gov.hmcts.ecm.common.model.ccd.SubmitEvent;
import uk.gov.hmcts.ecm.common.model.servicebus.UpdateCaseMsg;

import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.CloseDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.CreationDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.CreationSingleDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.DetachDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.PreAcceptDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.RejectDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.ResetStateDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.UpdateDataModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.ACCEPTED_STATE;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.SUBMITTED_STATE;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.MULTIPLE_CASE_TYPE;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.YES;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.NO;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.CASE_CLOSED_POSITION;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.SINGLE_CASE_TYPE;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCaseMsgTest {

    private UpdateCaseMsg updateCaseMsg;
    private CaseDetails caseDetailsSubmitted;
    private CaseDetails caseDetailsAccepted;
    private CaseDetails caseDetailsDetailed;

    @Before
    public void setUp() {
        caseDetailsAccepted = ServiceBusHelper.generateCaseDetails(ACCEPTED_STATE);
        caseDetailsSubmitted = ServiceBusHelper.generateCaseDetails(SUBMITTED_STATE);
        caseDetailsDetailed = ServiceBusHelper.generateCaseDetailsDetailed(ACCEPTED_STATE);
    }

    @Test
    public void toStringMethod() {
        CreationDataModel creationDataModel = ServiceBusHelper.getCreationDataModel("4150002/2020");
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(creationDataModel);
       var linkMarkUp = "<a href=\"/cases/details/1591184523086531\"" + ">4150001</a>";
        assertEquals(
                "UpdateCaseMsg{"
                        + "ethosCaseReference='4150002/2020', msgId='1', jurisdiction='EMPLOYMENT', "
                        + "caseTypeId='Scotland_Multiple', multipleRef='4150001', totalCases='1', "
                        + "username='eric.ccdcooper@gmail.com', confirmation='YES', "
                        + "dataModel=CreationDataModel(lead=4150002/2020, multipleRef=4150001, "
                        + "multipleReferenceLinkMarkUp=" + linkMarkUp +")', "
                        + "multipleReferenceLinkMarkUp='" + linkMarkUp + "'}",
                updateCaseMsg.toString());
    }

    @Test
    public void runTaskCreation() {
        CreationDataModel creationDataModel = ServiceBusHelper.getCreationDataModel("4150002/2020");
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(creationDataModel);
        updateCaseMsg.runTask(caseDetailsAccepted);
        assertEquals(MULTIPLE_CASE_TYPE, caseDetailsAccepted.getCaseData().getEcmCaseType());
        assertEquals("4150001", caseDetailsAccepted.getCaseData().getMultipleReference());
        assertEquals(YES, caseDetailsAccepted.getCaseData().getLeadClaimant());
    }

    @Test
    public void runTaskPreAccept() {
        PreAcceptDataModel preAcceptDataModel = ServiceBusHelper.getPreAcceptDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(preAcceptDataModel);
        updateCaseMsg.runTask(caseDetailsSubmitted);
        assertEquals("25-10-2020", caseDetailsSubmitted.getCaseData().getPreAcceptCase().getDateAccepted());
        assertEquals(YES, caseDetailsSubmitted.getCaseData().getPreAcceptCase().getCaseAccepted());
    }

    @Test
    public void runTaskPreAcceptAlreadyAccepted() {
        PreAcceptDataModel preAcceptDataModel = ServiceBusHelper.getPreAcceptDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(preAcceptDataModel);
        updateCaseMsg.runTask(caseDetailsAccepted);
        assertEquals(ACCEPTED_STATE, caseDetailsAccepted.getState());
    }

    @Test
    public void runTaskReject() {
        RejectDataModel rejectDataModel = ServiceBusHelper.getRejectDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(rejectDataModel);
        updateCaseMsg.runTask(caseDetailsSubmitted);
        List<String> reasons = new ArrayList<>(Arrays.asList("RejectionReason1", "RejectionReason2"));
        assertEquals(NO, caseDetailsSubmitted.getCaseData().getPreAcceptCase().getCaseAccepted());
        assertEquals("25-10-2020", caseDetailsSubmitted.getCaseData().getPreAcceptCase().getDateRejected());
        assertEquals(reasons, caseDetailsSubmitted.getCaseData().getPreAcceptCase().getRejectReason());
    }

    @Test
    public void runTaskClose() {
        CloseDataModel closeDataModel = ServiceBusHelper.getCloseDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(closeDataModel);
        updateCaseMsg.runTask(caseDetailsSubmitted);
        assertEquals(CASE_CLOSED_POSITION, caseDetailsSubmitted.getCaseData().getPositionType());
        assertEquals("FileLocation", caseDetailsSubmitted.getCaseData().getFileLocation());
        assertEquals("ClerkResponsible", caseDetailsSubmitted.getCaseData().getClerkResponsible());
        assertEquals("Notes", caseDetailsSubmitted.getCaseData().getCaseNotes());
        assertEquals("ManagingOffice", caseDetailsSubmitted.getCaseData().getManagingOffice());
        assertEquals("FileLocationGlasgow", caseDetailsSubmitted.getCaseData().getFileLocationGlasgow());
        assertEquals("FileLocationAberdeen", caseDetailsSubmitted.getCaseData().getFileLocationAberdeen());
        assertEquals("FileLocationDundee", caseDetailsSubmitted.getCaseData().getFileLocationDundee());
        assertEquals("FileLocationEdinburgh", caseDetailsSubmitted.getCaseData().getFileLocationEdinburgh());
    }

    @Test
    public void runTaskDetach() {
        DetachDataModel detachDataModel = ServiceBusHelper.getDetachDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(detachDataModel);
        updateCaseMsg.runTask(caseDetailsAccepted);
        assertEquals(SINGLE_CASE_TYPE, caseDetailsAccepted.getCaseData().getEcmCaseType());
        assertNull(caseDetailsAccepted.getCaseData().getMultipleReference());
    }

    @Test
    public void runTaskResetState() {
        ResetStateDataModel resetStateDataModel = ServiceBusHelper.getResetStateDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(resetStateDataModel);
        updateCaseMsg.runTask(caseDetailsAccepted);
        assertEquals(ACCEPTED_STATE, caseDetailsAccepted.getState());
    }

    @Test
    public void runTaskCreationSingle() {
        CreationSingleDataModel creationSingleDataModel = ServiceBusHelper.getCreationSingleDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(creationSingleDataModel);
        updateCaseMsg.runTask(caseDetailsAccepted);
        assertEquals(ACCEPTED_STATE, caseDetailsAccepted.getState());
    }

    @Test
    public void runTaskUpdate() {
        UpdateDataModel updateDataModel = ServiceBusHelper.getUpdateDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(updateDataModel);
        updateCaseMsg.runTask(caseDetailsAccepted);
        assertEquals("ManagingOffice", caseDetailsAccepted.getCaseData().getManagingOffice());
        assertEquals("FileLocation", caseDetailsAccepted.getCaseData().getFileLocation());
        assertEquals("FileLocationGlasgow", caseDetailsAccepted.getCaseData().getFileLocationGlasgow());
        assertEquals("FileLocationAberdeen", caseDetailsAccepted.getCaseData().getFileLocationAberdeen());
        assertEquals("FileLocationDundee", caseDetailsAccepted.getCaseData().getFileLocationDundee());
        assertEquals("FileLocationEdinburgh", caseDetailsAccepted.getCaseData().getFileLocationEdinburgh());
        assertEquals("ClerkResponsible", caseDetailsAccepted.getCaseData().getClerkResponsible());
        assertEquals("PositionType", caseDetailsAccepted.getCaseData().getPositionType());
        assertEquals("25/08/1999", caseDetailsAccepted.getCaseData().getReceiptDate());
        assertEquals("HearingStage", caseDetailsAccepted.getCaseData().getHearingStage());
        assertEquals("RepName", caseDetailsAccepted.getCaseData()
                .getRepresentativeClaimantType().getNameOfRepresentative());
        assertEquals("AC", caseDetailsAccepted.getCaseData()
                .getJurCodesCollection().get(1).getValue().getJuridictionCodesList());
        assertEquals("RespondentName", caseDetailsAccepted.getCaseData()
                .getRespondentCollection().get(0).getValue().getRespondentName());
    }

    @Test
    public void runTaskUpdatecaseDetailsDetailed() {
        UpdateDataModel updateDataModel = ServiceBusHelper.getUpdateDataModel();
        updateCaseMsg = ServiceBusHelper.generateUpdateCaseMsg(updateDataModel);
        updateCaseMsg.runTask(caseDetailsDetailed);
        assertEquals("ManagingOffice", caseDetailsDetailed.getCaseData().getManagingOffice());
        assertEquals("FileLocation", caseDetailsDetailed.getCaseData().getFileLocation());
        assertEquals("FileLocationGlasgow", caseDetailsDetailed.getCaseData().getFileLocationGlasgow());
        assertEquals("FileLocationAberdeen", caseDetailsDetailed.getCaseData().getFileLocationAberdeen());
        assertEquals("FileLocationDundee", caseDetailsDetailed.getCaseData().getFileLocationDundee());
        assertEquals("FileLocationEdinburgh", caseDetailsDetailed.getCaseData().getFileLocationEdinburgh());
        assertEquals("ClerkResponsible", caseDetailsDetailed.getCaseData().getClerkResponsible());
        assertEquals("PositionType", caseDetailsDetailed.getCaseData().getPositionType());
        assertEquals("RepName", caseDetailsDetailed
                .getCaseData().getRepresentativeClaimantType().getNameOfRepresentative());
        assertEquals("AC", caseDetailsDetailed
                .getCaseData().getJurCodesCollection().get(1).getValue().getJuridictionCodesList());
        assertEquals("RespondentName", caseDetailsDetailed
                .getCaseData().getRespondentCollection().get(0).getValue().getRespondentName());
        assertEquals("RespondentName", caseDetailsDetailed
                .getCaseData().getRepCollection().get(0).getValue().getRespRepName());
    }
}
