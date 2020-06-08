package com.cadsdanaa.pets.petmanagement.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @Test
  void shouldCreateAndRetrieveCustomers() {
    Customer customer = Customer.builder()
      .phoneNumber("555-555-5555")
      .name("Test Name")
      .address("111 1st Street, TestCity, New York, 12345")
      .build();
    Customer savedCustomer = customerRepository.save(customer);
    Optional<Customer> maybeCustomer = customerRepository.findById(savedCustomer.getId());

    assertThat(maybeCustomer).contains(savedCustomer);
  }

}