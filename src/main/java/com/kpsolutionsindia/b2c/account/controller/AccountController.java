/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.account.controller;

import com.kpsolutionsindia.b2c.account.service.AccountService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 91982
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController() {
        System.out.println("I am in AccountController");
    }

    @RequestMapping("get_total_purchase/{fromDate}/{toDate}")
    public Double getTotalPurchase(@PathVariable Date fromDate, @PathVariable Date toDate) {
        Double totalPurchase = accountService.getTotalPurchase(fromDate, toDate);
        return totalPurchase;
    }

    @RequestMapping("get_total_sale/{fromDate}/{toDate}")
    public Double getTotalSale(@PathVariable Date fromDate, @PathVariable Date toDate) {
        Double totalPurchase = accountService.getTotalSale(fromDate, toDate);
        return totalPurchase;
    }

}
