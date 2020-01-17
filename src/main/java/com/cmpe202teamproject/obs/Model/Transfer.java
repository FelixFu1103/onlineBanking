package com.cmpe202teamproject.obs.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Transfer implements Transaction {
    private int transferId;
    private Integer accountId;
    private int senderAccountNum;
    private int receiverAccountNum;
    private Double amount;
    private String frequency;
    private Date date;

    @Id
    @Column(name = "Transfer_ID")
    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
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
    @Column(name = "Receiver_Account_Num")
    public int getReceiverAccountNum() {
        return receiverAccountNum;
    }

    public void setReceiverAccountNum(int receiverAccountNum) {
        this.receiverAccountNum = receiverAccountNum;
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

    public void setDate(Date transferDate) {
        this.date = transferDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return transferId == transfer.transferId &&
                senderAccountNum == transfer.senderAccountNum &&
                receiverAccountNum == transfer.receiverAccountNum &&
                Objects.equals(accountId, transfer.accountId) &&
                Objects.equals(amount, transfer.amount) &&
                Objects.equals(frequency, transfer.frequency) &&
                Objects.equals(date, transfer.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transferId, accountId, senderAccountNum, receiverAccountNum, amount, frequency, date);
    }
}
