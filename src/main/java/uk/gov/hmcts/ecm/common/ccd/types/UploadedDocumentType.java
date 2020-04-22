package uk.gov.hmcts.ecm.common.ccd.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class UploadedDocumentType {

    @JsonProperty("document_binary_url")
    private String documentBinaryUrl;
    @JsonProperty("document_filename")
    private String documentFilename;
    @JsonProperty("document_url")
    private String documentUrl;
}