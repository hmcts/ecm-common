package uk.gov.hmcts.ecm.common.helpers;

import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termsQuery;
import static uk.gov.hmcts.ecm.common.model.helper.Constants.MAX_ES_SIZE;

public class ESHelper {

    private static final String ETHOS_CASE_REFERENCE_KEYWORD = "data.ethosCaseReference.keyword";
    private static final String MULTIPLE_CASE_REFERENCE_KEYWORD = "data.multipleReference.keyword";
    private static final String LISTING_DATE_FIELD_NAME = "data.hearingCollection.value.hearingDateCollection.value.listedDate";
    public static final String LISTING_VENUE_FIELD_NAME = "data.hearingCollection.value.hearingDateCollection.value.hearingVenueDay.keyword";
    public static final String LISTING_GLASGOW_VENUE_FIELD_NAME = "data.hearingCollection.value.hearingDateCollection.value.Hearing_Glasgow.keyword";
    public static final String LISTING_ABERDEEN_VENUE_FIELD_NAME = "data.hearingCollection.value.hearingDateCollection.value.Hearing_Aberdeen.keyword";

    public static String getSearchQuery(List<String> caseIds) {
        TermsQueryBuilder termsQueryBuilder = termsQuery(ETHOS_CASE_REFERENCE_KEYWORD, caseIds);
        return new SearchSourceBuilder()
                .size(MAX_ES_SIZE)
                .query(termsQueryBuilder).toString();
    }

    public static String getBulkSearchQuery(String multipleReference) {
        TermsQueryBuilder termsQueryBuilder = termsQuery(MULTIPLE_CASE_REFERENCE_KEYWORD, multipleReference);
        return new SearchSourceBuilder()
                .size(MAX_ES_SIZE)
                .query(termsQueryBuilder).toString();
    }

    public static String getListingVenueAndRangeDateSearchQuery(String dateToSearchFrom, String dateToSearchTo,
                                                                String venueToSearch, String venueToSearchMapping) {
        BoolQueryBuilder boolQueryBuilder = boolQuery()
                .filter(QueryBuilders.termQuery(venueToSearchMapping, venueToSearch))
                .filter(new RangeQueryBuilder(LISTING_DATE_FIELD_NAME).gte(dateToSearchFrom).lte(dateToSearchTo));
        return new SearchSourceBuilder()
                .size(MAX_ES_SIZE)
                .query(boolQueryBuilder).toString();
    }

    public static String getListingRangeDateSearchQuery(String dateToSearchFrom, String dateToSearchTo) {
        BoolQueryBuilder boolQueryBuilder = boolQuery()
                .filter(new RangeQueryBuilder(LISTING_DATE_FIELD_NAME).gte(dateToSearchFrom).lte(dateToSearchTo));
        return new SearchSourceBuilder()
                .size(MAX_ES_SIZE)
                .query(boolQueryBuilder).toString();
    }

}
