/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.service;

import com.kpsolutionsindia.b2c.admin.model.Branch;
import com.kpsolutionsindia.b2c.admin.repository.BranchRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deolapar
 */
@Service
public class BranchService {

    @Autowired
    private BranchRepository repository;

    public BranchService() {
        System.out.println("I am in Branch Service");
    }

    public Branch add(String name, String location, String description, boolean active) {
        Branch bm = new Branch();
        bm.setName(name);
        bm.setLocation(location);
        bm.setDescription(description);
        bm.setActive(active);
        repository.save(bm);
        return bm;
    }

    public List<Branch> getAll() {
        return repository.findAll();
    }

    public Branch get(int id) {
        Optional<Branch> optional = repository.findById(id);
        if (optional.isPresent()) {
            Branch branch = optional.get();
            return branch;
        }
        return null;
    }

    public Branch getActiveRecord(int id) {
        Branch branch = get(id);
        if (branch!=null && branch.isActive()) {
            return branch;
        }
        return null;
    }

    public List<Branch> getActiveRecords() {
        List<Branch> all = getAll();
        ArrayList<Branch> list = new ArrayList<>();
        all.forEach((Branch ele) -> {
            if (ele.isActive()) {
                list.add(ele);
            }
        });
        return list;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void update(int id, String name, String location, String description, boolean active) {
        Optional<Branch> optional = repository.findById(id);
        Branch bm = optional.get();
        if (bm != null) {
            bm.setName(name);
            bm.setLocation(location);
            bm.setDescription(description);
            bm.setActive(active);
            repository.save(bm);
        }
    }

}
