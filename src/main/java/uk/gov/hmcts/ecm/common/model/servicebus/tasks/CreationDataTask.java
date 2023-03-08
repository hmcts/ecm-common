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
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.CreationDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.DataModelParent;

import static uk.gov.hmcts.ecm.common.model.helper.Constants.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class CreationDataTask extends DataTaskParent {

    public CreationDataTask(DataModelParent dataModelParent) {
        super(dataModelParent);
    }

    public void run(CaseDetails caseDetails) {

        checkLeadClaimant(caseDetails.getCaseData());

        amendCreationFields(caseDetails.getCaseData());

    }

    private void checkLeadClaimant(CaseData caseData) {

        if (caseData.getEthosCaseReference()
                .equals(((CreationDataModel)dataModelParent).getLead())) {
            log.info("Adding lead");
            caseData.setLeadClaimant(YES);
        } else {
            caseData.setLeadClaimant(NO);
        }

    }

    private void amendCreationFields(CaseData caseData) {

        log.info("Moving case to Multiples case type");
        caseData.setMultipleReference(((CreationDataModel) dataModelParent).getMultipleRef());
        caseData.setEcmCaseType(MULTIPLE_CASE_TYPE);
        caseData.setMultipleFlag(YES);
        caseData.setMultipleReferenceLinkMarkUp(
                ((CreationDataModel) dataModelParent).getMultipleReferenceLinkMarkUp());

    }

}
