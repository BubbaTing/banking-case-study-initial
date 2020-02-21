package com.example.banking.controller;

import com.example.banking.model.AutoLoanModel;
import com.example.banking.service.AutoLoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("updateLoan/{id}")
    public AutoLoanModel updateLoan(@PathVariable int id, @RequestBody AutoLoanModel user){
        return this.autoLoanService.update(id, user);
    }

    //deleteLoan
    @DeleteMapping("deleteLoan/{id}")
    public ResponseEntity<Boolean> deleteLoan(@PathVariable int id){
        Boolean status = this.autoLoanService.removedLoan(id);
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
    @GetMapping("getLoansById/{clientId}")
    public List<AutoLoanModel> getLoansByClientId(@PathVariable("clientId") String clientId){
        return this.autoLoanService.getLoanById(clientId);
    }
    //getAllLoans
    @GetMapping("getAllLoans")
    public List<AutoLoanModel> getAllLoans(){
        return this.autoLoanService.getAllLoans();
    }
}
