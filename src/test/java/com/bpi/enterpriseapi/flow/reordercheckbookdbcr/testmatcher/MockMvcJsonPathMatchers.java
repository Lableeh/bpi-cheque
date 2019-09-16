package com.bpi.enterpriseapi.flow.reordercheckbookdbcr.testmatcher;

import org.hamcrest.Matcher;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class MockMvcJsonPathMatchers extends MockMvcResultMatchers{

	private static final String STATUS = "$.status";

    private static final String CODE = "$.code";

    private static final String DESCRIPTION = "$.description";

    private static final String ERROR = "$.errorDetails";

    private static final String ERROR_DETAILS = "$.errorDetails%s";

    private static final String ERROR_DETAILS_CODE = "$.errorDetails[%d].code";

    private static final String ERROR_DETAILS_MESSAGE = "$.errorDetails[%d].message";

    private static final String ERROR_DETAILS_DETAILS = "$.errorDetails[%d].details";

    private static final String BODY = "$.body";

    private static final String BODY_DETAILS = "$.body%s";

    public static <T> ResultMatcher status(Matcher<T> matcher) {
        return jsonPath(STATUS, matcher);
    }

    public static <T> ResultMatcher code(Matcher<T> matcher) {
        return jsonPath(CODE, matcher);
    }

    public static JsonPathResultMatchers description() {
        return jsonPath(DESCRIPTION);
    }

    public static <T> ResultMatcher description(Matcher<T> matcher) {
        return jsonPath(DESCRIPTION, matcher);
    }

    public static JsonPathResultMatchers errorDetails() {
        return jsonPath(ERROR);
    }

    public static <T> ResultMatcher errorDetails(Matcher<T> matcher) {
        return jsonPath(ERROR, matcher);
    }

    public static <T> ResultMatcher errorDetails(String expression, Matcher<T> matcher) {
        return jsonPath(String.format(ERROR_DETAILS, expression), matcher);
    }

    public static <T> ResultMatcher errorDetailsCode(int index, Matcher<T> matcher) {
        return jsonPath(String.format(ERROR_DETAILS_CODE, index), matcher);
    }

    public static <T> ResultMatcher errorDetailsMessage(int index, Matcher<T> matcher) {
        return jsonPath(String.format(ERROR_DETAILS_MESSAGE, index), matcher);
    }

    public static <T> ResultMatcher errorDetailsDescription(int index, Matcher<T> matcher) {
        return jsonPath(String.format(ERROR_DETAILS_DETAILS, index), matcher);
    }

    public static JsonPathResultMatchers body() {
        return jsonPath(BODY);
    }

    public static <T> ResultMatcher body(Matcher<T> matcher) {
        return jsonPath(BODY, matcher);
    }

    public static <T> ResultMatcher body(String expression, Matcher<T> matcher) {
        return jsonPath(String.format(BODY_DETAILS, expression), matcher);
    }

}
