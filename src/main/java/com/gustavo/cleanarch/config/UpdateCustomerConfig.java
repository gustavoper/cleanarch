package com.gustavo.cleanarch.config;



import com.gustavo.cleanarch.core.dataprovider.FindAddressByZipcodeImpl;
import com.gustavo.cleanarch.core.dataprovider.UpdateCustomerImpl;
import com.gustavo.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.gustavo.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            FindAddressByZipcodeImpl findAddressByZipCode,
            UpdateCustomerImpl updateCustomer

    ) {
        return new UpdateCustomerUseCaseImpl(
                findCustomerByIdUseCase,
                findAddressByZipCode,
                updateCustomer);
    }

}

