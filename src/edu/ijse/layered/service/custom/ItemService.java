/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.service.SuperService;
import java.util.List;

/**
 *
 * @author anjanathrishakya
 */
public interface ItemService extends SuperService{
    String saveItem(ItemDto itemDto) throws Exception;
    String updateItem(ItemDto itemDto) throws Exception;
    String deleteItem(String id) throws Exception;
    ItemDto getItem(String id) throws Exception;
    List<ItemDto> getAll() throws Exception;
}
