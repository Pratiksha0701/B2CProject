/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.purchase.controller;

import com.kpsolutionsindia.b2c.purchase.model.Unit;
import com.kpsolutionsindia.b2c.purchase.service.UnitService;
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
@RequestMapping("unit")
public class UnitController {

    @Autowired
    private UnitService service;

    public UnitController() {
        System.out.println("I am in UnitController");
    }

    @RequestMapping("add/{name}/{description}")
    public Unit add(@PathVariable String name, @PathVariable String description) {
        boolean active = true;
        Unit unit = service.add(name, description, active);
        return unit;
    }

    @RequestMapping("getall")
    public List<Unit> getAll() {
        List<Unit> list = service.getAll();
        return list;
    }

    @RequestMapping("get/{id}")
    public Unit get(@PathVariable int id) {
        Unit unit = service.get(id);
        return unit;
    }

    @RequestMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping("update/{id}/{name}/{description}")
    public Unit update(@PathVariable int id, @PathVariable String name,
            @PathVariable String description) {
        boolean active = true;
        Unit unit = service.update(id, name, description, active);
        return unit;
    }

}
