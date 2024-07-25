package com.gustavo.cleanarch.config;
import com.gustavo.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.gustavo.cleanarch.dataprovider.DeleteCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gustavo.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerImpl deleteCustomer
    ) {
        return new DeleteCustomerByIdUseCaseImpl(
                findCustomerByIdUseCase,
                deleteCustomer
        );
    }
}
