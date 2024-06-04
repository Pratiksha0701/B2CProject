/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.sale.controller;

import com.kpsolutionsindia.b2c.sale.model.Sale;
import com.kpsolutionsindia.b2c.sale.service.SaleService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tushant
 */
@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleService service;
    
    public SaleController() {
        System.out.println("Sale Controller");
    }
    
    @RequestMapping("save/{productionId}/{quantity}/{price}/{saleItemId}/{billNumber}/{date}")
    public Sale save(@PathVariable int productionId,@PathVariable double quantity,@PathVariable double price,@PathVariable int saleItemId,@PathVariable String billNumber,@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date)
    {
        boolean active=true;
        return service.save(productionId, quantity, price, saleItemId, billNumber, date, active);
    }
    
    @RequestMapping("getall")
    public List<Sale> getAll()
    {
        return service.getAll();
    }
    
    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }
    
    @RequestMapping("update/{id}/{productionId}/{quantity}/{price}/{saleItemId}/{billNumber}/{date}")
    public void update(@PathVariable int id,@PathVariable int productionId,@PathVariable double quantity,@PathVariable double price,@PathVariable int saleItemId,@PathVariable String billNumber,@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date)
    {
        boolean active=true;
        service.update(id, productionId, quantity, price, saleItemId, billNumber, date, active);
    }
    
}
