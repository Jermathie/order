package com.myproject.orders.infrastructure.validators;

import com.myproject.orders.domain.customers.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator extends EntityValidator<Customer>{

    @Override
    public boolean isAFieldEmptyOrNull(Customer customer) {
        return isNull(customer)
                || isEmptyOrNull(customer.getFirstname())
                || isEmptyOrNull(customer.getLastname())
                || isNull(customer.getAddress())
                || isEmptyOrNull(customer.getAddress().getStreetName())
                || isEmptyOrNull(customer.getAddress().getHouseNumber())
                || isEmptyOrNull(customer.getAddress().getPostalCode())
                || isEmptyOrNull(customer.getAddress().getCountry())
                || isNull(customer.getEmailAddress())
                || isNull(customer.getPhoneNumber())
                || isEmptyOrNull(customer.getPhoneNumber().getCountryCallingCode())
                || isEmptyOrNull(customer.getPhoneNumber().getNumber());
    }



}
