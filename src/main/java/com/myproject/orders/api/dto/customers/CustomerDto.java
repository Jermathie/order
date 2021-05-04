package com.myproject.orders.api.dto.customers;

import com.myproject.orders.domain.customers.Address;
import com.myproject.orders.domain.customers.PhoneNumber;
import lombok.*;


@Value
@Builder(setterPrefix = "with")
public class CustomerDto {

    String customerId;
    String firstname;
    String lastname;
    String emailAddress;
    Address address;
    PhoneNumber phoneNumber;
}
