/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.production.controller;

import com.kpsolutionsindia.b2c.production.model.ProductionItem;
import com.kpsolutionsindia.b2c.production.service.ProductionItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 91982
 */
@RestController
@RequestMapping("productionitem")
public class ProductionItemController {

    @Autowired
    private ProductionItemService service;
    
    public ProductionItemController() {
        System.out.println("I am in ProductionItemController");
    }
    
    @RequestMapping("save/{name}/{unitId}/{description}")
    public ProductionItem add(@PathVariable String name,@PathVariable double price,
            @PathVariable int unitId, @PathVariable String description){
        boolean active=true;
    ProductionItem productionItem = service.save(name, unitId, description,
            active);
    return productionItem;
    }
    
    @RequestMapping("get")
    public List<ProductionItem> get(){
        List<ProductionItem> list= service.get();
        return list;
    }
    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id){
       service.delete(id);
    }
    @RequestMapping("update/{id}/{name}/{unitId}/{description}")
    public void update(@PathVariable int id, @PathVariable String name,@PathVariable int unitId, @PathVariable String description){
        boolean active=true;
       service.update(id, name, unitId, description, active);
    
   }
            
}
