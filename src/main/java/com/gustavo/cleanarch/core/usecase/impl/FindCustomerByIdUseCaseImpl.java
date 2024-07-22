package com.gustavo.cleanarch.core.usecase.impl;

import com.gustavo.cleanarch.core.dataprovider.FindCustomerById;
import com.gustavo.cleanarch.core.domain.Customer;
import com.gustavo.cleanarch.core.usecase.FindCustomerByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {


    //Poderiamos usar o autowired aqui
    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
        this.findCustomerById = findCustomerById;
    }


    @Override
    public Customer find(String Id) {
        return findCustomerById.find(Id).orElseThrow(
                ()-> new RuntimeException("Customer not found")
        );
    }
}
