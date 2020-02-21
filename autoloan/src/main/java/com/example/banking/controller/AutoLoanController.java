package com.example.banking.controller;

import com.example.banking.model.AutoLoanModel;
import com.example.banking.service.AutoLoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoloan/")
public class AutoLoanController {

    private AutoLoanService autoLoanService;

    public AutoLoanController(AutoLoanService autoLoanService) {
        this.autoLoanService = autoLoanService;
    }

    //createLoan
    @PostMapping("createLoan")
    public AutoLoanModel createLoan(@RequestBody AutoLoanModel user){
        return this.autoLoanService.create(user);
    }

    //updateLoan
    @PutMapping("updateLoan/{clientId}")
    public String updateLoan(@PathVariable String clientId){
        return "updated a loan";
    }
    //deleteLoan
    @DeleteMapping("deleteLoan/{clientId}")
    public String deleteLoan(@PathVariable String clientId){
        return "removed a loan";
    }
    //getLoansByClientId
    @GetMapping("getLoansById/{clientId}")
    public List<AutoLoanModel> getLoansByClientId(@PathVariable("clientId") String clientId){
        return this.autoLoanService.getLoanById(clientId);
    }
    //getAllLoans
    @GetMapping("getAllLoans")
    public List<AutoLoanModel> getAllLoans(){
        return (List<AutoLoanModel>) this.autoLoanService.getAllLoans();
    }
}
