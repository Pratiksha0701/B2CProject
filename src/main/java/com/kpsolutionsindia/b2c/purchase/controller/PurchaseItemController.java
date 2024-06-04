/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.purchase.controller;

import com.kpsolutionsindia.b2c.purchase.model.PurchaseItem;
import com.kpsolutionsindia.b2c.purchase.service.PurchaseItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("purchaseitem")
public class PurchaseItemController {

    @Autowired
    private PurchaseItemService service;

    public PurchaseItemController() {
        System.out.println("I am in PurchaseItemController");
    }

    @RequestMapping("add/{name}/{description}/{unitId}")
    public PurchaseItem add(@PathVariable String name, @PathVariable String description, @PathVariable int unitId) {
        boolean active = true;
        PurchaseItem purchaseItem = service.add(name, description, unitId, active);
        return purchaseItem;
    }

    @RequestMapping("getall")
    public List<PurchaseItem> getAll() {
        List<PurchaseItem> list = service.getAll();
        return list;
    }

    @RequestMapping("get/{id}")
    public PurchaseItem get(@PathVariable int id) {
        PurchaseItem purchaseItem = service.get(id);
        return purchaseItem;
    }

    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping("update/{id}/{name}/{description}/{unitId}")
    public PurchaseItem update(@PathVariable int id, @PathVariable String name, @PathVariable String description, @PathVariable int unitId) {
        boolean active = true;
        PurchaseItem purchaseItem = service.update(id, name, description, unitId, active);
        return purchaseItem;
    }

}
