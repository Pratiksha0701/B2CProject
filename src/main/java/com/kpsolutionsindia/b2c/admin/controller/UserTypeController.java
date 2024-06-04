/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.controller;

import com.kpsolutionsindia.b2c.admin.model.UserType;
import com.kpsolutionsindia.b2c.admin.service.UserTypeService;
import com.kpsolutionsindia.b2c.purchase.model.PurchaseItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deolapar
 */
@RestController
@RequestMapping("usertype")
public class UserTypeController {
    
    @Autowired
    private UserTypeService service;

    public UserTypeController() {
        System.out.println("I am in user type controller");
    }
    
    @RequestMapping("add/{name}/{description}")
    public UserType save(@PathVariable String name,@PathVariable String description)
    {
        UserType ut=service.add(name, description);
        return ut;
    }       
    
    @RequestMapping("getall")
    public List<UserType> getAll()
    {
        List<UserType> list=service.getAll();
        return list;
    }
    
    @RequestMapping("get/{id}")
    public UserType get(@PathVariable int id)
    {
         UserType ut=service.get(id);
         return ut;
    }
    
   
    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }
    
    @RequestMapping("update/{id}/{name}/{description}")
    public void update(@PathVariable int id, @PathVariable String name,
            @PathVariable String description )
    {
        service.update(id, name, description);
    }
    
    
    
    
}
