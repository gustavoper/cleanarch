package com.gustavo.cleanarch.entrypoint.controller.mapper;


import com.gustavo.cleanarch.core.domain.Customer;
import com.gustavo.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.gustavo.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomerMapper(CustomerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);
}
