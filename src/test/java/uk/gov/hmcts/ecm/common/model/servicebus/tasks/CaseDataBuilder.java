package uk.gov.hmcts.ecm.common.model.servicebus.tasks;

import uk.gov.hmcts.ecm.common.model.ccd.CaseData;
import uk.gov.hmcts.ecm.common.model.ccd.SubmitEvent;
import uk.gov.hmcts.ecm.common.model.ccd.items.JurCodesTypeItem;
import uk.gov.hmcts.ecm.common.model.ccd.types.JurCodesType;
import uk.gov.hmcts.ecm.common.model.ccd.items.RespondentSumTypeItem;

import java.util.ArrayList;
import java.util.List;

public class CaseDataBuilder {
    private final CaseData caseData = new CaseData();

    public CaseDataBuilder withJurisdictionCode(String jurCode, String outcome) {
        var jurCodeType = new JurCodesType();
        jurCodeType.setJuridictionCodesList(jurCode);
        jurCodeType.setJudgmentOutcome(outcome);
        var jurCodesTypeItem = new JurCodesTypeItem();
        jurCodesTypeItem.setValue(jurCodeType);

        if (caseData.getJurCodesCollection() == null) {
            caseData.setJurCodesCollection(new ArrayList<>());
        }
        caseData.getJurCodesCollection().add(jurCodesTypeItem);

        return this;
    }

    public CaseDataBuilder withRespondentCollection(List<RespondentSumTypeItem> items) {
        if (caseData.getRespondentCollection() == null) {
            caseData.setRespondentCollection(new ArrayList<>());
        }
        items.forEach(item -> caseData.getRespondentCollection().add(item));
        return this;
    }

    public CaseData build() {
        return caseData;
    }

    public SubmitEvent buildAsSubmitEvent(String state) {
        var submitEvent = new SubmitEvent();
        submitEvent.setCaseData(caseData);
        submitEvent.setState(state);

        return submitEvent;
    }
}
