package com.equiplano.application.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.DTO.CustomerResponseDTO;
import com.equiplano.application.domain.Customer;

@Component
public class CustomerToCustomerResponseDTOConverter implements Function<Customer, CustomerResponseDTO>{

	@Override
	public CustomerResponseDTO apply(Customer customer) {
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		
		customerResponseDTO.withCustomerId(customer.getId());
		customerResponseDTO.withFullName(customer.getFullName());
		customerResponseDTO.withCpf(customer.getCpf());
		customerResponseDTO.withCity(customer.getCity());
		customerResponseDTO.withFederalUnity(customer.getFederativeUnit());
		customerResponseDTO.withDateModel(customer.getDateModel());
		customerResponseDTO.withPolicies(customer.getPolicies());
		
		
		
		return customerResponseDTO;
	}

}
