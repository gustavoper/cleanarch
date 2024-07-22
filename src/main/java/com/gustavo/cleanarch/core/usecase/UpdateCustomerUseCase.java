package com.gustavo.cleanarch.core.usecase;

import com.gustavo.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {
    void update(Customer customer, String zipCode);
}
