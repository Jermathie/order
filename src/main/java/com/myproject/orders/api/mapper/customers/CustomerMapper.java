package com.myproject.orders.api.mapper.customers;

import com.myproject.orders.api.dto.customers.CustomerDto;
import com.myproject.orders.domain.customers.Customer;
import com.myproject.orders.infrastructure.dto.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerMapper extends Mapper<CustomerDto, Customer> {

    private final PhoneNumberMapper phoneNumberMapper;
    private final AddressMapper addressMapper;

    @Autowired
    public CustomerMapper(PhoneNumberMapper phoneNumberMapper, AddressMapper addressMapper) {
        this.phoneNumberMapper = phoneNumberMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .withCustomerId(customer.getCustomerId().toString())
                .withFirstname(customer.getFirstname())
                .withLastname(customer.getLastname())
                .withEmailAddress(customer.getEmailAddress())
                .withAddress(customer.getAddress())
                .withPhoneNumber(customer.getPhoneNumber())
                .build();
    }

    @Override
    public Customer toDomain(CustomerDto customerDto) {
        return Customer.builder()
                .withCustomerId(UUID.fromString(customerDto.getCustomerId()))
                .withFirstname(customerDto.getFirstname())
                .withLastname(customerDto.getLastname())
                .withEmailAddress(customerDto.getEmailAddress())
                .withAddress(customerDto.getAddress())
                .withPhoneNumber(customerDto.getPhoneNumber())
                .build();
    }
}
