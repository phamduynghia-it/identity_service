package com.nghiapham.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    USERNAME_INVALID(1002, "Username must be at least 3 character"),
    PASSWORD_INVALID(1003, "password must be at least 8 character"),
    INVALID_KEY(1004, "Invalid key"),
    USER_NOT_FOUND(404, "User not found"),
    UNAUTHENTICATED (1006, "Unauthitencated")


    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
