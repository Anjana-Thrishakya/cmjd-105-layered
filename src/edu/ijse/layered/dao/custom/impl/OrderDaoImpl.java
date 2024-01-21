/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.OrderDao;
import edu.ijse.layered.entity.OrderEntity;
import java.util.List;

/**
 *
 * @author anjanathrishakya
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean save(OrderEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public OrderEntity get(String id) throws Exception {
        return null;
    }

    @Override
    public List<OrderEntity> getAll() throws Exception {
        return null;
    }

}
