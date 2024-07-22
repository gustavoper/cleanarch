package com.gustavo.cleanarch.core.dataprovider;

import com.gustavo.cleanarch.core.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface FindCustomerById {

    Optional<Customer> find(final String id);
}
