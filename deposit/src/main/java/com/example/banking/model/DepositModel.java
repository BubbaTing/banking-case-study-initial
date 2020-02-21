package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String clientId;
    //TODO create random generated numbers
    private String accountNumber;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public DepositModel() {
    }

    public static DepositBuilder builder() {
        return new DepositBuilder();
    }

    public static final class DepositBuilder {

        private DepositModel depositModel;

        private DepositBuilder() {
            depositModel = new DepositModel();
        }
        public DepositBuilder withClientId(String clientId){
            depositModel.setClientId(clientId);
            return this;
        }

        public DepositBuilder withAccountNumber(String accountNumber){
            depositModel.setAccountNumber(accountNumber);
            return this;
        }

        public DepositBuilder withName(String name){
            depositModel.setName(name);
            return this;
        }

        public DepositBuilder withBalance(double balance){
            depositModel.setBalance(balance);
            return this;
        }

        public DepositModel build() {
            return depositModel;
        }
    }
}
