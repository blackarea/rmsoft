package com.example.rmsoft.model.base;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    SUCCESS(true, 1000, "요청에 성공하였습니다."),
    FAIL(false, 2000, "요청에 실패하였습니다.");

    private final boolean isSuccess;
    private final String message;
    private final int code;

    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

}
