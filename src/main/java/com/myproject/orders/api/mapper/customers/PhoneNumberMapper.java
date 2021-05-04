package com.myproject.orders.api.mapper.customers;

import com.myproject.orders.api.dto.customers.PhoneNumberDto;
import com.myproject.orders.domain.customers.PhoneNumber;
import com.myproject.orders.infrastructure.dto.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberMapper extends Mapper<PhoneNumberDto, PhoneNumber> {

    @Override
    public PhoneNumberDto toDto(PhoneNumber phoneNumber) {
        return PhoneNumberDto.builder()
                .withCountryCallingCode(phoneNumber.getCountryCallingCode())
                .withNumber(phoneNumber.getNumber())
                .build();
    }

    @Override
    public PhoneNumber toDomain(PhoneNumberDto phoneNumberDto) {
        return PhoneNumber.builder()
                .withCountryCallingCode(phoneNumberDto.getCountryCallingCode())
                .withNumber(phoneNumberDto.getNumber())
                .build();
    }
}
