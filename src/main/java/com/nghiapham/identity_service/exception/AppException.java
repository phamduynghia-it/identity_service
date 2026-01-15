package com.nghiapham.identity_service.exception;

public class AppException  extends RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrolCode() {
        return errorCode;
    }

    public void setErrolCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
