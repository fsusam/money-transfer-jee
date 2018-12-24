package com.fsusam.tutorial.ejb.money.transfer.persistence.exception;

public enum ExceptionConstants {
    CUSTOMER_NOT_FOUND(1, "Customer was Not Found"),
    ACCOUNT_NOT_FOUND(2, "Account was Not Found"),
    BALANCE_ERROR(3, "There is no enough balance"),
    AMOUNT_ERROR(4, "Amount must be greater than zero"),
    MISSING_PARAMETER(5, "Missing parameter"),
    UNKNOWN_ERROR(99, "Unknown Error");

    private final int code;
    private final String description;

    private ExceptionConstants(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return code + ":" + description;
    }
}
