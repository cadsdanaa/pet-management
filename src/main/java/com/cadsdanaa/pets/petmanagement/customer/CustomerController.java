package com.cadsdanaa.pets.petmanagement.customer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

  CustomerRepository customerRepository;

  @GetMapping
  public ResponseEntity<Iterable<Customer>> customers() {
    return ResponseEntity.ok(customerRepository.findAll());
  }

}
