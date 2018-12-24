package com.fsusam.tutorial.ejb.money.transfer.persistence.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "transactionTime", nullable = false)
    private LocalDate transactionTime;

    @ManyToOne
    @JoinColumn(name = "targetAccountId", nullable = false)
    private Account targetAccount;

    @ManyToOne
    @JoinColumn(name = "sourceAccountId", nullable = false)
    private Account sourceAccount;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(final Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(final Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public LocalDate getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(final LocalDate transactionTime) {
        this.transactionTime = transactionTime;
    }
}
