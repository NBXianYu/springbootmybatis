package com.example.springbootmybatis.utils;


public class ResponseResult<T> {
    private ResultStatus status = ResultStatus.SUCCESS;
    private String message;
    private T responseData;

    public ResponseResult() {
    }
    public ResponseResult(T responseData) {
        this.responseData = responseData;
    }

    public ResponseResult(ResultStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", responseData=" + responseData +
                '}';
    }
}
