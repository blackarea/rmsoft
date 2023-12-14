package com.example.rmsoft.module;

import com.example.rmsoft.model.base.BaseException;
import com.example.rmsoft.model.base.BaseResponse;
import com.example.rmsoft.model.base.BaseResponseStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public BaseResponse<BaseResponseStatus> baseException(BaseException e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder logMessage = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            logMessage.append(stackTrace[i]).append(", ");
        }
        log.error("BaseException Error : " + "Error status : " + e.getStatus().toString() + ", Path = " + logMessage);
        return new BaseResponse<>(e.getStatus());
    }

}
