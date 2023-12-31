package com.admin.dart.collector.exception;

import com.admin.dart.collector.code.ErrorCode;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;
    private final String code;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.code = errorCode.getCode();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getCode() {
        return code;
    }

}
