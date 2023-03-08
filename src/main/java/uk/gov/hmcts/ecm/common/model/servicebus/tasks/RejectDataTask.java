package uk.gov.hmcts.ecm.common.model.servicebus.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import uk.gov.hmcts.ecm.common.model.ccd.CaseData;
import uk.gov.hmcts.ecm.common.model.ccd.CaseDetails;
import uk.gov.hmcts.ecm.common.model.ccd.SubmitEvent;
import uk.gov.hmcts.ecm.common.model.ccd.types.CasePreAcceptType;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.DataModelParent;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.RejectDataModel;

import static uk.gov.hmcts.ecm.common.model.helper.Constants.NO;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.SINGLE_OPEN_CASE_STATES;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.YES;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class RejectDataTask extends DataTaskParent {

    public RejectDataTask(DataModelParent dataModelParent) {
        super(dataModelParent);
    }

    public void run(CaseDetails caseDetails) {

        if (SINGLE_OPEN_CASE_STATES.contains(caseDetails.getState())) {
            rejectLogic(caseDetails.getCaseData());
        } else {
            log.info("Case {} is not in the right state", caseDetails.getCaseData().getEthosCaseReference());
        }

    }

    private void rejectLogic(CaseData caseData) {
        if (caseData.getPreAcceptCase() == null || YES.equals(caseData.getPreAcceptCase().getCaseAccepted())) {
            log.info("Moving to rejected state");
            CasePreAcceptType casePreAcceptType = new CasePreAcceptType();
            casePreAcceptType.setCaseAccepted(NO);
            casePreAcceptType.setDateRejected(((RejectDataModel) dataModelParent).getDateRejected());
            casePreAcceptType.setRejectReason(((RejectDataModel) dataModelParent).getRejectReason());
            caseData.setPreAcceptCase(casePreAcceptType);
        }
    }

}
