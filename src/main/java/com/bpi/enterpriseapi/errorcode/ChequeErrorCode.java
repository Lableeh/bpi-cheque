package com.bpi.enterpriseapi.errorcode;

import java.util.Map;

import com.bpi.framework.errorcode.ErrorCode;

public class ChequeErrorCode extends ErrorCode{

	 // service error
    public static final ErrorCode SERVICE_ERROR = service("999", "Service Error");
    public static final ErrorCode PARTIAL_SUCCESS_REORDER_CHECKBOOK_DBCR = service("001", "Partial Success");
    
    // validation error
    public static final ErrorCode VALIDATION_ERROR = validation("999", "The input is invalid");
    public static final ErrorCode TRANSACTION_TYPE_NOT_BLANK = validation("004", "transactionType should not be blank");
    public static final ErrorCode TRANSACTION_TYPE_LENGTH = validation("006", "transactionType has invalid length");
    public static final ErrorCode TRANSACTION_TYPE_ALPHANUMERIC = validation("005", "transactionType should be alphanumeric");
    public static final ErrorCode INVALID_TRANSACTION_TYPE = validation("032", "Invalid transactionType");
    public static final ErrorCode RM_NUMBER_NOT_BLANK = validation("012", "rmNumber should not be blank");
    public static final ErrorCode RM_NUMBER_LENGTH = validation("014", "rmNumber has invalid length");
    public static final ErrorCode RM_NUMBER_NUMERIC = validation("013", "rmNumber should be numeric");
    public static final ErrorCode SOURCE_ACCOUNT_NOT_BLANK = validation("015", "sourceAccountNumber should not be blank");
    public static final ErrorCode SOURCE_ACCOUNT_LENGTH = validation("017", "sourceAccountNumber has invalid length");
    public static final ErrorCode SOURCE_ACCOUNT_PATTERN = validation("016", "sourceAccountNumber should be numeric");
    public static final ErrorCode NUMBER_OF_CHECK_NOT_BLANK = validation("018", "numberOfChecks should not be blank");
    public static final ErrorCode INVALID_NUMBER_OF_CHECK = validation("019", "Invalid numberOfChecks");
    public static final ErrorCode NUMBER_OF_CHECK_GREATER_THAN_0 = validation("020", "numberOfChecks should not be less than or equal to 0");
    
    public static final ErrorCode CONFIRMATION_NUMBER_NOT_BLANK = validation("001", "confirmationNumber should not be blank");
    public static final ErrorCode CONFIRMATION_NUMBER_NUMERIC = validation("002", "confirmationNumber should be numeric");
    public static final ErrorCode CONFIRMATION_NUMBER_LENGTH = validation("003", "confirmationNumber has invalid length");
    public static final ErrorCode TRANSACTION_DATE_NOT_BLANK = validation("007", "transactionDate should not be blank");
    public static final ErrorCode INVALID_TRANSACTION_DATE = validation("008", "Invalid transactionDate");
    public static final ErrorCode USER_ID_NOT_BLANK = validation("009", "userId should not be blank");
    public static final ErrorCode USER_ID_ALPHANUMERIC = validation("010", "userId should be alphanumeric");
    public static final ErrorCode USER_ID_LENGTH = validation("011", "userId has invalid length");
    public static final ErrorCode FEE_NOT_BLANK = validation("021", "fee should not be blank");
    public static final ErrorCode FEE_NUMERIC = validation("022", "fee should be numeric and up to two digit places");
    public static final ErrorCode INSTITUTION_CODE_NOT_BLANK = validation("023", "institutionCode should not be blank");
    public static final ErrorCode INSTITUTION_CODE_NUMERIC = validation("024", "institutionCode should be numeric");
    public static final ErrorCode INSTITUTION_CODE_LENGTH = validation("025", "institutionCode has invalid length");
    public static final ErrorCode BRANCH_CODE_NOT_BLANK = validation("026", "branchCode should not be blank");
    public static final ErrorCode BRANCH_CODE_NUMERIC = validation("027", "branchCode should be numeric");
    public static final ErrorCode BRANCH_CODE_LENGTH = validation("028", "branchCode has invalid length");
    public static final ErrorCode CURRENCY_CODE_NOT_BLANK = validation("029", "currencyCode should not be blank");
    public static final ErrorCode CURRENCY_CODE_NUMERIC = validation("030", "currencyCode should be numeric");
    public static final ErrorCode CURRENCY_CODE_LENGTH = validation("031", "currencyCode has invalid length");

    public static final ErrorCode INVALID_POST_DATE_CHEQUE = validation("033", "maturityDate is invalid");
    public static final ErrorCode BLANK_CORPORATECODE = validation("034", "corporateCode should not be blank");
    public static final ErrorCode BLANK_COLLECTIONACCOUNT = validation("035", "collectionAccount should not be blank");
    public static final ErrorCode BLANK_CHECKAMOUNT = validation("036", "checkAmount should not be blank");
    public static final ErrorCode BLANK_CHECKNUMBER = validation("037", "checkNumber should not be blank");
    public static final ErrorCode BLANK_USERTRAN = validation("038", "userTran should not be blank");
    public static final ErrorCode BLANK_DESCRIPTION = validation("039", "description should not be blank");
    public static final ErrorCode BLANK_MATURITYDATE = validation("040", "maturityDate should not be blank");
    public static final ErrorCode BLANK_CORPORATIONNAME = validation("041", "corporationName should not be blank");
    public static final ErrorCode NON_NUMERIC_CHECKNUMBER = validation("042", "checkNumber should be numeric");
    public static final ErrorCode NON_NUMERIC_COLLECTIONACCOUNT = validation("043", "collectionAccount should be numeric");
    public static final ErrorCode INVALID_CHECKAMOUNT = validation("044", "checkAmount is invalid");
    
 // business error
    public static final ErrorCode CHECKBOOK_REORDER_LIMIT = business("002", "Exceeded limit of checkbook reorder");
    public static final ErrorCode SPIN_INVALID_ACCOUNT = business("004", "Account number is invalid");
    public static final ErrorCode ACCOUNT_DORMANT_CLOSED = business("005", "Account is dormant/closed");
    public static final ErrorCode ACCOUNT_NOT_PHP = business("006", "Account currency is not allowed");
    public static final ErrorCode ACCOUNT_TYPE_NOT_ALLOWED = business("007", "Account type is not allowed");
    public static final ErrorCode ACCOUNT_NOT_FOUND = business("001", "Account not found");
//    public static final ErrorCode INSUFFICIENT_FUNDS = business("003", "Account has insufficient funds");
    public static final ErrorCode AMOUNT_NOT_ZERO = business("009", "Amount to be paid should not be zero");
    public static final ErrorCode ACCOUNT_NOT_VALID = business("008", "Source or Destination Account is not valid");
    public static final ErrorCode PDC_TRANSACTIONFAILED = business("010", "Transaction Failed");
    
 // internal error
    public static final ErrorCode INTERNAL_ERROR = internal("999", "Internal Error");

    private static final Map<String, ErrorCode> map;
    static {
        map = getErrorCodes(ChequeErrorCode.class);
    }

    		
    public ChequeErrorCode(String code, String message) {
        super(code, message);
    }
    
    private static ErrorCode internal(String numericCode, String message) {
        return new ChequeErrorCode("CHQIE" + numericCode, message);
    }

    private static ErrorCode service(String numericCode, String message) {
        return new ChequeErrorCode("CHQSE" + numericCode, message);
    }

    private static ErrorCode business(String numericCode, String message) {
        return new ChequeErrorCode("CHQBE" + numericCode, message);
    }

    private static ErrorCode validation(String numericCode, String message) {
        return new ChequeErrorCode("CHQVE" + numericCode, message);
    }
    
    public static ErrorCode parse(String code) {
        return map.get(code);
    }

}
