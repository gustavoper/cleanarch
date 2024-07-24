package com.gustavo.cleanarch.core.usecase.impl;

import com.gustavo.cleanarch.core.dataprovider.DeleteCustomer;
import com.gustavo.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.gustavo.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {


    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final DeleteCustomer deleteCustomer;

    public DeleteCustomerByIdUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase, DeleteCustomer deleteCustomer) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.deleteCustomer = deleteCustomer;
    }


    @Override
    public void deleteById(String id) {
        findCustomerByIdUseCase.find(id);
        deleteCustomer.deleteById(id);
    }
}