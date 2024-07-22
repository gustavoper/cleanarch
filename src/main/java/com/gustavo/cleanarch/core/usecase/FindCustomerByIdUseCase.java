package com.gustavo.cleanarch.core.usecase;


import com.gustavo.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer find(final String Id);
}
