package com.myproject.orders.api.mapper.customers;

import com.myproject.orders.api.dto.customers.AddressDto;
import com.myproject.orders.domain.customers.Address;
import com.myproject.orders.infrastructure.dto.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper extends Mapper<AddressDto, Address> {

    @Override
    public AddressDto toDto(Address address) {
        return AddressDto.builder()
                .withStreetName(address.getStreetName())
                .withHouseNumber(address.getHouseNumber())
                .withPostalCode(address.getPostalCode())
                .withCountry(address.getCountry())
                .build();
    }

    @Override
    public Address toDomain(AddressDto addressDto) {
        return Address.builder()
                .withStreetName(addressDto.getStreetName())
                .withHouseNumber(addressDto.getHouseNumber())
                .withPostalCode(addressDto.getPostalCode())
                .withCountry(addressDto.getCountry())
                .build();
    }
}
