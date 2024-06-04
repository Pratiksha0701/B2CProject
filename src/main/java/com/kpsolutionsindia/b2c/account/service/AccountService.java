/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.account.service;

import com.kpsolutionsindia.b2c.purchase.model.Purchase;
import com.kpsolutionsindia.b2c.purchase.service.PurchaseService;
import com.kpsolutionsindia.b2c.sale.model.Sale;
import com.kpsolutionsindia.b2c.sale.service.SaleService;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 91982
 */
@Service
public class AccountService {

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private SaleService saleService;

    public AccountService() {
        System.out.println("I am in AccountService");
    }

    public Double getTotalPurchase(Date fromdate, Date toDate) {
        double sum = 0;
        ArrayList<Purchase> records = purchaseService.getRecords(fromdate, toDate);
        for (Purchase record : records) {
            double price = record.getPrice();
            sum += price;
        }
        return sum;

    }

    public Double getTotalSale(Date fromDate, Date toDate) {
        double sum = 0;
        ArrayList<Sale> records = saleService.getRecords(fromDate, toDate);
        for (Sale record : records) {
            double price = record.getPrice();
            sum += price;
        }
        return sum;
    }

}
