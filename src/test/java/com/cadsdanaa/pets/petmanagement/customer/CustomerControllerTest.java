package com.cadsdanaa.pets.petmanagement.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@WithMockUser
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CustomerRepository customerRepository;

    @Test
    @WithAnonymousUser
    void shouldReturn401GivenInvalidAuth() throws Exception {
        mockMvc.perform(get("/customers"))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void shouldReturnAllCustomers() throws Exception {
        List<Customer> customers = asList(
          Customer.builder()
            .address("some address")
            .name("some name")
            .phoneNumber("555-555-5555")
            .build(),
          Customer.builder()
            .address("some other address")
            .name("some other name")
            .phoneNumber("444-444-4444")
            .build()
        );
        when(customerRepository.findAll()).thenReturn(customers);
        String expectedCustomerString = objectMapper.writeValueAsString(customers);
        mockMvc.perform(get("/customers"))
          .andExpect(status().isOk())
            .andExpect(content().string(expectedCustomerString));
    }

}