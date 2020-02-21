package com.example.banking.service;

import com.example.banking.model.DepositModel;
import com.example.banking.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositService {

    private DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public DepositModel create(DepositModel user) {
        return this.depositRepository.save(user);
    }


    public DepositModel update(int id, DepositModel user) {
        user.setId(id);
        return this.depositRepository.save(user);
    }

    public Boolean removedAccount(int id) {
        boolean state = true;
        try{
            this.depositRepository.deleteById(id);
        } catch(Exception e){
            state = false;
        }
        return state;
    }

    public List<DepositModel> getAccountById(String clientId) {
        return this.depositRepository.findAccountByClientId(clientId);
    }

    public List<DepositModel> getAllDepositAccounts() {
        return (List<DepositModel>) this.depositRepository.findAll();
    }
}
