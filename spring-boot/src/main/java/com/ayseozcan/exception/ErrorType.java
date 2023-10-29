package com.ayseozcan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    VALIDATION_ERROR(3000,"Validation error",HttpStatus.BAD_REQUEST),
    BAD_REQUEST(4000,"Request format is invalid", HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR(5000,"Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_DUPLICATE(4002,"User already exist" ,HttpStatus.BAD_REQUEST);
    private int code;
    private String message;
    HttpStatus httpStatus;
}
