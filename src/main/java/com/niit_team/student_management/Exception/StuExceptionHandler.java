package com.niit_team.student_management.Exception;

import com.niit_team.student_management.Util.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StuExceptionHandler {

    @ExceptionHandler(StuNotFoundException.class)
    public ResultResponse<Object> notFoundException(StuNotFoundException exc){
        ResultResponse<Object> error = new ResultResponse<>();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        return error;
    }

    @ExceptionHandler(StuNullPointerException.class)
    public ResultResponse<Object> badRequestException(StuNullPointerException exc){
        ResultResponse<Object> error = new ResultResponse<>();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return error;
    }
}
