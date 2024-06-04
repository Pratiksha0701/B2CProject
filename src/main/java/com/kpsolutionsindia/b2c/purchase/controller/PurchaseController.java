/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.purchase.controller;

import com.kpsolutionsindia.b2c.purchase.model.Purchase;
import com.kpsolutionsindia.b2c.purchase.service.PurchaseService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    public PurchaseController() {
        System.out.println("I am in PurchaseController");
    }

    @RequestMapping("add/{purchaseItemId}/{quantity}/{rate}/{date}/{description}")
    public Purchase add(@PathVariable int purchaseItemId, @PathVariable double quantity,
            @PathVariable double rate, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date,
            @PathVariable String description) {

        boolean active = true;
        Purchase purchase = service.add(purchaseItemId, quantity, rate, date, active, description);
        return purchase;
    }

    @RequestMapping("getall")
    public List<Purchase> getAll() {
        List<Purchase> list = service.getAll();
        return list;
    }

    @RequestMapping("get/{id}")
    public Purchase get(@PathVariable int id) {
        Purchase purchase = service.get(id);
        return purchase;
    }

    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping("update/{id}/{purchaseItemId}/{quantity}/{rate}/{date}/{description}")
    public Purchase update(@PathVariable int id, @PathVariable int purchaseItemId,
            @PathVariable double quantity, @PathVariable double rate,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date,
            @PathVariable String description) {

        boolean active = true;
        Purchase purchase = service.update(id, purchaseItemId, quantity, rate, date, active, description);
        return purchase;
    }
}
