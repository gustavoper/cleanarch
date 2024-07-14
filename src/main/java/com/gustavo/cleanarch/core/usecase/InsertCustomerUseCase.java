package com.gustavo.cleanarch.core.usecase;

import com.gustavo.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, String zipcode);
}
