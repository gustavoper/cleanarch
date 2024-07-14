package com.gustavo.cleanarch.core.dataprovider;

import com.gustavo.cleanarch.core.domain.Address;

public interface FindAdressByZipcode {

    Address find(final String zipcode);
}
