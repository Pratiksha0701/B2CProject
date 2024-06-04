/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.sale.controller;

import com.kpsolutionsindia.b2c.sale.model.SaleItem;
import com.kpsolutionsindia.b2c.sale.service.SaleItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tushant
 */
@RestController
@RequestMapping("saleitem")
public class SaleItemController {

    @Autowired
    private SaleItemService service;
    
    public SaleItemController() {
        System.out.println("Sale Item Controller");
    }
    
    @RequestMapping("save/{productionId}/{quantity}/{rate}")
    public SaleItem save(@PathVariable int productionId,@PathVariable double quantity,@PathVariable double rate)
    {
        boolean active=true;
        return service.save(productionId, quantity, rate, active);
    }
    
    @RequestMapping("getall")
    public List<SaleItem> getAll()
    {
        return service.getAll();
    }
    
    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }
    
    @RequestMapping("get/{id}")
    public SaleItem getById(@PathVariable int id)
    {
        return service.getById(id);
    }
    
    @RequestMapping("update/{id}/{productionId}/{quantity}/{rate}")
    public void update(@PathVariable int id,@PathVariable int productionId,@PathVariable double quantity,@PathVariable double rate)
    {
        boolean active=true;
        service.update(id, productionId, quantity, rate, active);
    }
}
