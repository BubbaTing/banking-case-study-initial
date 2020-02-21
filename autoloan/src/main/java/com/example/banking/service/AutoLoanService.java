package com.example.banking.service;

import com.example.banking.model.AutoLoanModel;
import com.example.banking.repository.AutoLoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoLoanService {

    private AutoLoanRepository autoLoanRepository;

    public AutoLoanService(AutoLoanRepository autoLoanRepository) {
        this.autoLoanRepository = autoLoanRepository;
    }


    public AutoLoanModel create(AutoLoanModel user) {
        return this.autoLoanRepository.save(user);
    }

    public List<AutoLoanModel> getLoanById(String clientId) {
        return this.autoLoanRepository.findLoanByClientId(clientId);
    }

    public List<AutoLoanModel> getAllLoans() {
        return (List<AutoLoanModel>) this.autoLoanRepository.findAll();
    }

    public Boolean removedLoan(int id) {
        boolean state = true;
        try {
            this.autoLoanRepository.deleteById(id);
        } catch (Exception e) {
            state = false;
        }
        return state;
    }

    public AutoLoanModel update(int id, AutoLoanModel user){
        user.setId(id);
        return this.autoLoanRepository.save(user);
    }
}
