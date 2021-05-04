package com.myproject.orders.api.dto.customers;

import lombok.Builder;
import lombok.Value;


@Value
@Builder(setterPrefix = "with")
public class PhoneNumberDto {

    String number;
    String countryCallingCode;
}
