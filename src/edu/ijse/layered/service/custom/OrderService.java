/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.OrderDto;
import edu.ijse.layered.service.SuperService;

/**
 *
 * @author anjanathrishakya
 */
public interface OrderService extends SuperService{
    String placeOrder(OrderDto dto) throws Exception;
}
