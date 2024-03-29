package uk.gov.hmcts.ecm.common.model.servicebus.tasks;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.hmcts.ecm.common.model.ccd.SubmitEvent;
import uk.gov.hmcts.ecm.common.model.ccd.items.RespondentSumTypeItem;
import uk.gov.hmcts.ecm.common.model.ccd.types.RespondentSumType;
import uk.gov.hmcts.ecm.common.model.servicebus.datamodel.UpdateDataModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UpdateDataTaskTest {

    CaseDataBuilder caseDataBuilder;
    UpdateDataModelBuilder updateDataModelBuilder;

    @Before
    public void setUp() {
        caseDataBuilder = new CaseDataBuilder();
        updateDataModelBuilder = new UpdateDataModelBuilder();
    }

    @Test
    public void addNewJurisdictionCode() {
        var updateModel = updateDataModelBuilder.withJurisdictionCode("Code1", "Outcome1").build();
        var submitEvent = caseDataBuilder.withJurisdictionCode("Code2", "Outcome2")
                .buildAsSubmitEvent("Accepted");

        var task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        var expectedCode = "Code2";
        var expectedOutcome = "Outcome2";

        var resultJurCollection = submitEvent.getCaseData().getJurCodesCollection();
        assertEquals(2, resultJurCollection.size());
        assertNotNull(
                resultJurCollection.stream().filter(j ->
                        j.getValue().getJuridictionCodesList().equals(expectedCode)
                                && j.getValue().getJudgmentOutcome().equals(expectedOutcome))
        );
    }

    @Test
    public void updateExistingJurisdictionCode() {
        var updateModel = updateDataModelBuilder.withJurisdictionCode("Code1", "Outcome1").build();
        var submitEvent = caseDataBuilder.withJurisdictionCode("Code1", "Outcome2")
                                        .buildAsSubmitEvent("Accepted");

        var task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        var expectedCode = "Code1";
        var expectedOutcome = "Outcome2";

        var resultJurCollection = submitEvent.getCaseData().getJurCodesCollection();
        assertEquals(1, resultJurCollection.size());
        assertNotNull(
                resultJurCollection.stream().filter(j ->
                        j.getValue().getJuridictionCodesList().equals(expectedCode)
                                && j.getValue().getJudgmentOutcome().equals(expectedOutcome))
        );
    }

    @Test
    public void noUpdateToJurisdictionCode() {
        var updateModel = updateDataModelBuilder.build();
        var submitEvent = caseDataBuilder.withJurisdictionCode("Code1", "Outcome1")
                .buildAsSubmitEvent("Accepted");

        var task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        var expectedCode = "Code1";
        var expectedOutcome = "Outcome1";

        var resultJurCollection = submitEvent.getCaseData().getJurCodesCollection();
        assertEquals(1, resultJurCollection.size());
        assertNotNull(
                resultJurCollection.stream().filter(j ->
                        j.getValue().getJuridictionCodesList().equals(expectedCode)
                                && j.getValue().getJudgmentOutcome().equals(expectedOutcome))
        );
    }

    @Test
    public void addJurisdictionCodeWhenNonExist() {
        var updateModel = updateDataModelBuilder.withJurisdictionCode("Code1", "Outcome1").build();
        var submitEvent = caseDataBuilder.buildAsSubmitEvent("Accepted");

        var task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        var expectedCode = "Code1";
        var expectedOutcome = "Outcome1";

        var resultJurCollection = submitEvent.getCaseData().getJurCodesCollection();
        assertEquals(1, resultJurCollection.size());
        assertNotNull(
                resultJurCollection.stream().filter(j ->
                        j.getValue().getJuridictionCodesList().equals(expectedCode)
                                && j.getValue().getJudgmentOutcome().equals(expectedOutcome))
        );
    }

    @Test
    public void noJurisdictionCode() {
        var updateModel = updateDataModelBuilder.build();
        var submitEvent = caseDataBuilder.buildAsSubmitEvent("Accepted");

        var task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        assertNull(submitEvent.getCaseData().getJurCodesCollection());
    }

    @Test
    public void checkJurisdictionCode() {
        var updateModel = updateDataModelBuilder.build();
        updateModel.setIsFixCase("Yes");

        var submitEvent = caseDataBuilder.withJurisdictionCode("ADT", "Outcome1")
                .buildAsSubmitEvent("Accepted");
        submitEvent.getCaseData().getJurCodesCollection().get(0).setId("ADT");

        assertEquals("ADT", submitEvent.getCaseData().getJurCodesCollection().get(0).getId());

        var task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        assertNotNull(submitEvent.getCaseData().getJurCodesCollection());
        assertNotEquals("ADT", submitEvent.getCaseData().getJurCodesCollection().get(0).getId());
        assertTrue(submitEvent.getCaseData().getJurCodesCollection().get(0).getId().matches(
                "[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}"));
    }

    @Test
    public void checkSubMultiple() {
        var updateModel = updateDataModelBuilder.build();
        updateModel.setSubMultiple("SubMultiple");
        var submitEvent = caseDataBuilder.buildAsSubmitEvent("Accepted");
        var task = new UpdateDataTask(updateModel);
        task.run(submitEvent);
        assertEquals("SubMultiple", submitEvent.getCaseData().getSubMultipleName());
    }

    @Test
    public void addNewRespondentDetails_DuplicateRespondentExists() {
        List<RespondentSumTypeItem> respondentSumTypeItems = List.of(
            getRespondentSumTypeItem("123", "TestRespondent1", "Email",
                "Yes"),
            getRespondentSumTypeItem("345", "TestRespondent2", "Phone",
                "Yes"),
            getRespondentSumTypeItem("678", "TestRespondent3", "Email",
                "Yes"));
        CaseDataBuilder myCaseDataBuilder  = caseDataBuilder.withRespondentCollection(respondentSumTypeItems);
        SubmitEvent submitEvent = myCaseDataBuilder.buildAsSubmitEvent("Accepted");
        UpdateDataModel updateModel = updateDataModelBuilder.build();
        updateModel.setBatchRespondentUpdateType("Batch Update Respondent - Add");
        updateModel.setRespondentSumType(getUpdateRespondentSumType("TestRespondent1", "Phone",
            "Yes"));

        UpdateDataTask task = new UpdateDataTask(updateModel);
        task.run(submitEvent);
        assertEquals(3, submitEvent.getCaseData().getRespondentCollection().size());
        RespondentSumType respondent = submitEvent.getCaseData().getRespondentCollection().get(0).getValue();
        RespondentSumType duplicateRespondent = respondentSumTypeItems.get(0).getValue();
        assertEquals(duplicateRespondent.getRespondentName(), respondent.getRespondentName());
        // RespondentContactPreference should not be updated
        assertEquals(duplicateRespondent.getRespondentContactPreference(), respondent.getRespondentContactPreference());
    }

    @Test
    public void addNewRespondentDetails_NoDuplicateRespondentExists() {
        List<RespondentSumTypeItem> respondentSumTypeItems = List.of(
            getRespondentSumTypeItem("33", "TestRespondent1", "Email",
                "Yes"),
            getRespondentSumTypeItem("43", "TestRespondent2", "Phone",
                "Yes"),
            getRespondentSumTypeItem("53", "TestRespondent3", "Email",
                "No"));
        CaseDataBuilder myCaseDataBuilder  = caseDataBuilder.withRespondentCollection(respondentSumTypeItems);
        SubmitEvent submitEvent = myCaseDataBuilder.buildAsSubmitEvent("Accepted");
        UpdateDataModel updateModel = updateDataModelBuilder.build();
        updateModel.setBatchRespondentUpdateType("Batch Update Respondent - Add");
        updateModel.setRespondentSumType(getUpdateRespondentSumType("TestRespondent4", "Email",
            "Yes"));

        UpdateDataTask task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        assertEquals(4, submitEvent.getCaseData().getRespondentCollection().size());
        assertEquals(updateModel.getRespondentSumType().getRespondentName(),
            submitEvent.getCaseData().getRespondentCollection().get(2).getValue().getRespondentName());
        assertEquals(updateModel.getRespondentSumType().getRespondentContactPreference(),
            submitEvent.getCaseData().getRespondentCollection().get(2).getValue().getRespondentContactPreference());
    }

    @Test
    public void updateRespondentDetails_DuplicateExists() {
        List<RespondentSumTypeItem> respondentSumTypeItems = List.of(
            getRespondentSumTypeItem("20", "TestRespondent1", "Email",
                "Yes"),
            getRespondentSumTypeItem("30", "TestRespondent2", "Phone",
                "Yes"),
            getRespondentSumTypeItem("40", "TestRespondent3", "Phone",
                "No"));
        CaseDataBuilder myCaseDataBuilder  = caseDataBuilder.withRespondentCollection(respondentSumTypeItems);
        SubmitEvent submitEvent = myCaseDataBuilder.buildAsSubmitEvent("Accepted");
        UpdateDataModel updateModel = updateDataModelBuilder.build();
        updateModel.setBatchRespondentUpdateType("Batch Update Respondent - Update");
        updateModel.setRespondentSumType(getUpdateRespondentSumType("TestRespondent3", "Email",
            "Yes"));

        UpdateDataTask task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        assertEquals(3, submitEvent.getCaseData().getRespondentCollection().size());
        assertEquals(updateModel.getRespondentSumType().getRespondentName(),
            submitEvent.getCaseData().getRespondentCollection().get(2).getValue().getRespondentName());
        assertEquals(updateModel.getRespondentSumType().getRespondentContactPreference(),
            submitEvent.getCaseData().getRespondentCollection().get(2).getValue().getRespondentContactPreference());
    }

    @Test
    public void updateRespondentDetails_NoDuplicateExists() {
        List<RespondentSumTypeItem> respondentSumTypeItems = List.of(
            getRespondentSumTypeItem("260", "TestRespondent1", "Email",
                "Yes"),
            getRespondentSumTypeItem("250", "TestRespondent2", "Phone",
                "No"));
        CaseDataBuilder myCaseDataBuilder  = caseDataBuilder.withRespondentCollection(respondentSumTypeItems);
        SubmitEvent submitEvent = myCaseDataBuilder.buildAsSubmitEvent("Accepted");
        UpdateDataModel updateModel = updateDataModelBuilder.build();
        updateModel.setBatchRespondentUpdateType("Batch Update Respondent - Update");
        updateModel.setRespondentSumType(getUpdateRespondentSumType("TestRespondent5", "Email",
            "Yes"));

        UpdateDataTask task = new UpdateDataTask(updateModel);
        task.run(submitEvent);

        assertEquals(2, submitEvent.getCaseData().getRespondentCollection().size());
    }

    private RespondentSumTypeItem getRespondentSumTypeItem(String id, String respondentName, String contactPreference,
                                                           String responseContinue) {
        RespondentSumTypeItem respondentSumTypeItem = new RespondentSumTypeItem();
        respondentSumTypeItem.setId(id);
        RespondentSumType respondentSumType = new RespondentSumType();
        respondentSumType.setRespondentName(respondentName);
        respondentSumType.setRespondentContactPreference(contactPreference);
        respondentSumType.setResponseContinue(responseContinue);
        respondentSumTypeItem.setValue(respondentSumType);
        return respondentSumTypeItem;
    }

    private RespondentSumType getUpdateRespondentSumType(String name, String contactPreference,
                                                         String responseContinue) {
        RespondentSumType respondentSumTypeNew = new RespondentSumType();
        respondentSumTypeNew.setRespondentName(name);
        respondentSumTypeNew.setRespondentContactPreference(contactPreference);
        respondentSumTypeNew.setResponseContinue(responseContinue);
        return respondentSumTypeNew;
    }
}
