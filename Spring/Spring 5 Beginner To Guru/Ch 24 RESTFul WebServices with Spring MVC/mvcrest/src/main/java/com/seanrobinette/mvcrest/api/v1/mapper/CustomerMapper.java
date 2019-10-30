package com.seanrobinette.mvcrest.api.v1.mapper;

import com.seanrobinette.mvcrest.api.v1.model.CustomerDTO;
import com.seanrobinette.mvcrest.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "customerUrl", source = "")
    })
    CustomerDTO customerToCustomerDTO(Customer customer);
}
