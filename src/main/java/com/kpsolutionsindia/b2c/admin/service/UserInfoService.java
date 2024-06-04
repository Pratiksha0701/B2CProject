/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.service;

import com.kpsolutionsindia.b2c.admin.model.UserInfo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kpsolutionsindia.b2c.admin.repository.UserInfoRepository;
import java.util.ArrayList;

/**
 *
 * @author deolapar
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private BranchService branchService;

    @Autowired
    private UserTypeService userTypeService;

    public UserInfoService() {
        System.out.println("I am in User Service");
    }

    public UserInfo add(int branchId, int userTypeId, String fullname, String username,
            String password) {
        boolean active = true;
        if (branchService.getActiveRecord(branchId) != null && userTypeService.getActiveRecord(userTypeId) != null) {
            if (getUser(username) == null) {
                UserInfo u = new UserInfo();
                u.setBranchId(branchId);
                u.setUserTypeId(userTypeId);
                u.setFullname(fullname);
                u.setUsername(username);
                u.setPassword(password);
                u.setActive(active);
                repository.save(u);
                return u;
            }
        }
        return null;
    }

    public List<UserInfo> getAll() {
        return repository.findAll();
    }

    public UserInfo get(int id) {
        Optional<UserInfo> optional = repository.findById(id);
        UserInfo get = optional.get();
        return get;
    }

    public UserInfo getActiveRecord(int id) {
        UserInfo userInfo = get(id);
        if (userInfo.isActive()) {
            return userInfo;
        }
        return null;
    }

    public List<UserInfo> getActiveRecords() {
        List<UserInfo> all = getAll();
        ArrayList<UserInfo> list = new ArrayList<>();
        all.forEach((UserInfo ele) -> {
            if (ele.isActive()) {
                list.add(ele);
            }
        });
        return list;
    }

    public UserInfo getUser(String username) {
        List<UserInfo> userList = getActiveRecords();
        for (UserInfo userInfo : userList) {
            if (userInfo.getUsername().equals(username)) {
                return userInfo;
            }
        }
        return null;
    }
    public UserInfo getUser(String username , String password) {
        List<UserInfo> userList = getActiveRecords();
        for (UserInfo userInfo : userList) {
            if (userInfo.getUsername().equals(username) && userInfo.getPassword().equals(password) ) {
                return userInfo;
            }
        }
        return null;
    }
    

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void update(int id, int branchId, int userTypeId, String fullname,
            String username, String password) {
        boolean active = true;
        Optional<UserInfo> optional = repository.findById(id);
        UserInfo u = optional.get();
        if (u != null) {
            u.setBranchId(branchId);
            u.setUserTypeId(userTypeId);
            u.setFullname(fullname);
            u.setUsername(username);
            u.setPassword(password);
            u.setActive(active);
            repository.save(u);
        }
    }

    public UserInfo login(String username, String password) {
        List<UserInfo> userList = getActiveRecords();
        for (UserInfo userInfo : userList) {
            if (userInfo.getUsername().equals(username)
                    && userInfo.getPassword().equals(password)) {
                userInfo.setPassword("");
                return userInfo;
            }
        }
        return null;
    }

}
