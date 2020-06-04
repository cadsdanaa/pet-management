package com.cadsdanaa.pets.petmanagement.customer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Customer {

  String name;
  String address;
  String phoneNumber;

}
