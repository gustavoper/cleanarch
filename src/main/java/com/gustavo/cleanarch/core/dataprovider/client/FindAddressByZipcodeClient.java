package com.gustavo.cleanarch.core.dataprovider.client;


import com.gustavo.cleanarch.core.dataprovider.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipcodeClient",
        url = "${cepapi.client.address.url}"
)
public interface FindAddressByZipcodeClient {

    @GetMapping("/{zipcode}")
    AddressResponse find(@PathVariable("zipcode") String zipcode);
}
