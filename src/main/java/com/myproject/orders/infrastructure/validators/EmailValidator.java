package com.myproject.orders.infrastructure.validators;

import com.myproject.orders.api.dto.customers.CustomerDto;
import com.myproject.orders.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidator {

    CustomerRepository customerRepository;

    public boolean isEmailCanBeSave(CustomerDto customerDto){
        return checkIfEmailIsNotAlreadyRegistered(customerDto) && checkIfEmailIsValid(customerDto);
    }

    private boolean checkIfEmailIsNotAlreadyRegistered(CustomerDto customerDto){
        if (customerRepository.findAllByEmailAddress(customerDto.getEmailAddress()).isPresent()){
            throw new IllegalArgumentException("This email is already registered");
        }
        return true;
    }

    private boolean checkIfEmailIsValid(CustomerDto customerDto){
        if(!isValidEmail(customerDto.getEmailAddress())){
            throw new IllegalArgumentException("This email is not valid!");
        }
        return true;
    }

    private boolean isValidEmail(String email){
        String regex ="^[\\w!#$%&’*+/=?`{|}~^-]+" + "(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+" + ")*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

}
