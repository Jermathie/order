package com.myproject.orders.domain.customers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
@Embeddable
public class PhoneNumber {

    private String number;
    private String countryCallingCode;
}
