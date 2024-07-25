package com.gustavo.cleanarch.entrypoint.controller.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    public String name;

    @NotBlank
    public String cpf;

    @NotBlank
    public String zipcode;

    //Não lombokou
    public String getZipcode() {
        return zipcode;
    }

}
