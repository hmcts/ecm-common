package uk.gov.hmcts.ecm.common.model.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DefaultValues {
    private String positionType;
    private String claimantTypeOfClaimant;
    private String tribunalCorrespondenceAddressLine1;
    private String tribunalCorrespondenceAddressLine2;
    private String tribunalCorrespondenceAddressLine3;
    private String tribunalCorrespondenceTown;
    private String tribunalCorrespondencePostCode;
    private String tribunalCorrespondenceTelephone;
    private String tribunalCorrespondenceFax;
    private String tribunalCorrespondenceDX;
    private String tribunalCorrespondenceEmail;
    private String managingOffice;
    private String caseType;
}
