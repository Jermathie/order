package com.myproject.orders.domain.customers;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
@Entity
@Table(name = "ORDR_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID customerId;

    private String firstname;
    private String lastname;
    private String emailAddress;

    @Embedded
    private Address address;

    @Embedded
    private PhoneNumber phoneNumber;


}
