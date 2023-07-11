package com.lulobank.exceptions;

import jdk.dynalink.beans.StaticClass;

public class ErrorsAssertion extends AssertionError{

    public static final String THE_CODES_DO_NOT_MATCH = "The last response do are not equal to the status code expected";

    public static final String THE_BREED_DOES_NOT_IS_EQUAL = "The breed does not is equal to United Kingdom";

    public static final String THE_CATEGORIES_DO_NOT_ARE_EQUALS = "The categories do not are equals to 15";

    public static final String THE_VOTE_WAS_NOT_CREATED_SUCCESSFULLY = "The votes do not are created successfully";

    public static final String THE_VOTE_WAS_NOT_DELETE_SUCCESSFULLY = "The vote has not been delete successfully";
}
