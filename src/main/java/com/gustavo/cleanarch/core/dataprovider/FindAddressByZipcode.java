package com.gustavo.cleanarch.core.dataprovider;

import com.gustavo.cleanarch.core.domain.Address;

public interface FindAddressByZipcode {

    Address find(final String zipcode);
}
