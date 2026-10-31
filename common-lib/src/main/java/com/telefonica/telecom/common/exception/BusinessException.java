package com.telefonica.telecom.common.exception;

public class BusinessException extends RuntimeException {

    private String code;

    public BusinessException(String message) {
        super(message);
    }

    // Added this to fix the "actual and formal argument lists differ in length" error
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}