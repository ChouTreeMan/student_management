package com.niit_team.student_management.Util;

import java.io.Serializable;

public class ResultResponse<DATA> implements Serializable {
    private Integer code;
    private String message;
    private DATA data;

    public ResultResponse(){}

    public ResultResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultResponse(Integer code, String message, DATA data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <DATA> ResultResponse<DATA> success(DATA data){
        return new ResultResponse<>(200,null,data);
    }

    public static <DATA> ResultResponse<DATA> success(String message,DATA data){
        return new ResultResponse<>(200,message,data);
    }

    public static <DATA> ResultResponse<DATA> success(String message){
        return new ResultResponse<>(200,message,null);
    }

    public static <DATA> ResultResponse<DATA> fail(Integer code,String message){
        return new ResultResponse<>(code,message);
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "code:" + code +
                ", message:'" + message + '\'' +
                ", data:" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DATA getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DATA data) {
        this.data = data;
    }
}
