package com.gustavo.cleanarch.entrypoint.controller;


import com.gustavo.cleanarch.core.usecase.InsertCustomerUseCase;
import com.gustavo.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.gustavo.cleanarch.entrypoint.controller.request.CustomerRequest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;
 
    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        var customerMapped = customerMapper.toCustomerMapper(customerRequest);
        insertCustomerUseCase.insert(customerMapped, customerRequest.getZipcode());
        return ResponseEntity.ok().build();
    }
}
