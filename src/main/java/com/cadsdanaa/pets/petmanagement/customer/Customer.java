package com.cadsdanaa.pets.petmanagement.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Customer {

  @Id
  @Builder.Default
  String id = UUID.randomUUID().toString();
  String name;
  String address;
  String phoneNumber;

}