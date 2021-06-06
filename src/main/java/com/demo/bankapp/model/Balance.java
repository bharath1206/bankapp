package com.demo.bankapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Balance {


    @Id
    private int balanceId;
    private Long accountId;
    private double balance;

    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balanceId=" + balanceId +
                ", accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
