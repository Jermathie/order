package com.myproject.orders;

import com.myproject.orders.api.dto.customers.CustomerDto;
import com.myproject.orders.domain.customers.Address;
import com.myproject.orders.domain.customers.PhoneNumber;
import com.myproject.orders.service.CustomerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Order Api", version = "1.0", description = "my order app"))
public class OrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerService customerService){
        return (args) -> {
            CustomerDto customerDummy = customerService
                    .createCustomer(CustomerDto
                            .builder()
                            .withLastname("Dummy")
                            .withFirstname("Dum")
                            .withEmailAddress("test@test.com")
                            .withPhoneNumber(PhoneNumber.builder().withCountryCallingCode("0032").withNumber("4581225").build())
                            .withAddress(Address.builder()
                                    .withStreetName("Street")
                                    .withHouseNumber("1")
                                    .withPostalCode("1000")
                                    .withCountry("BE")
                                    .build())
                            .build());
        };
    }

}
