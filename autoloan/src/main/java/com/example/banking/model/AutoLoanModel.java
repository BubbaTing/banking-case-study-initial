package com.example.banking.model;

import javax.persistence.*;

@Entity
public class AutoLoanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String clientId;
    private String name;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AutoLoanModel{");
        sb.append("id=").append(id);
        sb.append(", clientId='").append(clientId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    public AutoLoanModel() {
        super();
    }
}
