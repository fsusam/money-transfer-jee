package com.fsusam.tutorial.jar.money.transfer.ejb.utils;

import com.fsusam.tutorial.jar.money.transfer.ejb.exception.ExceptionConstants;
import com.fsusam.tutorial.jar.money.transfer.ejb.exception.MoneyTransferException;

public class Validation {

    public static void validateMissingParameter(final Object... params) throws MoneyTransferException {
        for (final Object param : params) {
            if (param == null) {
                throw new MoneyTransferException(ExceptionConstants.MISSING_PARAMETER.getDescription(),
                        ExceptionConstants.MISSING_PARAMETER.getCode());
            }
        }
    }

    public static void validateAmount(final Double amount) throws MoneyTransferException {
        if (amount.doubleValue() <= 0) {
            throw new MoneyTransferException(ExceptionConstants.AMOUNT_ERROR.getDescription(), ExceptionConstants.AMOUNT_ERROR.getCode());
        }
    }

    public static void validateBalance(final Double balance) throws MoneyTransferException {
        if (balance == null || balance.doubleValue() <= 0) {
            throw new MoneyTransferException(ExceptionConstants.BALANCE_ERROR.getDescription(), ExceptionConstants.BALANCE_ERROR.getCode());
        }
    }
}
