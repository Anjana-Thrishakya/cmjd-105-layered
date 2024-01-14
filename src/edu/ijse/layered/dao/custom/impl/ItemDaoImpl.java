/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.CrudUtil;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.entity.ItemEntity;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author anjanathrishakya
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean save(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES(?,?,?,?,?)", 
                t.getItemCode(),
                t.getDescription(),
                t.getPackSize(),
                t.getUnitPrice(),
                t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        return null;
    }

    @Override
    public List<ItemEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
        List<ItemEntity> itemEntities = new ArrayList<>();
        
        while (rst.next()) {            
            itemEntities.add(new ItemEntity(rst.getString("ItemCode"), 
                    rst.getString("Description"), 
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand")));
        }
        return itemEntities;
    }

}
