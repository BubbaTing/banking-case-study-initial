package com.example.banking.controller;
import com.example.banking.model.CreditCardModel;
import com.example.banking.service.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditcard/")
public class CreditCardController {

    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    //createLoan
    @PostMapping("createCreditCard")
    public CreditCardModel createCard(@RequestBody CreditCardModel user){
        return this.creditCardService.create(user);
    }

    //updateLoan
    @PutMapping("updateCreditCard/{id}")
    public CreditCardModel updateCard(@PathVariable int id, @RequestBody CreditCardModel user){
        return this.creditCardService.update(id, user);
    }

    //deleteLoan
    @DeleteMapping("deleteCreditCard/{id}")
    public ResponseEntity<Boolean> deleteCard(@PathVariable int id){
        Boolean status = this.creditCardService.removedCard(id);
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
    @GetMapping("getCreditCardsByClientId/{clientId}")
    public List<CreditCardModel> getCardsByClientId(@PathVariable("clientId") String clientId){
        return this.creditCardService.getCardById(clientId);
    }
    //getAllLoans
    @GetMapping("getAllCreditCards")
    public List<CreditCardModel> getAllCards(){
        return this.creditCardService.getAllCreditCards();
    }
}
