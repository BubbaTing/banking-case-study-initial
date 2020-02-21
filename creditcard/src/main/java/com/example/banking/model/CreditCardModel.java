package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String clientId;
    private String number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public CreditCardModel() {
    }

    public CreditCardModel(String clientId, String name, double balance) {
        this.clientId = clientId;
        this.name = name;
        this.balance = balance;
    }

    public static CreditCardBuilder builder() {
        return new CreditCardBuilder();
    }

    public static final class CreditCardBuilder {

        private CreditCardModel creditCardModel;

        private CreditCardBuilder() {
            creditCardModel = new CreditCardModel();
        }
        public CreditCardBuilder withClientId(String clientId){
            creditCardModel.setClientId(clientId);
            return this;
        }

        public CreditCardBuilder withNumber(String number){
            creditCardModel.setNumber(number);
            return this;
        }

        public CreditCardBuilder withName(String name){
            creditCardModel.setName(name);
            return this;
        }

        public CreditCardBuilder withBalance(double balance){
            creditCardModel.setBalance(balance);
            return this;
        }

        public CreditCardModel build() {
            return creditCardModel;
        }
    }
}
