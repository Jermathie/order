package com.myproject.orders.repository;

import com.myproject.orders.domain.customers.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {


    Optional<Customer> findAllByEmailAddress(String emailAddress);
}
