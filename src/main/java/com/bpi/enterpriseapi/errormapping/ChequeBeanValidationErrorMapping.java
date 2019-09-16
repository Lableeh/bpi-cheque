package com.bpi.enterpriseapi.errormapping;

import java.util.Map;

import com.bpi.enterpriseapi.errorcode.ChequeErrorCode;
import com.bpi.framework.errorcode.ErrorCode;
import com.bpi.framework.errormapping.ErrorMapping;

public class ChequeBeanValidationErrorMapping extends ErrorMapping{

	public static final ErrorMapping TRANSACTION_TYPE_NOT_BLANK = create("NotBlank.transactionType", ChequeErrorCode.TRANSACTION_TYPE_NOT_BLANK);
    public static final ErrorMapping TRANSACTION_TYPE_LENGTH = create("Length.transactionType", ChequeErrorCode.TRANSACTION_TYPE_LENGTH);
    public static final ErrorMapping TRANSACTION_TYPE_ALPHANUMERIC = create("Pattern.transactionType", ChequeErrorCode.TRANSACTION_TYPE_ALPHANUMERIC);
    public static final ErrorMapping INVALID_TRANSACTION_TYPE = create("AcceptedStringValue.transactionType", ChequeErrorCode.INVALID_TRANSACTION_TYPE);
    public static final ErrorMapping RM_NUMBER_NOT_BLANK = create("NotBlank.rmNumber", ChequeErrorCode.RM_NUMBER_NOT_BLANK);
    public static final ErrorMapping RM_NUMBER_LENGTH = create("Length.rmNumber", ChequeErrorCode.RM_NUMBER_LENGTH);
    public static final ErrorMapping RM_NUMBER_NUMERIC = create("Pattern.rmNumber", ChequeErrorCode.RM_NUMBER_NUMERIC);
    public static final ErrorMapping SOURCE_ACCOUNT_NOT_BLANK = create("NotBlank.sourceAccountNumber", ChequeErrorCode.SOURCE_ACCOUNT_NOT_BLANK);
    public static final ErrorMapping SOURCE_ACCOUNT_LENGTH = create("AcceptedLength.sourceAccountNumber", ChequeErrorCode.SOURCE_ACCOUNT_LENGTH);
    public static final ErrorMapping SOURCE_ACCOUNT_PATTERN = create("Pattern.sourceAccountNumber", ChequeErrorCode.SOURCE_ACCOUNT_PATTERN);
    public static final ErrorMapping NUMBER_OF_CHECK_NOT_BLANK = create("NotNull.numberOfChecks", ChequeErrorCode.NUMBER_OF_CHECK_NOT_BLANK);
    public static final ErrorMapping INVALID_NUMBER_OF_CHECK = create("numberOfChecks", ChequeErrorCode.INVALID_NUMBER_OF_CHECK);
    public static final ErrorMapping NUMBER_OF_CHECK_GREATER_THAN_0 = create("Min.numberOfChecks", ChequeErrorCode.NUMBER_OF_CHECK_GREATER_THAN_0);

    public static final ErrorMapping CONFIRMATION_NUMBER_NOT_BLANK = create("NotBlank.confirmationNumber", ChequeErrorCode.CONFIRMATION_NUMBER_NOT_BLANK);
    public static final ErrorMapping CONFIRMATION_NUMBER_NUMERIC = create("Pattern.confirmationNumber", ChequeErrorCode.CONFIRMATION_NUMBER_NUMERIC);
    public static final ErrorMapping CONFIRMATION_NUMBER_LENGTH = create("Length.confirmationNumber", ChequeErrorCode.CONFIRMATION_NUMBER_LENGTH);
    public static final ErrorMapping TRANSACTION_DATE_NOT_BLANK = create("NotNull.transactionDate", ChequeErrorCode.TRANSACTION_DATE_NOT_BLANK);
    public static final ErrorMapping INVALID_TRANSACTION_DATE = create("transactionDate", ChequeErrorCode.INVALID_TRANSACTION_DATE);
    public static final ErrorMapping USER_ID_NOT_BLANK = create("NotBlank.userId", ChequeErrorCode.USER_ID_NOT_BLANK);
    public static final ErrorMapping USER_ID_ALPHANUMERIC = create("Pattern.userId", ChequeErrorCode.USER_ID_ALPHANUMERIC);
    public static final ErrorMapping USER_ID_LENGTH = create("Length.userId", ChequeErrorCode.USER_ID_LENGTH);
    public static final ErrorMapping FEE_NOT_BLANK = create("NotNull.fee", ChequeErrorCode.FEE_NOT_BLANK);
    public static final ErrorMapping FEE_NUMERIC = create("Digits.fee", ChequeErrorCode.FEE_NUMERIC);
    public static final ErrorMapping INSTITUTION_CODE_NOT_BLANK = create("NotBlank.institutionCode", ChequeErrorCode.INSTITUTION_CODE_NOT_BLANK);
    public static final ErrorMapping INSTITUTION_CODE_NUMERIC = create("Pattern.institutionCode", ChequeErrorCode.INSTITUTION_CODE_NUMERIC);
    public static final ErrorMapping INSTITUTION_CODE_LENGTH = create("Length.institutionCode", ChequeErrorCode.INSTITUTION_CODE_LENGTH);
    public static final ErrorMapping BRANCH_CODE_NOT_BLANK = create("NotBlank.branchCode", ChequeErrorCode.BRANCH_CODE_NOT_BLANK);
    public static final ErrorMapping BRANCH_CODE_NUMERIC = create("Pattern.branchCode", ChequeErrorCode.BRANCH_CODE_NUMERIC);
    public static final ErrorMapping BRANCH_CODE_LENGTH = create("Length.branchCode", ChequeErrorCode.BRANCH_CODE_LENGTH);
    public static final ErrorMapping CURRENCY_CODE_NOT_BLANK = create("NotBlank.currencyCode", ChequeErrorCode.CURRENCY_CODE_NOT_BLANK);
    public static final ErrorMapping CURRENCY_CODE_NUMERIC = create("Pattern.currencyCode", ChequeErrorCode.CURRENCY_CODE_NUMERIC);
    public static final ErrorMapping CURRENCY_CODE_LENGTH = create("Length.currencyCode", ChequeErrorCode.CURRENCY_CODE_LENGTH);

    public static final ErrorMapping INVALID_POST_DATE_CHEQUE = create("ValidPostDateCheque.maturityDate", ChequeErrorCode.INVALID_POST_DATE_CHEQUE);
    public static final ErrorMapping BLANK_CORPORATECODE = create("NotBlank.corporateCode", ChequeErrorCode.BLANK_CORPORATECODE);
    public static final ErrorMapping BLANK_COLLECTIONACCOUNT = create("NotBlank.collectionAccount", ChequeErrorCode.BLANK_COLLECTIONACCOUNT);
    public static final ErrorMapping BLANK_CHECKAMOUNT = create("NotBlank.checkAmount", ChequeErrorCode.BLANK_CHECKAMOUNT);
    public static final ErrorMapping BLANK_CHECKNUMBER = create("NotBlank.checkNumber", ChequeErrorCode.BLANK_CHECKNUMBER);
    public static final ErrorMapping BLANK_USERTRAN = create("NotBlank.userTran", ChequeErrorCode.BLANK_USERTRAN);
    public static final ErrorMapping BLANK_DESCRIPTION = create("NotBlank.description", ChequeErrorCode.BLANK_DESCRIPTION);
    public static final ErrorMapping BLANK_MATURITYDATE = create("NotBlank.maturityDate", ChequeErrorCode.BLANK_MATURITYDATE);
    public static final ErrorMapping BLANK_CORPORATIONNAME = create("NotBlank.corporationName", ChequeErrorCode.BLANK_CORPORATIONNAME);
    public static final ErrorMapping NON_NUMERIC_CHECKNUMBER = create("Pattern.checkNumber", ChequeErrorCode.NON_NUMERIC_CHECKNUMBER);
    public static final ErrorMapping NON_NUMERIC_COLLECTIONACCOUNT = create("Pattern.collectionAccount", ChequeErrorCode.NON_NUMERIC_COLLECTIONACCOUNT);
    public static final ErrorMapping INVALID_CHECKAMOUNT = create("ValidChequeAmount.checkAmount", ChequeErrorCode.INVALID_CHECKAMOUNT);

    private static final String GROUP = "DEFAULT";
    private static final Map<String, ErrorMapping> map;
    
    static {
        map = getErrorMappings(ChequeBeanValidationErrorMapping.class);
    }

    private ChequeBeanValidationErrorMapping(String externalCode, ErrorCode errorCode) {
        super(GROUP, externalCode, errorCode);
    }
    
    private static ChequeBeanValidationErrorMapping create(String externalCode, ErrorCode errorCode) {
        return new ChequeBeanValidationErrorMapping(externalCode, errorCode);
    }

    public static ErrorMapping parse(String code) {
        return map.get(key(GROUP, code));
    }
}
