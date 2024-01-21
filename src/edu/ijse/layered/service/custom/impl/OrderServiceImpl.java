/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.dao.custom.OrderDao;
import edu.ijse.layered.dao.custom.OrderDetailDao;
import edu.ijse.layered.db.DBConnection;
import edu.ijse.layered.dto.OrderDetailDto;
import edu.ijse.layered.dto.OrderDto;
import edu.ijse.layered.entity.ItemEntity;
import edu.ijse.layered.entity.OrderDetailEntity;
import edu.ijse.layered.entity.OrderEntity;
import edu.ijse.layered.service.custom.OrderService;
import java.sql.Connection;

/**
 *
 * @author anjanathrishakya
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public String placeOrder(OrderDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            
            OrderEntity orderEntity = new OrderEntity(dto.getId(), 
                    dto.getDate(), dto.getCustId());
            if(orderDao.save(orderEntity)){
                
                boolean isSavedOrderDetail = true;
                for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {
                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity(dto.getId(),
                            orderDetailDto.getItemId(), orderDetailDto.getQty(), orderDetailDto.getDiscount());
                    
                    if(!orderDetailDao.save(orderDetailEntity)){
                        isSavedOrderDetail = false;
                    }
                }
                if(isSavedOrderDetail){
                    boolean isItemUpdated = true;
                    
                    for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {
                        ItemEntity itemEntity = itemDao.get(orderDetailDto.getItemId());
                        itemEntity.setQoh(itemEntity.getQoh() - orderDetailDto.getQty());
                        if(!itemDao.update(itemEntity)){
                            isItemUpdated = false;
                        }
                    }
                    
                    if(isItemUpdated){
                        connection.commit();
                        return "Successfully Saved";
                    } else {
                        connection.rollback();
                    return "Error in item update";
                    }
                    
                } else{
                    connection.rollback();
                    return "Error in order detail save";
                }
                
            } else {
                connection.rollback();
                return "Error in order save";
            }
            
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
