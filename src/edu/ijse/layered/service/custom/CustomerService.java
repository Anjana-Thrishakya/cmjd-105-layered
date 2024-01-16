/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.CustomerDto;
import java.util.List;

/**
 *
 * @author anjanathrishakya
 */
public interface CustomerService {

    String addCustomer(CustomerDto dto) throws Exception;

    String updateCustomer(CustomerDto dto) throws Exception;

    String deleteCustomer(String id) throws Exception;
    
    CustomerDto getCustomer(String id) throws Exception;
    
    List<CustomerDto> getAll() throws Exception;
}
