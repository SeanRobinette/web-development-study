package com.seanrobinette.mvcrest.controllers;

import com.seanrobinette.mvcrest.api.v1.model.CustomerDTO;
import com.seanrobinette.mvcrest.api.v1.model.CustomerListDTO;
import com.seanrobinette.mvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(CustomerController.API_ROOT)
public class CustomerController {
    public static final String API_ROOT = "/api/v1/customers/";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> findAll() {
        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(customerService.getAll()),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(
                customerService.createNewCustomer(customerDTO),
                HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(
                customerService.updateCustomer(id, customerDTO),
                HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(
                customerService.patchCustomer(id, customerDTO),
                HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleleCustomerById(id);
        return new ResponseEntity<Void>(
                HttpStatus.OK);
    }

}
