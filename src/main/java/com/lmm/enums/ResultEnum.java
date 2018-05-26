package com.lmm.enums;

/**
 * Created by lmm on 2018/5/26.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能还在上初中")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 枚举里面只给get方法即可
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
