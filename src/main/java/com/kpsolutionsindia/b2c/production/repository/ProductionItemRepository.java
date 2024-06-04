/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.production.repository;

import com.kpsolutionsindia.b2c.production.model.ProductionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 91982
 */
@Repository
public interface ProductionItemRepository extends JpaRepository<ProductionItem, Integer>{
}




  
 
    

