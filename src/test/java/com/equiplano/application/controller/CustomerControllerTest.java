package com.equiplano.application.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.equiplano.application.BaseTest;
import com.equiplano.application.controller.request.CustomerRequest;
import com.equiplano.application.converter.customer.CustomerRequestDTOConverter;
import com.equiplano.application.converter.customer.CustomerResponseDTOConverter;
import com.equiplano.application.services.customer.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@AutoConfigureMockMvc
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest extends BaseTest{
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CustomerService customerService;
	@MockBean
	private CustomerRequestDTOConverter customerRequestDTOConverter;
	@MockBean
	private CustomerResponseDTOConverter customerResponseDTOConverter;
	
	private static final String PATH = "/api/v1/customer";

	@Test
	public void ShouldTestCreateClient() throws Exception {
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setFullName("WHATEVER");
		customerRequest.setCpf("34785486830");
		customerRequest.setCity("São Paulo");
		customerRequest.setFederativeUnit("SP");
		
		String postPath = PATH.concat("/create");
		
		mvc.perform(MockMvcRequestBuilders
				.post(postPath)
				.contentType(APPLICATION_JSON_VALUE)
				.content(asJsonString(customerRequest))
				.accept(APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isCreated());
	}
	
	private String asJsonString(Object obj) {

		if (Objects.isNull(obj)) {
			throw new RuntimeException("Object to parse as string is null");
		}

		try {
			return new ObjectMapper().writeValueAsString(obj);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
