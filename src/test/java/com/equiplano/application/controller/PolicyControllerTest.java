package com.equiplano.application.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.equiplano.application.BaseTest;
import com.equiplano.application.converter.policy.PolicyRequestToPolicyRequestDTOConverter;
import com.equiplano.application.converter.policy.PolicyResponseDTOToPolicyResponseConverter;
import com.equiplano.application.domain.Customer;
import com.equiplano.application.domain.Policy;
import com.equiplano.application.domain.base.DateModel;
import com.equiplano.application.services.policy.PolicyService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@WebMvcTest(PolicyController.class)
public class PolicyControllerTest extends BaseTest{

	private static final String PATH = "/api/v1/policy";
	
	@Autowired
	private MockMvc mvc;
	@MockBean
	private PolicyService policyService;
	@MockBean
	private PolicyRequestToPolicyRequestDTOConverter policyRequestToPolicyRequestDTOConverter;
	@MockBean
	private PolicyResponseDTOToPolicyResponseConverter policyResponseDTOToPolicyResponseConverter;
	
	@Test
	public void ShouldFailTestCreatePolicy() throws Exception {
		Customer customer = new Customer();
		customer.setFullName("WHATEVER");
		customer.setCpf("34785486830");
		customer.setCity("São Paulo");
		customer.setFederativeUnit("SP");
		
		Policy policy = new Policy();
		DateModel dateModel = new DateModel();
		dateModel.setCreatedAt(LocalDateTime.now());
		dateModel.setUpdatedAt(LocalDateTime.now());
		policy.setClient(customer);
		policy.setId(1L);
		policy.setDateModel(dateModel);
		policy.setStartTerm(LocalDate.now());
		policy.setEndTerm(LocalDate.now());
		policy.setVehiclePlate("3121354");
		policy.setPolicyValue(50.0);
		
		String postPath = PATH.concat("/create");
		
		mvc.perform(MockMvcRequestBuilders
				.post(postPath)
				.contentType(APPLICATION_JSON_VALUE)
				.content(asJsonString(policy))
				.accept(APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isBadRequest());
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
