package com.gustavo.cleanarch.dataprovider.repository.mapper;


import com.gustavo.cleanarch.core.domain.Customer;
import com.gustavo.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
