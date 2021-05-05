package com.myproject.orders.service;

import com.myproject.orders.api.dto.customers.CustomerDto;
import com.myproject.orders.api.mapper.customers.CustomerMapper;
import com.myproject.orders.domain.customers.Customer;
import com.myproject.orders.infrastructure.validators.CustomerValidator;
import com.myproject.orders.infrastructure.validators.EmailValidator;
import com.myproject.orders.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;
    CustomerValidator customerValidator;
    EmailValidator emailValidator;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, CustomerValidator customerValidator, EmailValidator emailValidator) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.customerValidator = customerValidator;
        this.emailValidator = emailValidator;
    }

    //    @Transactional(propagation = Propagation.REQUIRED) ???
    public CustomerDto createCustomer(CustomerDto customerDto) {
        if (!customerValidator.isAFieldEmptyOrNull(customerMapper.toDomain(customerDto))) {
            throw new IllegalArgumentException("All the filds can't be empty or null!");
        }
        emailValidator.isEmailCanBeSave(customerDto);
        customerRepository.save(customerMapper.toDomain(customerDto));

        return customerDto;
    }

    public List<CustomerDto> getAllCustomer() {
        Comparator<CustomerDto> orderByLastNameThenFirstName =
                Comparator.comparing(CustomerDto::getLastname).thenComparing(CustomerDto::getFirstname);
        List<Customer> customers = StreamSupport
                .stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return customers.stream()
                .map(customer -> customerMapper.toDto(customer))
                .collect(Collectors.toList());
    }
}
