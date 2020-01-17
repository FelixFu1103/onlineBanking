package com.cmpe202teamproject.obs.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "External_Payee", schema = "obs_database")
public class ExternalPayee implements Transaction{
    private int externalPayeeId;
    private String payeeName;
    private Double balance;

    @Id
    @Column(name = "External_Payee_ID")
    public int getExternalPayeeId() {
        return externalPayeeId;
    }

    public void setExternalPayeeId(int externalPayeeId) {
        this.externalPayeeId = externalPayeeId;
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
    @Column(name = "Balance")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalPayee that = (ExternalPayee) o;
        return externalPayeeId == that.externalPayeeId &&
                Objects.equals(payeeName, that.payeeName) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalPayeeId, payeeName, balance);
    }
}
