package com.gustavo.cleanarch.core.dataprovider.client.mapper;

import com.gustavo.cleanarch.core.dataprovider.client.response.AddressResponse;
import com.gustavo.cleanarch.core.domain.Address;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
public class AddressResponseMapper {

    public Address toAddress(AddressResponse addressResponse) {
        return new Address(
                addressResponse.getStreet(),
                addressResponse.getCity(),
                addressResponse.getState()
        );
    }
}
