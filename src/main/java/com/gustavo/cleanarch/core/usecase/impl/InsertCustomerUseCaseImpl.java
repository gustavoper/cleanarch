package com.gustavo.cleanarch.core.usecase.impl;

import com.gustavo.cleanarch.core.dataprovider.FindAdressByZipcode;
import com.gustavo.cleanarch.core.dataprovider.InsertCustomer;
import com.gustavo.cleanarch.core.domain.Customer;
import com.gustavo.cleanarch.core.usecase.InsertCustomerUseCase;
import org.springframework.stereotype.Component;


/**
 * O CORE NAO VAI CONHECER NADA DO MUNDO EXTERNO
 * Nao vamos usar nada na mao aqui (AUTOWIRED, ETC) pq a ideia e ficar livre de fw
 */

@Component
public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {


    //Poderiamos usar o autowired aqui
    private final FindAdressByZipcode findAdressByZipcode;

    //Poderiamos usar o autowired aqui
    private final InsertCustomer insertCustomer;

    public InsertCustomerUseCaseImpl(FindAdressByZipcode findAdressByZipcode, InsertCustomer insertCustomer) {
        this.findAdressByZipcode = findAdressByZipcode;
        this.insertCustomer = insertCustomer;

    }

    @Override
    public void insert(Customer customer, String zipcode) {
        //O endereco vira de outra api
        var address = findAdressByZipcode.find(zipcode);
        customer.setAddress(address);
        insertCustomer.insert(customer);


    }
}
