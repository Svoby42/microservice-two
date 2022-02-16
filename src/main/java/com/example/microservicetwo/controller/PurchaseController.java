package com.example.microservicetwo.controller;

import com.example.microservicetwo.model.Purchase;
import com.example.microservicetwo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllPurchasesOfUser(@PathVariable Long userId){
        return new ResponseEntity<>(purchaseService.findAllPurchasesOfUser(userId), HttpStatus.OK);
    }


}
