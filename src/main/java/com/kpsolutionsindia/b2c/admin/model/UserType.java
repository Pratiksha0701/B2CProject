/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author deolapar
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserType {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private boolean active;
    
}
