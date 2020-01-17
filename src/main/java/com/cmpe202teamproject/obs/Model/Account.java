package com.cmpe202teamproject.obs.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Random;

@Entity
public class Account{
    private int accountId;
    private Integer customerId;
    private Integer accountNum;
    private String accountType;
    private Double balance;

    @Id
    @Column(name = "Account_ID")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "Customer_ID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "Account_Num")
    public Integer getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    @Basic
    @Column(name = "Account_Type")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "Balance")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void generateAccountNum(){
        Random random = new Random();
        this.accountNum = 100000 + random.nextInt(900000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                Objects.equals(customerId, account.customerId) &&
                Objects.equals(accountNum, account.accountNum) &&
                Objects.equals(accountType, account.accountType) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, customerId, accountNum, accountType, balance);
    }
}
