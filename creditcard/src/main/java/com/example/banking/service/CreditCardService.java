package com.example.banking.service;

import com.example.banking.model.CreditCardModel;
import com.example.banking.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    private CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCardModel update(int id, CreditCardModel user) {
        user.setId(id);
        return this.creditCardRepository.save(user);
    }

    public CreditCardModel create(CreditCardModel user) {
        return this.creditCardRepository.save(user);
    }

    public Boolean removedCard(int id) {
        boolean state = true;
        try{
            this.creditCardRepository.deleteById(id);
        } catch(Exception e){
            state = false;
        }
        return state;
    }

    public List<CreditCardModel> getCardById(String clientId) {
        return this.creditCardRepository.findCardByClientId(clientId);
    }

    public List<CreditCardModel> getAllCreditCards() {
        return (List<CreditCardModel>) this.creditCardRepository.findAll();
    }
}
