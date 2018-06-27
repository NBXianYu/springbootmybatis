package com.example.springbootmybatis.dto;

public enum AuthResult {
    OK(""),
    USER_NOT_FOUND("登录失败，用户不存在"),
    PASS_ERROR("登录失败，密码错误"),
    SYSTEM_ERROR("登录失败，系统异常");

    private String tips;
    private AuthResult(String tips){
        this.tips = tips;
    }

    public String getTips() {
        return tips;
    }
}
