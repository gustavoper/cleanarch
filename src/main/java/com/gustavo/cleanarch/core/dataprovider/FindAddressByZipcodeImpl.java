package com.gustavo.cleanarch.core.dataprovider;

import com.gustavo.cleanarch.core.dataprovider.client.FindAddressByZipcodeClient;
import com.gustavo.cleanarch.core.dataprovider.client.mapper.AddressResponseMapper;
import com.gustavo.cleanarch.core.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipcodeImpl implements  FindAdressByZipcode{


    @Autowired
    private FindAddressByZipcodeClient findAddressByZipcodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipcode) {
        return addressResponseMapper.toAddress(
                findAddressByZipcodeClient.find(zipcode)
        );
    }
}
