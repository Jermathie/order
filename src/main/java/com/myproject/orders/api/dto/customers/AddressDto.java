package com.myproject.orders.api.dto.customers;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class AddressDto {

    String streetName;
    String houseNumber;
    String postalCode;
    String country;

}
