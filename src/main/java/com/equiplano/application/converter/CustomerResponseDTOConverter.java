package com.equiplano.application.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.DTO.CustomerResponseDTO;
import com.equiplano.application.response.CustomerResponse;

@Component
public class CustomerResponseDTOConverter implements Function<CustomerResponseDTO, CustomerResponse>{

	@Override
	public CustomerResponse apply(CustomerResponseDTO customerResponseDTO) {
		CustomerResponse response = new CustomerResponse();
		
		response.withCustomerId(customerResponseDTO.getCustomerId());
		response.withFullName(customerResponseDTO.getFullName());
		response.withCpf(customerResponseDTO.getCpf());
		response.withCity(customerResponseDTO.getCity());
		response.withFederalUnity(customerResponseDTO.getFederalUnity());
		response.withDateModel(customerResponseDTO.getDateModel());
		response.withPolicies(customerResponseDTO.getPolicies());
		
		return response;
	}

}
