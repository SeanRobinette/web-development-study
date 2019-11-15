package com.seanrobinette.mvcrest.services;

import com.seanrobinette.mvcrest.api.v1.mapper.CustomerMapper;
import com.seanrobinette.mvcrest.api.v1.model.CustomerDTO;
import com.seanrobinette.mvcrest.controllers.CustomerController;
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
            customerDTO.setCustomerUrl(CustomerController.API_ROOT + customer.getId());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent())
            throw new ResourceNotFoundException();
        return customerMapper.customerToCustomerDTO(customer.get());
    }

    private CustomerDTO saveCustomerAndReturnDto(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnDto.setCustomerUrl(CustomerController.API_ROOT + savedCustomer.getId());
        return returnDto;
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        return saveCustomerAndReturnDto(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);
        return saveCustomerAndReturnDto(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if(customerDTO.getFirstName() != null) {
                customer.setFirstName(customerDTO.getFirstName());
            }

            if(customerDTO.getLastName() != null) {
                customer.setLastName(customerDTO.getLastName());
            }

            customer = customerRepository.save(customer);

            CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customer);
            returnDto.setCustomerUrl(CustomerController.API_ROOT + id);
            return returnDto;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        if(!customerRepository.findById(id).isPresent())
            throw new ResourceNotFoundException();
        customerRepository.deleteById(id);
    }
}
