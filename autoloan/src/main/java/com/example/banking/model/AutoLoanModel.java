package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    }

    public AutoLoanModel(String clientId, String name, double balance) {
        this.clientId = clientId;
        this.name = name;
        this.balance = balance;
    }

    public static LoanBuilder builder() {
        return new LoanBuilder();
    }

    public static final class LoanBuilder {

        private AutoLoanModel autoLoanModel;

        private LoanBuilder() {
            autoLoanModel = new AutoLoanModel();
        }
        public LoanBuilder withClientId(String clientId){
            autoLoanModel.setClientId(clientId);
            return this;
        }

        public LoanBuilder withName(String name){
            autoLoanModel.setName(name);
            return this;
        }

        public LoanBuilder withBalance(double balance){
            autoLoanModel.setBalance(balance);
            return this;
        }

        public AutoLoanModel build() {
            return autoLoanModel;
        }
    }
}
