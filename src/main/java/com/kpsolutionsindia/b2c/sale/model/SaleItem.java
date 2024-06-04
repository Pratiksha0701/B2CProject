/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.sale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tushant
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SaleItem {

    @Id
    @GeneratedValue
    private int id;
    private int productionId;
    private double quantity;
    private double rate;
    private boolean active;
}
