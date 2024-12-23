package com.gustavo.cleanarch.entrypoint.consumer;


import com.gustavo.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.gustavo.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.gustavo.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {


    @Autowired
    UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "gustavo")
    public void receive(CustomerMessage message) {

        var customer = customerMessageMapper.toCustomer(message);
        updateCustomerUseCase.update(customer, message.getZipCode());
    }
}
