package com.fsusam.tutorial.jar.money.transfer.rest.util;

public class ErrorResponse {

    private String status;
    private Integer code;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
