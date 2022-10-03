package uk.gov.hmcts.ecm.common.model.helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import uk.gov.hmcts.ecm.common.model.ccd.SignificantItem;

@Data
@Builder(toBuilder = true)
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaseEventDetail {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_last_name")
    private String userLastName;
    @JsonProperty("user_first_name")
    private String userFirstName;
    @JsonProperty("created_date")
    private LocalDateTime createdDate;
    @JsonProperty("case_type_id")
    private String caseTypeId;
    @JsonProperty("case_type_version")
    private Integer caseTypeVersion;
    private String description;
    @JsonProperty("event_name")
    private String eventName;
    private String id;
    @JsonProperty("state_id")
    private String stateId;
    @JsonProperty("state_name")
    private String stateName;
    private Map<String, Object> data;
    private Map<String, Object> dataClassification;
    private SignificantItem significantItem;

    public int comparedTo(CaseEventDetail secondCaseEventDetail) {
        return this.getCreatedDate()
                .compareTo(secondCaseEventDetail.getCreatedDate());
    }
}
