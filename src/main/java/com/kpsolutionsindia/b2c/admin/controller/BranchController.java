/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.controller;
import com.kpsolutionsindia.b2c.admin.model.Branch;
import com.kpsolutionsindia.b2c.admin.service.BranchService;
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
@RequestMapping("branch")
public class BranchController {
    
    @Autowired 
    private BranchService service;
    
     @RequestMapping("add/{name}/{location}/{description}")
    public Branch add(@PathVariable String name, @PathVariable String location, @PathVariable String description) {
       boolean active=true;
        Branch branchmanager = service.add(name, location, description, active);
        return branchmanager;
    }
    
    @RequestMapping("getall")
    public List<Branch> getAll() {
        List<Branch> list = service.getAll();
        return list;
    }
    
     @RequestMapping("get/{id}")
    public Branch get(@PathVariable int id) {
        Branch get = service.get(id);
        return get;
    }
    
    
    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
    
    @RequestMapping("update/{id}/{name}/{location}/{description}")
    public void update(@PathVariable int id, @PathVariable String name, @PathVariable String location, @PathVariable String description) {
        boolean active=true;
        service.update(id, name, location, description, active);
    }

    
}
