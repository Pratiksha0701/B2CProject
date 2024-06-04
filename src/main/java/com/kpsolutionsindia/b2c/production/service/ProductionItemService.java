/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.production.service;

import com.kpsolutionsindia.b2c.production.model.ProductionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kpsolutionsindia.b2c.production.repository.ProductionItemRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 91982
 */
@Service
public class ProductionItemService {

    @Autowired
    private ProductionItemRepository repository;
    
    public ProductionItemService() {
        System.out.println("I am in ProductionItemService");
    }
    
    public ProductionItem save(String name, int unitId, 
        String description, boolean active){
        ProductionItem pr = new ProductionItem();
        pr.setName(name);
        pr.setUnitId(unitId);
        pr.setDescription(description);
        pr.setActive(active);
        repository.save(pr);
        return pr;
    }
    public List<ProductionItem> get(){
        return repository.findAll();
    }
    public void delete(int id){
        repository.deleteById(id);
    }
    public void update(int id, String name, int unitId, String 
        description, boolean active){
        Optional<ProductionItem> optional= repository.findById(id);
        ProductionItem pr = optional.get();
        if (pr !=null){
            pr.setName(name);
            pr.setUnitId(unitId);
            pr.setDescription(description);
            pr.setActive(active);
            repository.save(pr);
        
    }
  }
}
