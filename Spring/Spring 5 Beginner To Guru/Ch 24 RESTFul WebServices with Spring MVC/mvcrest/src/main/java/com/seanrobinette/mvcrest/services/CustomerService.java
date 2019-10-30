package com.seanrobinette.mvcrest.services;

import com.seanrobinette.mvcrest.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAll();
    CustomerDTO getById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
}
