/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.controller;

import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.service.ServiceFactory;
import edu.ijse.layered.service.custom.ItemService;
import java.util.List;

/**
 *
 * @author anjanathrishakya
 */
public class ItemController {
    
    private ItemService itemService = (ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
    
    public String saveItem(ItemDto itemDto) throws Exception{
        return itemService.saveItem(itemDto);
    }
    
    public ItemDto get(String id) throws Exception{
        return itemService.getItem(id);
    }
    
    public List<ItemDto> getAll() throws Exception{
        return itemService.getAll();
    }
}
