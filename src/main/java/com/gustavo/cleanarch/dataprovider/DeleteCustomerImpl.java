package com.gustavo.cleanarch.dataprovider;

import com.gustavo.cleanarch.core.dataprovider.DeleteCustomer;
import com.gustavo.cleanarch.dataprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerImpl implements DeleteCustomer {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }
}
