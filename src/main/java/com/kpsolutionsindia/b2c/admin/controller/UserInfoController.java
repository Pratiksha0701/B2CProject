/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.controller;

import com.kpsolutionsindia.b2c.admin.model.UserInfo;
import com.kpsolutionsindia.b2c.admin.service.UserInfoService;
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
@RequestMapping("user")
public class UserInfoController {
    
    @Autowired
    private UserInfoService service;

    public UserInfoController() {
        System.out.println("I am in User Controller");
    }
    
    @RequestMapping("add/{branchId}/{userTypeId}/{fullname}/{username}/{password}")
    public UserInfo save(@PathVariable int branchId, @PathVariable int userTypeId,
            @PathVariable String fullname, @PathVariable String username, 
            @PathVariable String password)
    {
        
        UserInfo u=service.add(branchId, userTypeId, fullname, username, password);
        return u;
               
    }
    
    @RequestMapping("getall")
    public List<UserInfo> getAll()
    {
        List<UserInfo> list=service.getAll();
        return list;
    }
    
    @RequestMapping("get/{id}")
    public UserInfo get(@PathVariable int id)
    {
        UserInfo u=service.get(id);
        u.getBranchId();
        u.getUserTypeId();
        u.getFullname();
        u.getUsername();
        return u;
    }
    @RequestMapping("login/{username}/{password}")
    public UserInfo login(@PathVariable String username, @PathVariable String password)
    {
        return service.login(username, password);
    }
    
    
    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }
    
    @RequestMapping("update/{id}/{branchId}/{userTypeId}/{fullname}/{username}/{password}")
    public void update(@PathVariable int id, @PathVariable int branchId,@PathVariable int userTypeId,
            @PathVariable String fullname, @PathVariable String username, @PathVariable String password)
    {
        service.update(id, branchId, userTypeId, fullname, username, password);
    }
        
    }


