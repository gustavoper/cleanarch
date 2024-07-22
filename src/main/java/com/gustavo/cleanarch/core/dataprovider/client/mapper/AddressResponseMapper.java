package com.gustavo.cleanarch.core.dataprovider.client.mapper;

import com.gustavo.cleanarch.core.dataprovider.client.response.AddressResponse;
import com.gustavo.cleanarch.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {


    Address toAddress(AddressResponse addressResponse);
}
