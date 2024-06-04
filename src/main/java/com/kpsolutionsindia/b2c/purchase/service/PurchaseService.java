/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.purchase.service;

import com.kpsolutionsindia.b2c.purchase.model.Purchase;
import com.kpsolutionsindia.b2c.purchase.repository.PurchaseRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private PurchaseItemService purchaseItemService;

    public PurchaseService() {
        System.out.println("I am in PurchaseService");
    }

    public Purchase add(int purchaseItemId, double quantity, double rate,
            Date date, boolean active, String description) {
        if (purchaseItemService.get(purchaseItemId) != null) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseItemId(purchaseItemId);
            purchase.setQuantity(quantity);
            purchase.setRate(rate);
            purchase.setPrice(quantity * rate);
            purchase.setDate(date);
            purchase.setActive(active);
            purchase.setDescription(description);
            repository.save(purchase);
            return purchase;
        } else {
            return null;
        }

    }

    public List<Purchase> getAll() {
        return repository.findAll();
    }

    public Purchase get(int id) {
        Optional<Purchase> optional = repository.findById(id);
        if (optional.isPresent()) {
            Purchase purchase = optional.get();
            return purchase;
        }
        return null;
    }

    public Purchase getActiveRecord(int id) {
        Purchase purchase = get(id);
        if (purchase.isActive()) {
            return purchase;
        }
        return null;
    }

    public List<Purchase> getActiveRecords() {
        List<Purchase> all = getAll();
        ArrayList<Purchase> list = new ArrayList<>();
        all.forEach((Purchase ele) -> {
            if (ele.isActive()) {
                list.add(ele);
            }
        });
        return list;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Purchase update(int id, int purchaseItemId, double quantity, double rate,
            Date date, boolean active, String description) {
        if (purchaseItemService.get(purchaseItemId) != null) {
            Optional<Purchase> optional = repository.findById(id);
            Purchase purchase = optional.get();
            if (purchase != null) {
                purchase.setPurchaseItemId(purchaseItemId);
                purchase.setQuantity(quantity);
                purchase.setRate(rate);
                purchase.setPrice(quantity * rate);
                purchase.setDate(date);
                purchase.setActive(active);
                purchase.setDescription(description);
                repository.save(purchase);
                return purchase;
            }
        }
        return null;
    }

    public ArrayList<Purchase> getRecords(Date fromDate, Date toDate) {
        ArrayList<Purchase> al = new ArrayList<>();
        List<Purchase> all = getActiveRecords();
        all.forEach((Purchase ele) -> {
            Date date = ele.getDate();
            if ((date.after(fromDate) || fromDate.equals(date))
                    && (date.before(toDate) || toDate.equals(date))) {
                al.add(ele);
            }
        });
        return al;
    }
}
