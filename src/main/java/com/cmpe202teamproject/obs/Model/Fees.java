package com.cmpe202teamproject.obs.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Fees implements Transaction{
    private int feesId;
    private Integer accountNum;
    private Integer amount;
    private Date date;

    @Id
    @Column(name = "Fees_ID")
    public int getFeesId() {
        return feesId;
    }

    public void setFeesId(int feesId) {
        this.feesId = feesId;
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
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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
        Fees fees = (Fees) o;
        return feesId == fees.feesId &&
                Objects.equals(accountNum, fees.accountNum) &&
                Objects.equals(amount, fees.amount) &&
                Objects.equals(date, fees.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feesId, accountNum, amount, date);
    }
}
