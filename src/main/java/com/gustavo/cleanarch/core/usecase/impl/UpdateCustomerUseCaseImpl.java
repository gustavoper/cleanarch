package com.gustavo.cleanarch.core.usecase.impl;

import com.gustavo.cleanarch.core.dataprovider.FindAddressByZipcode;
import com.gustavo.cleanarch.core.dataprovider.UpdateCustomer;
import com.gustavo.cleanarch.core.domain.Customer;
import com.gustavo.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.gustavo.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {


    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    private FindAddressByZipcode findAddressByZipcode;

    private UpdateCustomerUseCase updateCustomer;

    public  UpdateCustomerUseCaseImpl(FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
                                      FindAddressByZipcode findAddressByZipcode,
                                      UpdateCustomerUseCase updateCustomer
    ) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipcode = findAddressByZipcode;
        this.updateCustomer = updateCustomer;
    }


    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdUseCase.find(customer.getId());
        var address = findAddressByZipcode.find(zipCode);
        customer.setAddress(address);
        updateCustomer.update(customer, zipCode);
    }
}
