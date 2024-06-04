/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.service;

import com.kpsolutionsindia.b2c.admin.model.UserType;
import com.kpsolutionsindia.b2c.admin.repository.UserTypeRepository;
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
public class UserTypeService {

    @Autowired
    private UserTypeRepository repository;

    public UserTypeService() {
        System.out.println("I am in User Type Service");
    }

    public UserType add(String name, String description ) {
        boolean active=true;
        UserType ut = new UserType();
        ut.setName(name);
        ut.setDescription(description);
        ut.setActive(active);
        repository.save(ut);
        return ut;
    }

    public List<UserType> getAll() {
        return repository.findAll();
    }

    public UserType get(int id) {
        Optional<UserType> optional = repository.findById(id);
        if (optional.isPresent()) {
            UserType userType = optional.get();
            return userType;
        }
        return null;
    }
    
     public UserType getActiveRecord(int id) {
        UserType userType= get(id);
        if (userType!=null && userType.isActive()) {
            return userType;
        }
        return null;
    }

    public List<UserType> getActiveRecords(){
        List<UserType> all = getAll();
        ArrayList<UserType> list = new ArrayList<>();
        all.forEach((UserType ele) -> {
            if (ele.isActive()) {
                list.add(ele);
            }
        });
        return list;
    }
    

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void update(int id, String name, String description ) {
        boolean active=true;
        Optional<UserType> optional = repository.findById(id);
        UserType ut = optional.get();
        if (ut != null) {
            ut.setName(name);
            ut.setDescription(description);
            ut.setActive(active);
            repository.save(ut);
        }
    }

}
