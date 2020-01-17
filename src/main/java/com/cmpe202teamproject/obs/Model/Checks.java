package com.cmpe202teamproject.obs.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Checks implements Transaction{
    private int checkId;
    private Integer accountNum;
    private Integer checkNum;
    private Integer amount;
    private String payeeName;
    private Date date;

    @Id
    @Column(name = "Check_ID")
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
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
    @Column(name = "Check_Num")
    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
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
    @Column(name = "Payee_Name")
    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
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
        Checks checks = (Checks) o;
        return checkId == checks.checkId &&
                Objects.equals(accountNum, checks.accountNum) &&
                Objects.equals(checkNum, checks.checkNum) &&
                Objects.equals(amount, checks.amount) &&
                Objects.equals(payeeName, checks.payeeName) &&
                Objects.equals(date, checks.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkId, accountNum, checkNum, amount, payeeName, date);
    }
}
