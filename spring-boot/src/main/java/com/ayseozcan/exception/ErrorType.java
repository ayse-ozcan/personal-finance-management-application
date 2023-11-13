package com.ayseozcan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    VALIDATION_ERROR(3000, "Validation error", HttpStatus.BAD_REQUEST),
    BAD_REQUEST(4000, "Request format is invalid", HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR(5000, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_DUPLICATE(4002, "User already exist", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4003, "User not found", HttpStatus.NOT_FOUND),
    EXPENSE_NOT_FOUND(5003, "Expense not found", HttpStatus.NOT_FOUND),
    INCOME_NOT_FOUND(6003, "Income not found", HttpStatus.NOT_FOUND),
    CHECK_INPUT(4006, "Incorrect username or password", HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4004, "Invalid token", HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4005, "Token not created", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
