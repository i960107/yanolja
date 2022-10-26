package com.example.demo.config.interceptor;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.config.BaseResponseStatus;
import io.sentry.Sentry;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class DefaultControllerAdvice {
    @ExceptionHandler(BaseException.class)
    public @ResponseBody
    BaseResponse handleJwtException(BaseException exception) {
        return new BaseResponse<>(exception.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody BaseResponse handleException(Exception e) {
        Sentry.captureException(e);
        return new BaseResponse<>(new BaseException(BaseResponseStatus.SERVER_EXCEPTION).getStatus());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody BaseResponse handleHttpMessageNotReadableExceptionException(HttpMessageNotReadableException e) {
        return new BaseResponse<>(new BaseException(BaseResponseStatus.REQUEST_ERROR).getStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody BaseResponse handleRuntimeException(RuntimeException e) {
        Sentry.captureException(e);
        return new BaseResponse<>(new BaseException(BaseResponseStatus.SERVER_RUNTIME_EXCEPTION).getStatus());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse handleMethodValidException(MethodArgumentNotValidException e) throws BaseException {
        BaseResponse response = null;
        String message ="입력값을 확인하세요";
        List<FieldError> errors= e.getBindingResult().getFieldErrors();
        for(FieldError error : errors){
            message+=" ["+error.getField()+"]는 "+error.getDefaultMessage();

        }
        response = new BaseResponse<>(message);
        return response;
    }
}
