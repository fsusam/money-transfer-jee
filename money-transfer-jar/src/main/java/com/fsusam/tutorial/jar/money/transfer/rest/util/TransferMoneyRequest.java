package com.fsusam.tutorial.jar.money.transfer.rest.util;

public class TransferMoneyRequest {
    private String sourceIban;
    private String targetIban;
    private Double amount;

    public String getSourceIban() {
        return sourceIban;
    }

    public void setSourceIban(final String sourceIban) {
        this.sourceIban = sourceIban;
    }

    public String getTargetIban() {
        return targetIban;
    }

    public void setTargetIban(final String targetIban) {
        this.targetIban = targetIban;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("TransferMoneyRequest[ sourceIban:%s , targetIban: %s, amount: %f]", sourceIban, targetIban, amount);
    }
}
