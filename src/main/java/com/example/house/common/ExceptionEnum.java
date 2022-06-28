package com.example.house.common;


/**
 * @author Admin
 */

public enum ExceptionEnum {
    //返回成功
    SUCCESS(10000000, "SUCCESS", "执行成功"),
    //返回失败
    SYSTEM_ERROR(10000001, "SYSTEM_ERROR", "系统异常");

    private final int code;
    private final String value;
    private final String message;
    
    private ExceptionEnum(int code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String value() {
        return this.value;
    }

    public String message() {
        return this.message;
    }
}
