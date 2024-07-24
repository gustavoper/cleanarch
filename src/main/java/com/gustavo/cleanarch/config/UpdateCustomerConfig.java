package com.gustavo.cleanarch.config;


import com.gustavo.cleanarch.core.dataprovider.FindAddressByZipcodeImpl;

import com.gustavo.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.gustavo.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.gustavo.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {


    private FindCustomerByIdUseCaseImpl findCustomerByIdUseCase;
    private FindAddressByZipcodeImpl findAddressByZipcode;
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            FindAddressByZipcodeImpl findAddressByZipcode,
            UpdateCustomerUseCase updateCustomerUseCase
    ) {
        return new UpdateCustomerUseCaseImpl(
                findCustomerByIdUseCase,
                findAddressByZipcode,
                updateCustomerUseCase
        );
    }
}
