package com.cmpe202teamproject.obs.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Payment implements Transaction{
    private int paymentId;
    private Integer accountId;
    private int senderAccountNum;
    private String externalPayeeName;
    private Double amount;
    private String frequency;
    private Date date;

    @Id
    @Column(name = "Payment_ID")
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "Account_ID")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "Sender_Account_Num")
    public int getSenderAccountNum() {
        return senderAccountNum;
    }

    public void setSenderAccountNum(int senderAccountNum) {
        this.senderAccountNum = senderAccountNum;
    }

    @Basic
    @Column(name = "External_Payee_Name")
    public String getExternalPayeeName() {
        return externalPayeeName;
    }

    public void setExternalPayeeName(String externalPayeeName) {
        this.externalPayeeName = externalPayeeName;
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
    @Column(name = "Frequency")
    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
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
        Payment payment = (Payment) o;
        return paymentId == payment.paymentId &&
                senderAccountNum == payment.senderAccountNum &&
                Objects.equals(accountId, payment.accountId) &&
                Objects.equals(externalPayeeName, payment.externalPayeeName) &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(frequency, payment.frequency) &&
                Objects.equals(date, payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, accountId, senderAccountNum, externalPayeeName, amount, frequency, date);
    }
}
