/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.sale.service;

import com.kpsolutionsindia.b2c.sale.model.Sale;
import com.kpsolutionsindia.b2c.sale.repository.SaleRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tushant
 */
@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    
    public SaleService() {
        System.out.println("Sale Service");
    }
    
    public Sale save(int productionId,double quantity,double price,int saleItemId,String billNumber,Date date,boolean active)
    {
        Sale sale = new Sale();
        sale.setProductionId(productionId);
        sale.setQuantity(quantity);
        sale.setPrice(price);
        sale.setSaleItemId(saleItemId);
        sale.setBillNumber(billNumber);
        sale.setDate(date);
        sale.setActive(active);
        repository.save(sale);
        return sale;
    }
    
    public List<Sale> getAll()
    {
        List<Sale> list = repository.findAll();
        return list;
    }
    
    public Sale getById(int id)
    {
        Optional<Sale> optional = repository.findById(id);
        Sale get = optional.get();
        return get;
    }
    
    public void delete(int id)
    {
        repository.deleteById(id);
    }
    
    public void update(int id,int productionId,double quantity,double price,int saleItemId,String billNumber,Date date,boolean active)
    {
        Optional<Sale> optional = repository.findById(id);
        Sale sale = optional.get();
        if(sale!=null)
        {
            sale.setProductionId(productionId);
            sale.setQuantity(quantity);
            sale.setPrice(price);
            sale.setSaleItemId(saleItemId);
            sale.setBillNumber(billNumber);
            sale.setDate(date);
            sale.setActive(active);
            repository.save(sale);
        }
    }
    
    public ArrayList<Sale> getRecords(Date fromDate, Date toDate)
    {
        ArrayList<Sale> list = new ArrayList<Sale>();
        List<Sale> all = getActiveRecords();
        all.forEach((Sale sale)->
        {
            Date date = sale.getDate();
            if ((date.after(fromDate) || fromDate.equals(date)) && (date.before(toDate) || toDate.equals(date)))
            {
                list.add(sale);
            }
        });
        return list;
    }
    
    public Sale getActiveRecord(int id) 
    {
        Sale sale = getById(id);
        if (sale.isActive()) {
            return sale;
        }
        return null;
    }
    
     public List<Sale> getActiveRecords()
     {
        List<Sale> arrayList = getAll();
        ArrayList<Sale> list = new ArrayList<>();
        arrayList.forEach((Sale sale) -> 
        {
            if (sale.isActive()){
                list.add(sale);
            }
        });
        return list;
    }
}
