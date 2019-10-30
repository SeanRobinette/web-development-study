package com.seanrobinette.mvcrest.services;

import com.seanrobinette.mvcrest.api.v1.mapper.CustomerMapper;
import com.seanrobinette.mvcrest.api.v1.model.CustomerDTO;
import com.seanrobinette.mvcrest.domain.Customer;
import com.seanrobinette.mvcrest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer customer : customerRepository.findAll()) {
            CustomerDTO customerDTO = customerMapper.customerToCustomerDTO((customer));
            customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent())
            return null;
        return customerMapper.customerToCustomerDTO(customer.get());
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnDto.setCustomerUrl("/api/v1/customers/" + savedCustomer.getId());
        return returnDto;
    }
}
