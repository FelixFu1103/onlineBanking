package com.cmpe202teamproject.obs.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Deposit implements Transaction{
    private int depositId;
    private Integer accountNum;
    private Double amount;
    private Date date;

    @Id
    @Column(name = "Deposit_ID")
    public int getDepositId() {
        return depositId;
    }

    public void setDepositId(int depositId) {
        this.depositId = depositId;
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
    @Column(name = "Amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return depositId == deposit.depositId &&
                Objects.equals(accountNum, deposit.accountNum) &&
                Objects.equals(amount, deposit.amount) &&
                Objects.equals(date, deposit.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depositId, accountNum, amount, date);
    }
}
