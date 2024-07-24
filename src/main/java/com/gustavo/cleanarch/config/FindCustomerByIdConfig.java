package com.gustavo.cleanarch.config;

import com.gustavo.cleanarch.core.dataprovider.FindCustomerById;
import com.gustavo.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.gustavo.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {


    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerByIdImpl findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerById);
    }
}
