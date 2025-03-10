package uk.gov.hmcts.ecm.common.model.helper;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Constants {

    private Constants() {
    }


    public static final DateTimeFormatter OLD_DATE_TIME_PATTERN =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    public static final DateTimeFormatter OLD_DATE_TIME_PATTERN2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter NEW_DATE_PATTERN = DateTimeFormatter.ofPattern("d MMMM yyyy");
    public static final DateTimeFormatter NEW_DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm");
    public static final DateTimeFormatter NEW_TIME_PATTERN = DateTimeFormatter.ofPattern("HH:mm");
    public static final DateTimeFormatter DATE_TIME_USER_FRIENDLY_PATTERN =
        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public static final String ET_ENGLAND_AND_WALES = "ET_EnglandWales";
    public static final String ET_SCOTLAND = "ET_Scotland";
    public static final String NEW_LINE = "\",\n";
    public static final String OUTPUT_FILE_NAME = "document.docx";
    public static final String DEFAULT_FLAGS_IMAGE_FILE_NAME = "EMP-TRIB-0000000.jpg";
    public static final String ADDRESS_LABELS_TEMPLATE = "EM-TRB-LET-ENG-00544";
    public static final int ADDRESS_LABELS_PAGE_SIZE = 14;

    public static final String PRE_DEFAULT_XLSX_FILE_PATH = "preDefaultValues.xlsx";
    public static final String POST_DEFAULT_XLSX_FILE_PATH = "postDefaultValues.xlsx";
    public static final String VENUE_ADDRESS_VALUES_FILE_PATH = "venueAddressValues.xlsx";

    public static final String MANCHESTER_DEV_BULK_CASE_TYPE_ID = "Manchester_Multiple_Dev";
    public static final String MANCHESTER_DEV_CASE_TYPE_ID = "Manchester_Dev";
    public static final String SCOTLAND_DEV_BULK_CASE_TYPE_ID = "Scotland_Multiple_Dev";
    public static final String SCOTLAND_DEV_CASE_TYPE_ID = "Scotland_Dev";
    public static final String BRISTOL_DEV_BULK_CASE_TYPE_ID = "Bristol_Multiple_Dev";
    public static final String BRISTOL_DEV_CASE_TYPE_ID = "Bristol_Dev";
    public static final String LEEDS_DEV_BULK_CASE_TYPE_ID = "Leeds_Multiple_Dev";
    public static final String LEEDS_DEV_CASE_TYPE_ID = "Leeds_Dev";
    public static final String LONDON_CENTRAL_DEV_BULK_CASE_TYPE_ID = "LondonCentral_Multiple_Dev";
    public static final String LONDON_CENTRAL_DEV_CASE_TYPE_ID = "LondonCentral_Dev";
    public static final String LONDON_EAST_DEV_BULK_CASE_TYPE_ID = "LondonEast_Multiple_Dev";
    public static final String LONDON_EAST_DEV_CASE_TYPE_ID = "LondonEast_Dev";
    public static final String LONDON_SOUTH_DEV_BULK_CASE_TYPE_ID = "LondonSouth_Multiple_Dev";
    public static final String LONDON_SOUTH_DEV_CASE_TYPE_ID = "LondonSouth_Dev";
    public static final String MIDLANDS_EAST_DEV_BULK_CASE_TYPE_ID = "MidlandsEast_Multiple_Dev";
    public static final String MIDLANDS_EAST_DEV_CASE_TYPE_ID = "MidlandsEast_Dev";
    public static final String MIDLANDS_WEST_DEV_BULK_CASE_TYPE_ID = "MidlandsWest_Multiple_Dev";
    public static final String MIDLANDS_WEST_DEV_CASE_TYPE_ID = "MidlandsWest_Dev";
    public static final String NEWCASTLE_DEV_BULK_CASE_TYPE_ID = "Newcastle_Multiple_Dev";
    public static final String NEWCASTLE_DEV_CASE_TYPE_ID = "Newcastle_Dev";
    public static final String WALES_DEV_BULK_CASE_TYPE_ID = "Wales_Multiple_Dev";
    public static final String WALES_DEV_CASE_TYPE_ID = "Wales_Dev";
    public static final String WATFORD_DEV_BULK_CASE_TYPE_ID = "Watford_Multiple_Dev";
    public static final String WATFORD_DEV_CASE_TYPE_ID = "Watford_Dev";

    public static final String MANCHESTER_USERS_BULK_CASE_TYPE_ID = "Manchester_Multiple_User";
    public static final String MANCHESTER_USERS_CASE_TYPE_ID = "Manchester_User";
    public static final String SCOTLAND_USERS_BULK_CASE_TYPE_ID = "Scotland_Multiple_User";
    public static final String SCOTLAND_USERS_CASE_TYPE_ID = "Scotland_User";
    public static final String BRISTOL_USERS_BULK_CASE_TYPE_ID = "Bristol_Multiple_User";
    public static final String BRISTOL_USERS_CASE_TYPE_ID = "Bristol_User";
    public static final String LEEDS_USERS_BULK_CASE_TYPE_ID = "Leeds_Multiple_User";
    public static final String LEEDS_USERS_CASE_TYPE_ID = "Leeds_User";
    public static final String LONDON_CENTRAL_USERS_BULK_CASE_TYPE_ID = "LondonCentral_Multiple_User";
    public static final String LONDON_CENTRAL_USERS_CASE_TYPE_ID = "LondonCentral_User";
    public static final String LONDON_EAST_USERS_BULK_CASE_TYPE_ID = "LondonEast_Multiple_User";
    public static final String LONDON_EAST_USERS_CASE_TYPE_ID = "LondonEast_User";
    public static final String LONDON_SOUTH_USERS_BULK_CASE_TYPE_ID = "LondonSouth_Multiple_User";
    public static final String LONDON_SOUTH_USERS_CASE_TYPE_ID = "LondonSouth_User";
    public static final String MIDLANDS_EAST_USERS_BULK_CASE_TYPE_ID = "MidlandsEast_Multiple_User";
    public static final String MIDLANDS_EAST_USERS_CASE_TYPE_ID = "MidlandsEast_User";
    public static final String MIDLANDS_WEST_USERS_BULK_CASE_TYPE_ID = "MidlandsWest_Multiple_User";
    public static final String MIDLANDS_WEST_USERS_CASE_TYPE_ID = "MidlandsWest_User";
    public static final String NEWCASTLE_USERS_BULK_CASE_TYPE_ID = "Newcastle_Multiple_User";
    public static final String NEWCASTLE_USERS_CASE_TYPE_ID = "Newcastle_User";
    public static final String WALES_USERS_BULK_CASE_TYPE_ID = "Wales_Multiple_User";
    public static final String WALES_USERS_CASE_TYPE_ID = "Wales_User";
    public static final String WATFORD_USERS_BULK_CASE_TYPE_ID = "Watford_Multiple_User";
    public static final String WATFORD_USERS_CASE_TYPE_ID = "Watford_User";

    public static final String MANCHESTER_BULK_CASE_TYPE_ID = "Manchester_Multiple";
    public static final String SCOTLAND_BULK_CASE_TYPE_ID = "Scotland_Multiple";
    public static final String BRISTOL_BULK_CASE_TYPE_ID = "Bristol_Multiple";
    public static final String LEEDS_BULK_CASE_TYPE_ID = "Leeds_Multiple";
    public static final String LONDON_CENTRAL_BULK_CASE_TYPE_ID = "LondonCentral_Multiple";
    public static final String LONDON_EAST_BULK_CASE_TYPE_ID = "LondonEast_Multiple";
    public static final String LONDON_SOUTH_BULK_CASE_TYPE_ID = "LondonSouth_Multiple";
    public static final String MIDLANDS_EAST_BULK_CASE_TYPE_ID = "MidlandsEast_Multiple";
    public static final String MIDLANDS_WEST_BULK_CASE_TYPE_ID = "MidlandsWest_Multiple";
    public static final String NEWCASTLE_BULK_CASE_TYPE_ID = "Newcastle_Multiple";
    public static final String WALES_BULK_CASE_TYPE_ID = "Wales_Multiple";
    public static final String WATFORD_BULK_CASE_TYPE_ID = "Watford_Multiple";

    public static final String MANCHESTER_CASE_TYPE_ID = "Manchester";
    public static final String SCOTLAND_CASE_TYPE_ID = "Scotland";
    public static final String BRISTOL_CASE_TYPE_ID = "Bristol";
    public static final String LEEDS_CASE_TYPE_ID = "Leeds";
    public static final String LONDON_CENTRAL_CASE_TYPE_ID = "LondonCentral";
    public static final String LONDON_EAST_CASE_TYPE_ID = "LondonEast";
    public static final String LONDON_SOUTH_CASE_TYPE_ID = "LondonSouth";
    public static final String MIDLANDS_EAST_CASE_TYPE_ID = "MidlandsEast";
    public static final String MIDLANDS_WEST_CASE_TYPE_ID = "MidlandsWest";
    public static final String NEWCASTLE_CASE_TYPE_ID = "Newcastle";
    public static final String WALES_CASE_TYPE_ID = "Wales";
    public static final String WATFORD_CASE_TYPE_ID = "Watford";

    public static final String PENDING_STATE = "Pending";
    public static final String SUBMITTED_STATE = "Submitted";
    public static final String ACCEPTED_STATE = "Accepted";
    public static final String REJECTED_STATE = "Rejected";
    public static final String CLOSED_STATE = "Closed";
    public static final String OPEN_STATE = "Open";
    public static final String ERRORED_STATE = "Error";
    public static final String UPDATING_STATE = "Updating";
    public static final String TRANSFERRED_STATE = "Transferred";
    public static final String TRANSFERRED_IN_STATE = "TransferredIn";

    public static final String MULTIPLES_DEV = "_Multiples_Dev";
    public static final String MULTIPLE_DEV = "_Multiple_Dev";
    public static final String MULTIPLES_USER = "_Multiples_User";
    public static final String MULTIPLE_USER = "_Multiple_User";
    public static final String MULTIPLES = "_Multiples";
    public static final String MULTIPLE = "_Multiple";
    public static final String DEV = "_Dev";
    public static final String USER = "_User";
    public static final String LISTINGS_DEV = "_Listings_Dev";
    public static final String LISTINGS_USER = "_Listings_User";
    public static final String LISTINGS = "_Listings";

    public static final String YES = "Yes";
    public static final String NO = "No";

    public static final String CUSTOMISE_SELECTED_ADDRESSES = "0.1";
    public static final String ALL_AVAILABLE_ADDRESSES = "0.2";
    public static final String CLAIMANT_ADDRESS = "0.3";
    public static final String CLAIMANT_REP_ADDRESS = "0.4";
    public static final String CLAIMANT_AND_CLAIMANT_REP_ADDRESSES = "0.5";
    public static final String RESPONDENTS_ADDRESSES = "0.6";
    public static final String RESPONDENTS_REPS_ADDRESSES = "0.7";
    public static final String RESPONDENTS_AND_RESPONDENTS_REPS_ADDRESSES = "0.8";
    public static final String CLAIMANT_AND_RESPONDENTS_ADDRESSES = "0.9";
    public static final String CLAIMANT_REP_AND_RESPONDENTS_REPS_ADDRESSES = "0.10";
    public static final String CLAIMANT_AND_RESPONDENTS_REPS_ADDRESSES = "0.11";
    public static final String CLAIMANT_REP_AND_RESPONDENTS_ADDRESSES = "0.12";

    public static final String CLAIMANT = "CLAIMANT : ";
    public static final String CLAIMANT_REP = "CLAIMANT REP : ";
    public static final String RESPONDENT = "RESPONDENT : ";
    public static final String RESPONDENT_REP = "RESPONDENT REP : ";
    public static final String BATCH_UPDATE_RESPONDENT_TYPE_UPDATE = "Batch Update Respondent - Update";

    public static final String TEL = "Tel: ";
    public static final String REF = "Ref: ";
    public static final String CLAIMANT_TITLE = "Claimant";
    public static final String RESPONDENT_TITLE = "Respondent";

    public static final String LABEL = "Label_";
    public static final String LBL = "lbl_";

    public static final String FLAG_DO_NOT_POSTPONE = "DO NOT POSTPONE";
    public static final String FLAG_LIVE_APPEAL = "LIVE APPEAL";
    public static final String FLAG_RULE_503B = "RULE 50(3)b";
    public static final String FLAG_REPORTING = "REPORTING";
    public static final String FLAG_SENSITIVE = "SENSITIVE";
    public static final String FLAG_RESERVED = "RESERVED";
    public static final String FLAG_ECC = "ECC";
    public static final String FLAG_WITH_OUTSTATION = "WITH OUTSTATION";
    public static final String FLAG_DIGITAL_FILE = "DIGITAL FILE";

    public static final String ONE = "1";
    public static final String ZERO = "0";

    public static final String SINGLE_CASE_TYPE = "Single";
    public static final String MULTIPLE_CASE_TYPE = "Multiple";
    public static final String INDIVIDUAL_TYPE_CLAIMANT = "Individual";
    public static final String COMPANY_TYPE_CLAIMANT = "Company";
    public static final String MANUALLY_CREATED_POSITION = "Manually Created";
    public static final String CASE_CLOSED_POSITION = "Case closed";
    public static final String ET1_ONLINE_CASE_SOURCE = "ET1 Online";
    public static final String MIGRATION_CASE_SOURCE = "Migration";

    public static final String CREATION_EVENT_TRIGGER_ID = "initiateCase";
    public static final String UPDATE_EVENT_TRIGGER_ID_BULK = "amendCaseDetailsBulk";
    public static final String PRE_ACCEPT_CASE_TRIGGER_ID_BULK = "preAcceptanceCase";
    public static final String UPDATE_BULK_EVENT_TRIGGER_ID = "updateBulkAction";
    public static final String AMEND_MULTIPLE_EVENT_TRIGGER_ID = "amendMultipleAPI";
    public static final String AMEND_SINGLE_EVENT_TRIGGER_ID = "amendSingle";
    public static final String UPDATE_EVENT_TRIGGER_ID = "amendCaseDetails";
    public static final String DISPOSE_EVENT_TRIGGER_ID = "disposeCase";
    public static final String CREATION_TRANSFER_EVENT_TRIGGER_ID = "processCaseTransfer";
    public static final String CASE_TRANSFER_EVENT_TRIGGER_ID = "caseTransferMultiple";
    public static final String RETURN_TRANSFER_EVENT_TRIGGER_ID = "returnCaseTransfer";
    public static final String CREATE_MULTIPLE_EVENT_TRIGGER_ID = "createMultiple";
    public static final String MIGRATE_CASE_TO_REFORM_TRIGGER_ID = "createEcmCase";

    public static final String GLASGOW_OFFICE = "Glasgow";
    public static final String ABERDEEN_OFFICE = "Aberdeen";
    public static final String DUNDEE_OFFICE = "Dundee";
    public static final String EDINBURGH_OFFICE = "Edinburgh";

    public static final String MIDLANDS_WEST_OFFICE_NUMBER = "13";
    public static final String BRISTOL_OFFICE_NUMBER = "14";
    public static final String WALES_OFFICE_NUMBER = "16";
    public static final String LEEDS_OFFICE_NUMBER = "18";
    public static final String LONDON_CENTRAL_OFFICE_NUMBER = "22";
    public static final String LONDON_SOUTH_OFFICE_NUMBER = "23";
    public static final String MANCHESTER_OFFICE_NUMBER = "24";
    public static final String NEWCASTLE_OFFICE_NUMBER = "25";
    public static final String MIDLANDS_EAST_OFFICE_NUMBER = "26";
    public static final String LONDON_EAST_OFFICE_NUMBER = "32";
    public static final String WATFORD_OFFICE_NUMBER = "33";
    public static final String GLASGOW_OFFICE_NUMBER = "41";

    public static final String DEFAULT_SELECT_ALL_VALUE = "999999";
    public static final String SELECT_ALL_VALUE = "Select All";
    public static final String SELECT_NONE_VALUE = "None";

    public static final String MANCHESTER_DEV_LISTING_CASE_TYPE_ID = "Manchester_Listings_Dev";
    public static final String SCOTLAND_DEV_LISTING_CASE_TYPE_ID = "Scotland_Listings_Dev";
    public static final String LEEDS_DEV_LISTING_CASE_TYPE_ID = "Leeds_Listings_Dev";
    public static final String BRISTOL_DEV_LISTING_CASE_TYPE_ID = "Bristol_Listings_Dev";
    public static final String LONDON_CENTRAL_DEV_LISTING_CASE_TYPE_ID = "LondonCentral_Listings_Dev";
    public static final String LONDON_EAST_DEV_LISTING_CASE_TYPE_ID = "LondonEast_Listings_Dev";
    public static final String LONDON_SOUTH_DEV_LISTING_CASE_TYPE_ID = "LondonSouth_Listings_Dev";
    public static final String MIDLANDS_EAST_DEV_LISTING_CASE_TYPE_ID = "MidlandsEast_Listings_Dev";
    public static final String MIDLANDS_WEST_DEV_LISTING_CASE_TYPE_ID = "MidlandsWest_Listings_Dev";
    public static final String NEWCASTLE_DEV_LISTING_CASE_TYPE_ID = "Newcastle_Listings_Dev";
    public static final String WALES_DEV_LISTING_CASE_TYPE_ID = "Wales_Listings_Dev";
    public static final String WATFORD_DEV_LISTING_CASE_TYPE_ID = "Watford_Listings_Dev";

    public static final String MANCHESTER_USERS_LISTING_CASE_TYPE_ID = "Manchester_Listings_User";
    public static final String SCOTLAND_USERS_LISTING_CASE_TYPE_ID = "Scotland_Listings_User";
    public static final String LEEDS_USERS_LISTING_CASE_TYPE_ID = "Leeds_Listings_User";
    public static final String BRISTOL_USERS_LISTING_CASE_TYPE_ID = "Bristol_Listings_User";
    public static final String LONDON_CENTRAL_USERS_LISTING_CASE_TYPE_ID = "LondonCentral_Listings_User";
    public static final String LONDON_EAST_USERS_LISTING_CASE_TYPE_ID = "LondonEast_Listings_User";
    public static final String LONDON_SOUTH_USERS_LISTING_CASE_TYPE_ID = "LondonSouth_Listings_User";
    public static final String MIDLANDS_EAST_USERS_LISTING_CASE_TYPE_ID = "MidlandsEast_Listings_User";
    public static final String MIDLANDS_WEST_USERS_LISTING_CASE_TYPE_ID = "MidlandsWest_Listings_User";
    public static final String NEWCASTLE_USERS_LISTING_CASE_TYPE_ID = "Newcastle_Listings_User";
    public static final String WALES_USERS_LISTING_CASE_TYPE_ID = "Wales_Listings_User";
    public static final String WATFORD_USERS_LISTING_CASE_TYPE_ID = "Watford_Listings_User";

    public static final String MANCHESTER_LISTING_CASE_TYPE_ID = "Manchester_Listings";
    public static final String SCOTLAND_LISTING_CASE_TYPE_ID = "Scotland_Listings";
    public static final String LEEDS_LISTING_CASE_TYPE_ID = "Leeds_Listings";
    public static final String BRISTOL_LISTING_CASE_TYPE_ID = "Bristol_Listings";
    public static final String LONDON_CENTRAL_LISTING_CASE_TYPE_ID = "LondonCentral_Listings";
    public static final String LONDON_EAST_LISTING_CASE_TYPE_ID = "LondonEast_Listings";
    public static final String LONDON_SOUTH_LISTING_CASE_TYPE_ID = "LondonSouth_Listings";
    public static final String MIDLANDS_EAST_LISTING_CASE_TYPE_ID = "MidlandsEast_Listings";
    public static final String MIDLANDS_WEST_LISTING_CASE_TYPE_ID = "MidlandsWest_Listings";
    public static final String NEWCASTLE_LISTING_CASE_TYPE_ID = "Newcastle_Listings";
    public static final String WALES_LISTING_CASE_TYPE_ID = "Wales_Listings";
    public static final String WATFORD_LISTING_CASE_TYPE_ID = "Watford_Listings";

    public static final String IT56_TEMPLATE = "EM-TRB-SCO-ENG-00210";
    public static final String IT57_TEMPLATE = "EM-TRB-SCO-ENG-00211";
    public static final String PUBLIC_CASE_CAUSE_LIST_TEMPLATE = "EM-TRB-SCO-ENG-00212";
    public static final String STAFF_CASE_CAUSE_LIST_TEMPLATE = "EM-TRB-SCO-ENG-00213";
    public static final String PUBLIC_CASE_CAUSE_LIST_ROOM_TEMPLATE = "EM-TRB-SCO-ENG-00214";
    public static final String STAFF_CASE_CAUSE_LIST_ROOM_TEMPLATE = "EM-TRB-SCO-ENG-00215";
    public static final String PRESS_LIST_CAUSE_LIST_RANGE_TEMPLATE = "EM-TRB-SCO-ENG-00216";
    public static final String PRESS_LIST_CAUSE_LIST_SINGLE_TEMPLATE = "EM-TRB-SCO-ENG-00217";

    public static final String CONCILIATION_TRACK_NUMBER_ONE = "1";
    public static final String CONCILIATION_TRACK_NO_CONCILIATION = "No Conciliation";
    public static final String CONCILIATION_TRACK_NUMBER_TWO = "2";
    public static final String CONCILIATION_TRACK_FAST_TRACK = "Fast Track";
    public static final String CONCILIATION_TRACK_NUMBER_THREE = "3";
    public static final String CONCILIATION_TRACK_STANDARD_TRACK = "Standard Track";
    public static final String CONCILIATION_TRACK_NUMBER_FOUR = "4";
    public static final String CONCILIATION_TRACK_OPEN_TRACK = "Open Track";

    public static final String POSITION_TYPE_REJECTED = "REJECTED";
    public static final String POSITION_TYPE_CASE_CLOSED = "Case closed";
    public static final String POSITION_TYPE_CASE_INPUT_IN_ERROR = "Case input in error";
    public static final String POSITION_TYPE_CASE_TRANSFERRED_SAME_COUNTRY = "Case transferred - same country";
    public static final String POSITION_TYPE_CASE_TRANSFERRED_OTHER_COUNTRY = "Case transferred - other country";
    public static final String POSITION_TYPE_CASE_TRANSFERRED_REFORM_ECM = "Case transferred to Reform ECM";

    public static final String HEARING_TYPE_PRIVATE = "Private";
    public static final String HEARING_TYPE_PUBLIC = "Public";

    public static final String HEARING_TYPE_JUDICIAL_COSTS_HEARING = "Costs Hearing";
    public static final String HEARING_TYPE_JUDICIAL_HEARING = "Hearing";
    public static final String HEARING_TYPE_JUDICIAL_MEDIATION = "Judicial Mediation";
    public static final String HEARING_TYPE_JUDICIAL_MEDIATION_TCC = "Judicial Mediation - TCC";
    public static final String HEARING_TYPE_PERLIMINARY_HEARING = "Preliminary Hearing";
    public static final String HEARING_TYPE_PERLIMINARY_HEARING_CM = "Preliminary Hearing(CM)";
    public static final String HEARING_TYPE_PERLIMINARY_HEARING_CM_TCC = "Preliminary Hearing (CM) - TCC";
    public static final String HEARING_TYPE_JUDICIAL_RECONSIDERATION = "Reconsideration";
    public static final String HEARING_TYPE_JUDICIAL_REMEDY = "Remedy";

    public static final String HEARING_STATUS_HEARD = "Heard";
    public static final String HEARING_STATUS_LISTED = "Listed";
    public static final String HEARING_STATUS_SETTLED = "Settled";
    public static final String HEARING_STATUS_WITHDRAWN = "Withdrawn";
    public static final String HEARING_STATUS_POSTPONED = "Postponed";
    public static final String HEARING_STATUS_VACATED = "Vacated";

    public static final String JURISDICTION_OUTCOME_SUCCESSFUL_AT_HEARING = "Successful at hearing";
    public static final String JURISDICTION_OUTCOME_UNSUCCESSFUL_AT_HEARING = "Unsuccessful at hearing";
    public static final String JURISDICTION_OUTCOME_DISMISSED_AT_HEARING = "Dismissed at hearing - out of scope";

    public static final String BROUGHT_FORWARD_REPORT = "Brought Forward Report";
    public static final String CLAIMS_ACCEPTED_REPORT = "Claims Accepted";
    public static final String LIVE_CASELOAD_REPORT = "Live Caseload";
    public static final String MEMBER_DAYS_REPORT = "Member Days";
    public static final String SERVING_CLAIMS_REPORT = "Serving Claims";
    public static final String CLAIMS_BY_HEARING_VENUE_REPORT = "Claims By Hearing Venue";
    public static final String CASES_COMPLETED_REPORT = "Cases Completed";
    public static final String TIME_TO_FIRST_HEARING_REPORT = "Time To First Hearing";
    public static final String CASE_SOURCE_LOCAL_REPORT = "Case Source";
    public static final String HEARINGS_TO_JUDGEMENTS_REPORT = "Hearings To Judgments";
    public static final String HEARINGS_BY_HEARING_TYPE_REPORT = "Hearings By Hearing Type";
    public static final String CASES_AWAITING_JUDGMENT_REPORT = "Cases Awaiting Judgment";
    public static final String SESSION_DAYS_REPORT = "Session Days";

    public static final String HEARING_DOC_ETCL = "ETCL - Cause List";
    public static final String HEARING_DOC_IT56 = "IT56 - List of Exhibits";
    public static final String HEARING_DOC_IT57 = "ETRP - ET recording of proceeding";

    //hearing venue name label for Newcastle
    public static final String NEWCASTLE_CFT = "Newcastle CFT";
    public static final String NEWCASTLE_CFCTC = "Newcastle CFCTC";
    public static final String TEESSIDE_MAGS = "Teesside Mags";
    public static final String TEESSIDE_JUSTICE_CENTRE = "Teesside Justice Centre";

    public static final String HEARING_ETCL_PUBLIC = "Public";
    public static final String HEARING_ETCL_STAFF = "Staff";
    public static final String HEARING_ETCL_PRESS_LIST = "Press List";
    public static final String RANGE_HEARING_DATE_TYPE = "Range";
    public static final String SINGLE_HEARING_DATE_TYPE = "Single";

    public static final String ALL_VENUES = "All";
    public static final String RULE_50_APPLIES = "Order made pursuant to Rule 50";

    public static final String LIST_CASES = "EM-TRB-SUM-ENG-00220";
    public static final String MULTIPLE_SCHEDULE = "EM-TRB-SUM-ENG-00221";
    public static final String MULTIPLE_SCHEDULE_DETAILED = "EM-TRB-SUM-ENG-00222";

    public static final String LIST_CASES_CONFIG = "List Cases";
    public static final String MULTIPLE_SCHEDULE_CONFIG = "Multiple Schedule";
    public static final String MULTIPLE_SCHEDULE_DETAILED_CONFIG = "Multiple Schedule (Detailed)";

    public static final String FILE_EXTENSION = ".docx";
    public static final String IMAGE_FILE_EXTENSION = ".jpg";
    public static final String IMAGE_FILE_PRECEDING = "EMP-TRIB-";

    public static final String FUTURE_RECEIPT_DATE_ERROR_MESSAGE = "Receipt date should not be a date in the future";
    public static final String RECEIPT_DATE_LATER_THAN_ACCEPTED_ERROR_MESSAGE =
        "Receipt date should not be later than accepted date";
    public static final String EMPTY_RESPONDENT_COLLECTION_ERROR_MESSAGE = "At least one active respondent is required";
    public static final String EARLY_DATE_RETURNED_FROM_JUDGE_ERROR_MESSAGE = "Date returned from judge cannot be "
        + "earlier than Date referred to judge";
    public static final String FUTURE_RESPONSE_RECEIVED_DATE_ERROR_MESSAGE = "Response received date should not be a "
        + "date in the future";
    public static final String RESP_REP_NAME_MISMATCH_ERROR_MESSAGE = "The respondent name does not match any of the "
        + "available respondents for representative";
    public static final String EMPTY_HEARING_COLLECTION_ERROR_MESSAGE = "Hearings could not be found for this case, "
        + "the hearing collection is empty";
    public static final String HEARING_NUMBER_MISMATCH_ERROR_MESSAGE = "The hearing number provided did not match with "
        + "any of the hearing numbers contained within this case";
    public static final String DUPLICATE_JURISDICTION_CODE_ERROR_MESSAGE = "Duplicate Jurisdiction Code(s) : ";
    public static final String MISSING_JURISDICTION_OUTCOME_ERROR_MESSAGE = "A Jurisdiction outcome is required before "
        + "the case can be closed";
    public static final String MISSING_JUDGEMENT_JURISDICTION_MESSAGE = "This case contains a Judgment which does not "
        + "have a jurisdiction attached to it. To enable this case to be closed, please ensure the relevant "
        + "jurisdiction(s) has been linked to the Judgment.";
    public static final String MISSING_JURISDICTION_MESSAGE = "You cannot close this case as there is currently no "
        + "jurisdiction and no jurisdiction outcome associated with it";
    public static final String JURISDICTION_OUTCOME_NOT_ALLOCATED_ERROR_MESSAGE = "Jurisdiction outcome is set to"
        + " 'Not allocated'. A Jurisdiction outcome is required before the case can be closed.";
    public static final String NOT_ALLOCATED = "Not allocated";
    public static final String ADDRESS_LABELS_EMPTY_ERROR = "No addresses were found for you selection";
    public static final String ADDRESS_LABELS_SELECT_ERROR = "You need to select at least one address label before"
            + " printing";
    public static final String ADDRESS_LABELS_COPIES_ERROR = "You need to use a whole number for the number of copies "
            + "field";
    public static final String ADDRESS_LABELS_COPIES_LESS_10_ERROR = "Number of copies should be less than or equal "
            + "to 10";
    public static final String ADDRESS_LABELS_LABELS_LIMIT_ERROR = "Number of labels to be printed reached the limit";
    public static final String JURISDICTION_CODES_EXISTENCE_ERROR =
        "The following jurisdiction codes do not exist for this case: ";
    public static final String DUPLICATED_JURISDICTION_CODES_JUDGEMENT_ERROR = "The following jurisdiction codes have"
        + " been selected more than once for a judgment: ";
    public static final String JURISDICTION_CODES_DELETED_ERROR = "The following jurisdiction codes cannot be deleted"
            + " as they have been selected in judgements: ";
    public static final String DEPOSIT_REFUNDED_GREATER_DEPOSIT_ERROR = "The amount entered for the refund "
            + "cannot be more than the amount that was deposited";
    public static final String CLOSING_LISTED_CASE_ERROR = "This case contains a hearing which has a 'Listed' status. "
            + "This status must be updated to enable the case to be closed.";
    public static final String CLOSING_HEARD_CASE_WITH_NO_JUDGE_ERROR = "This case contains a hearing which has a "
        + "'Heard' status and does not have an Employment Judge allocated to it. "
        + "To enable this case to be closed, please allocate the Judge to the hearing.";
    public static final String UNABLE_TO_FIND_PARTY = "Unable to find correct party member";
    public static final String NO_CASES_SEARCHED = "No cases searched";
    public static final String CASE_IS_NOT_IN_MULTIPLE_ERROR =
        "Case is not part of the multiple or is already the lead case";
    public static final String CLAIMANT_ADDRESS_LABEL = "claimantAddressLabel";
    public static final String CLAIMANT_REP_ADDRESS_LABEL = "claimantRepAddressLabel";
    public static final String RESPONDENTS_ADDRESS__LABEL = "respondentsAddressLabel";
    public static final String RESPONDENTS_REPS_ADDRESS__LABEL = "respondentsRepsAddressLabel";

    public static final int TARGET_HEARING_DATE_INCREMENT = 180;

    public static final int MAX_ES_SIZE = 10000;

    public static final String MID_EVENT_CALLBACK = "Mid Event Callback";
    public static final String ABOUT_TO_SUBMIT_EVENT_CALLBACK = "About to Submit Callback";
    public static final String SUBMITTED_CALLBACK = "Submitted Callback";

    public static final int NUMBER_THREADS = 20;

    public static final int CHUNK_MESSAGE_SIZE = 10;

    public static final String BATCH_UPDATE_TYPE_1 = "batchUpdateType1";
    public static final String BATCH_UPDATE_TYPE_2 = "batchUpdateType2";
    public static final String BATCH_UPDATE_TYPE_3 = "batchUpdateType3";
    public static final String RESPONDENT_BATCH_UPDATE_CASE = "Respondent batch update - Case:";

    public static final String MULTIPLE_NAME_AMENDMENT = "Amend multiple name";
    public static final String LEAD_CASE_AMENDMENT = "Amend lead case";
    public static final String ADD_CASES_TO_MULTIPLE_AMENDMENT = "Add cases to multiple";

    public static final String CREATE_ACTION = "Create";
    public static final String AMEND_ACTION = "Amend";
    public static final String DELETE_ACTION = "Delete";

    public static final String MSL_HEARING_FORMAT_PERSON = "In person";
    public static final String MSL_HEARING_FORMAT_TELEPHONE = "Telephone";
    public static final String MSL_HEARING_FORMAT_VIDEO = "Video";
    public static final String MSL_HEARING_FORMAT_HYBRID = "Hybrid";

    public static final String BF_ACTION_ACAS = "Application of letter to ACAS/RPO";
    public static final String BF_ACTION_CASE_LISTED = "Case listed";
    public static final String BF_ACTION_CASE_PAPERS = "Case papers prepared";
    public static final String BF_ACTION_CASE_TRANSFERRED = "Case transferred";
    public static final String BF_ACTION_DRAFT = "Draft to members";
    public static final String BF_ACTION_ENQUIRY_ISSUED = "Enquiry letter issued";
    public static final String BF_ACTION_ENQUIRY_RECEIVED = "Enquiry letter received";
    public static final String BF_ACTION_EXHIBITS = "Exhibits returned";
    public static final String BF_ACTION_INTERLOCUTORY = "Interlocutory order requested";
    public static final String BF_ACTION_IT3_RECEIVED = "IT3 received";
    public static final String BF_ACTION_OTHER_ACTION = "Other action";
    public static final String BF_ACTION_POSTPONEMENT_REQUESTED = "Postponement requested";
    public static final String BF_ACTION_REFER_CHAIRMAN = "Refer to chairman for listing instructions";
    public static final String BF_ACTION_REPLY_TO_ENQUIRY = "Reply to enquiry letter sent";
    public static final String BF_ACTION_STRIKING_OUT_WARNING = "Striking out warning issued";
    public static final String LETTER_ADDRESS_MANAGING_OFFICE = "Managing Office";
    public static final String LETTER_ADDRESS_ALLOCATED_OFFICE = "Allocated Office";
    public static final String INVALID_LISTING_DATE_RANGE_ERROR_MESSAGE = "Please enter a date range that does not "
            + "exceed 31 days.";

    public static final List<String> SINGLE_OPEN_CASE_STATES = List.of(ACCEPTED_STATE, REJECTED_STATE, SUBMITTED_STATE);


}
