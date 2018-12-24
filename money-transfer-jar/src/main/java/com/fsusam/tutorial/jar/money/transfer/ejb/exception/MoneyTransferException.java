package com.fsusam.tutorial.jar.money.transfer.ejb.exception;

public class MoneyTransferException extends Exception {
    private final int code;

    public MoneyTransferException(final String message, final Throwable cause, final int code) {
        super(message, cause);
        this.code = code;
    }

    public MoneyTransferException(final String message, final int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
