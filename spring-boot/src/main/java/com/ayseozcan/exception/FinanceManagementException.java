package com.ayseozcan.exception;

import lombok.Getter;

@Getter
public class FinanceManagementException extends RuntimeException {
    private final ErrorType errorType;

    public FinanceManagementException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public FinanceManagementException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
