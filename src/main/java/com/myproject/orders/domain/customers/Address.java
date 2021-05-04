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
public class Address {

    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String country;


}
