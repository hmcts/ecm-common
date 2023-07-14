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
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.DataModelParent;

import static uk.gov.hmcts.ecm.common.model.helper.Constants.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class DetachDataTask extends DataTaskParent {

    public DetachDataTask(DataModelParent dataModelParent) {
        super(dataModelParent);
    }

    public void run(SubmitEvent submitEvent) {

        detachCaseFieldsFromMultiple(submitEvent.getCaseData());

    }

    private void detachCaseFieldsFromMultiple(CaseData caseData) {

        log.info("Detaching case from the Multiples");
        caseData.setMultipleReference(" ");
        caseData.setMultipleReferenceLinkMarkUp(" ");
        caseData.setLeadClaimant(" ");
        caseData.setEcmCaseType(SINGLE_CASE_TYPE);
        caseData.setMultipleFlag(NO);

    }

}
