package com.cadsdanaa.pets.petmanagement.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@WithMockUser
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    void shouldReturn401GivenInvalidAuth() throws Exception {
        mockMvc.perform(get("/customers"))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void shouldRespondOkWhenRequestingCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
          .andExpect(status().isOk());
    }

}