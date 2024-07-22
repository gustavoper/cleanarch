package com.gustavo.cleanarch.core.dataprovider;

import com.gustavo.cleanarch.core.domain.Customer;
import com.gustavo.cleanarch.dataprovider.repository.CustomerRepository;
import com.gustavo.cleanarch.dataprovider.repository.entity.CustomerEntity;
import com.gustavo.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
