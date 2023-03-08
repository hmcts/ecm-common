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
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.CloseDataModel;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.DataModelParent;

import static com.google.common.base.Strings.isNullOrEmpty;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class CloseDataTask extends DataTaskParent {

    public CloseDataTask(DataModelParent dataModelParent) {
        super(dataModelParent);
    }

    public void run(SubmitEvent submitEvent) {

        if (!submitEvent.getState().equals(CLOSED_STATE)) {
            closeLogic(submitEvent.getCaseData());
        } else {
            log.info("The case is already closed");
        }

    }

    private void closeLogic(CaseData caseData) {

        log.info("Moving to close state");
        caseData.setPositionType(CASE_CLOSED_POSITION);
        caseData.setClerkResponsible(((CloseDataModel)dataModelParent).getClerkResponsible());
        caseData.setFileLocation(((CloseDataModel)dataModelParent).getFileLocation());
        caseData.setCaseNotes(((CloseDataModel)dataModelParent).getNotes());

        managingOffice(caseData, ((CloseDataModel)dataModelParent));

    }

    private void managingOffice(CaseData caseData, CloseDataModel closeDataModel) {

        if (!isNullOrEmpty(closeDataModel.getManagingOffice())) {
            caseData.setManagingOffice(closeDataModel.getManagingOffice());
        }

        if (!isNullOrEmpty(closeDataModel.getFileLocationGlasgow())) {
            caseData.setFileLocationGlasgow(closeDataModel.getFileLocationGlasgow());
        }

        if (!isNullOrEmpty(closeDataModel.getFileLocationAberdeen())) {
            caseData.setFileLocationAberdeen(closeDataModel.getFileLocationAberdeen());
        }

        if (!isNullOrEmpty(closeDataModel.getFileLocationDundee())) {
            caseData.setFileLocationDundee(closeDataModel.getFileLocationDundee());
        }

        if (!isNullOrEmpty(closeDataModel.getFileLocationEdinburgh())) {
            caseData.setFileLocationEdinburgh(closeDataModel.getFileLocationEdinburgh());
        }

    }

}
