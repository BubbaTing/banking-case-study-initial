package com.example.banking.controller;


import com.example.banking.model.DepositModel;
import com.example.banking.service.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposit/")
public class DepositController {

    private DepositService depositServiceService;

    public DepositController(DepositService depositServiceService) {
        this.depositServiceService = depositServiceService;
    }

    //createLoan
    @PostMapping("createDepositAccount")
    public DepositModel createAccount(@RequestBody DepositModel user){
        return this.depositServiceService.create(user);
    }

    //updateLoan
    @PutMapping("updateDepositAccount/{id}")
    public DepositModel updateAccount(@PathVariable int id, @RequestBody DepositModel user){
        return this.depositServiceService.update(id, user);
    }

    //deleteLoan
    @DeleteMapping("deleteDepositAccount/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable int id){
        Boolean status = this.depositServiceService.removedAccount(id);
        HttpStatus code;
        String message = "";
        if(status){
            code = HttpStatus.NO_CONTENT;
        } else {
            code = HttpStatus.NOT_FOUND;
            message = "Record not deleted.";

        }

        return new ResponseEntity(message, code);
    }
    //getLoansByClientId
    @GetMapping("getDepositAccountsByClientId/{clientId}")
    public List<DepositModel> getAccountsByClientId(@PathVariable("clientId") String clientId){
        return this.depositServiceService.getAccountById(clientId);
    }
    //getAllLoans
    @GetMapping("getAllDepositAccounts")
    public List<DepositModel> getAllAccounts(){
        return this.depositServiceService.getAllDepositAccounts();
    }
}
