/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.CustomerDao;
import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.entity.CustomerEntity;
import edu.ijse.layered.service.custom.CustomerService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anjanathrishakya
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public String addCustomer(CustomerDto dto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                dto.getCustId(), dto.getTitle(),
                dto.getName(), dto.getDob(),
                dto.getSalary(), dto.getAddress(), dto.getCity(), dto.getProvince(),
                dto.getZip());

        if (customerDao.save(customerEntity)) {
            return "Successfully Saved";
        } else {
            return "Fail";
        }

    }

    @Override
    public String updateCustomer(CustomerDto dto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                dto.getCustId(), dto.getTitle(),
                dto.getName(), dto.getDob(),
                dto.getSalary(), dto.getAddress(), dto.getCity(), dto.getProvince(),
                dto.getZip());

        if (customerDao.update(customerEntity)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteCustomer(String id) throws Exception {
        if (customerDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
        CustomerEntity entity = customerDao.get(id);
        if (entity != null) {
            return new CustomerDto(entity.getCustId(),
                    entity.getTitle(), entity.getName(), entity.getDob(),
                    entity.getSalary(), entity.getAddress(), entity.getCity(),
                    entity.getProvince(), entity.getZip());
        }
        return null;
    }

    @Override
    public List<CustomerDto> getAll() throws Exception {
        List<CustomerDto> customerDtos = new ArrayList<>();
        List<CustomerEntity> customerEntities = customerDao.getAll();
        for (CustomerEntity entity : customerEntities) {
            customerDtos.add(new CustomerDto(entity.getCustId(),
                    entity.getTitle(), entity.getName(), entity.getDob(),
                    entity.getSalary(), entity.getAddress(), entity.getCity(),
                    entity.getProvince(), entity.getZip()));
        }
        return customerDtos;
    }

}
