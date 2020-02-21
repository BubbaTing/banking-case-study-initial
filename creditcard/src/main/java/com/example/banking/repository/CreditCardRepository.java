package com.example.banking.repository;

import com.example.banking.model.CreditCardModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardModel, Integer> {
    List<CreditCardModel> findCardByClientId(String clientId);
}
