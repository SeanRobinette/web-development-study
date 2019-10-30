package com.seanrobinette.mvcrest.controllers;

import com.seanrobinette.mvcrest.api.v1.model.CustomerDTO;
import com.seanrobinette.mvcrest.api.v1.model.CustomerListDTO;
import com.seanrobinette.mvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping
    public ResponseEntity<CustomerListDTO> findAll() {
        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(customerService.getAll()),
                HttpStatus.OK);
    }

    @RequestMapping("{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<CustomerDTO>(customerService.getById(id), HttpStatus.OK);
    }
}
