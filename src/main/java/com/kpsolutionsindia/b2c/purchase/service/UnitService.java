/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.purchase.service;

import com.kpsolutionsindia.b2c.purchase.model.Unit;
import com.kpsolutionsindia.b2c.purchase.repository.UnitRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class UnitService {

    @Autowired
    private UnitRepository repository;

    public UnitService() {
        System.out.println("I am in UnitService");
    }

    public Unit add(String name, String description, boolean active) {
        Unit unit = new Unit();
        unit.setName(name);
        unit.setDescription(description);
        unit.setActive(active);
        repository.save(unit);
        return unit;
    }

    public List<Unit> getAll() {
        return repository.findAll();
    }

    public Unit get(int id) {
        Optional<Unit> optional = repository.findById(id);
        if (optional.isPresent()) {
            Unit unit = optional.get();
            return unit;
        }
        return null;
    }

    public Unit getActiveRecord(int id) {
        Unit unit = get(id);
        if (unit.isActive()) {
            return unit;
        }
        return null;
    }

    public List<Unit> getActiveRecords() {
        List<Unit> all = getAll();
        ArrayList<Unit> list = new ArrayList<>();
        all.forEach((Unit ele) -> {
            if (ele.isActive()) {
                list.add(ele);
            }
        });
        return list;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Unit update(int id, String name, String description, boolean active) {
        Optional<Unit> optional = repository.findById(id);
        Unit unit = optional.get();
        if (unit != null) {
            unit.setName(name);
            unit.setDescription(description);
            unit.setActive(active);
            repository.save(unit);
        }
        return unit;
    }
}
