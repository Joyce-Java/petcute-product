package com.system.systemerp.web;

public enum WebAPIStatusEnum {

    // 成功
    SUCCESS("000000", "成功"),

    // 失敗
    FAIL("900002", "系統異常，請連繫系統人員!");

    private String statusCode;

    private String showMsg;

    private WebAPIStatusEnum(String statusCode, String showMsg) {
        this.statusCode = statusCode;
        this.showMsg = showMsg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getShowMsg() {
        return showMsg;
    }
}
