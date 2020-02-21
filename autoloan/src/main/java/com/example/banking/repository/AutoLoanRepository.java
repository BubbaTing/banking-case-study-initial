package com.example.banking.repository;

import com.example.banking.model.AutoLoanModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutoLoanRepository extends CrudRepository<AutoLoanModel, Integer> {
    List<AutoLoanModel> findLoanByClientId(String clientId);
}
