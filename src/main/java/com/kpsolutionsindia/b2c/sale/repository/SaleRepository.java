/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.sale.repository;

import com.kpsolutionsindia.b2c.sale.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tushant
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{
    
}
