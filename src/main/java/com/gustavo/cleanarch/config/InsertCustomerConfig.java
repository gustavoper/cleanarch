package com.gustavo.cleanarch.config;


import com.gustavo.cleanarch.core.dataprovider.FindAddressByZipcode;
import com.gustavo.cleanarch.core.dataprovider.FindAddressByZipcodeImpl;
import com.gustavo.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.gustavo.cleanarch.dataprovider.InsertCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            FindAddressByZipcodeImpl findAddressByZipcode,
            InsertCustomerImpl insertCustomer
    ) {
        return new InsertCustomerUseCaseImpl(findAddressByZipcode, insertCustomer);
    }
}
