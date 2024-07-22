package com.gustavo.cleanarch.dataprovider;


import com.gustavo.cleanarch.core.dataprovider.FindCustomerById;
import com.gustavo.cleanarch.core.domain.Customer;
import com.gustavo.cleanarch.dataprovider.repository.CustomerRepository;
import com.gustavo.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl  implements FindCustomerById {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        //vamos criar um mapper pra transformar
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
