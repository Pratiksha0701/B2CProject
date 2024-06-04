/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.repository;

import com.kpsolutionsindia.b2c.admin.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author developer
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{
    
}
