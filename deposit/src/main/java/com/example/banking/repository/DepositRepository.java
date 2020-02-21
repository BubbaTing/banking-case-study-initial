package com.example.banking.repository;

import com.example.banking.model.DepositModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositRepository extends CrudRepository<DepositModel, Integer> {
    List<DepositModel> findAccountByClientId(String clientId);
}