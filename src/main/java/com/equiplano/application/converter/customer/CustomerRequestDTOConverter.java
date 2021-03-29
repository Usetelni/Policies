package com.equiplano.application.converter.customer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.controller.request.CustomerRequest;
import com.equiplano.application.dto.customer.CustomerRequestDTO;

@Component
public class CustomerRequestDTOConverter implements Function<CustomerRequest, CustomerRequestDTO>{

	@Override
	public CustomerRequestDTO apply(CustomerRequest customerRequest) {
		
		CustomerRequestDTO dto = new CustomerRequestDTO();
		
		dto.withFullName(customerRequest.getFullName());
		dto.withCpf(customerRequest.getCpf());
		dto.withCity(customerRequest.getCity());
		dto.withFederativeUnit(customerRequest.getFederativeUnit());
		
		return dto;
	}

}
