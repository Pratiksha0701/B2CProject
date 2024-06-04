/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.purchase.service;

import com.kpsolutionsindia.b2c.purchase.model.PurchaseItem;
import com.kpsolutionsindia.b2c.purchase.repository.PurchaseItemRepository;
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
public class PurchaseItemService {

    @Autowired
    private PurchaseItemRepository repository;

    @Autowired
    private UnitService unitService;

    public PurchaseItemService() {
        System.out.println("I am in PurchaseItemService");
    }

    public PurchaseItem add(String name, String description, int unitId, boolean active) {
        if (unitService.get(unitId) != null) {
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setName(name);
            purchaseItem.setDescription(description);
            purchaseItem.setUnitId(unitId);
            purchaseItem.setActive(active);
            repository.save(purchaseItem);
            return purchaseItem;
        } else {
            return null;
        }
    }

    public List<PurchaseItem> getAll() {
        return repository.findAll();
    }

    public PurchaseItem get(int id) {
        Optional<PurchaseItem> optional = repository.findById(id);
        if (optional.isPresent()) {
            PurchaseItem purchaseItem = optional.get();
            return purchaseItem;
        }
        return null;
    }

    public PurchaseItem getActiveRecord(int id) {
        PurchaseItem purchaseItem = get(id);
        if (purchaseItem.isActive()) {
            return purchaseItem;
        }
        return null;
    }

    public List<PurchaseItem> getActiveRecords() {
        List<PurchaseItem> all = getAll();
        ArrayList<PurchaseItem> list = new ArrayList<>();
        all.forEach((PurchaseItem ele) -> {
            if (ele.isActive()) {
                list.add(ele);
            }
        });
        return list;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public PurchaseItem update(int id, String name, String description, int unitId, boolean active) {
        Optional<PurchaseItem> optinal = repository.findById(id);
        if (unitService.get(unitId) != null) {
            PurchaseItem purchaseItem = optinal.get();
            if (purchaseItem != null) {
                purchaseItem.setName(name);
                purchaseItem.setDescription(description);
                purchaseItem.setUnitId(unitId);
                purchaseItem.setActive(active);
                repository.save(purchaseItem);
            }
            return purchaseItem;
        }
        return null;
    }

}
