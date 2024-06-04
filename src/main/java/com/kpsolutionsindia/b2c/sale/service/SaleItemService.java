/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.sale.service;

import com.kpsolutionsindia.b2c.sale.model.SaleItem;
import com.kpsolutionsindia.b2c.sale.repository.SaleItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tushant
 */
@Service
public class SaleItemService {

    @Autowired
    private SaleItemRepository repository;
    
    public SaleItemService() {
        System.out.println("Sale Item Service");
    }
    
    public SaleItem save(int productionId,double quantity,double rate,boolean active)
    {
        SaleItem item=new SaleItem();
        item.setProductionId(productionId);
        item.setQuantity(quantity);
        item.setRate(rate);
        item.setActive(active);
        repository.save(item);
        return item;
    }
    
    public List<SaleItem> getAll()
    {
        List<SaleItem> list = repository.findAll();
        return list;
    }
    
    public void delete(int id)
    {
        repository.deleteById(id);
    }
    
    public SaleItem getById(int id)
    {
        Optional<SaleItem> optional = repository.findById(id);
        if (optional.isPresent()) {
            SaleItem record = optional.get();
            return record;
        }
        return null;
    }
    
    public void update(int id,int productionId,double quantity,double rate,boolean active)
    {
        Optional<SaleItem> optional = repository.findById(id);
        SaleItem item = optional.get();
        if(item!=null)
        {
        item.setProductionId(productionId);
        item.setQuantity(quantity);
        item.setRate(rate);
        item.setActive(active);
        repository.save(item);
        }
    }       
}
