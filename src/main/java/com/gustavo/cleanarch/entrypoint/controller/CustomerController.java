package com.gustavo.cleanarch.entrypoint.controller;


import com.gustavo.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.gustavo.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.gustavo.cleanarch.core.usecase.InsertCustomerUseCase;
import com.gustavo.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.gustavo.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.gustavo.cleanarch.entrypoint.controller.request.CustomerRequest;

import com.gustavo.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        var customerMapped = customerMapper.toCustomerMapper(customerRequest);
        insertCustomerUseCase.insert(customerMapped, customerRequest.getZipcode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {

        var customer =  findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable String id,
                                                   @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomerMapper(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipcode());
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerByIdUseCase.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
