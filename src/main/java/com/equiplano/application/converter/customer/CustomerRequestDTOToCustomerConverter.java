package com.equiplano.application.converter.customer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.domain.Customer;
import com.equiplano.application.dto.customer.CustomerRequestDTO;

@Component
public class CustomerRequestDTOToCustomerConverter implements Function<CustomerRequestDTO, Customer>{

	@Override
	public Customer apply(CustomerRequestDTO customerRequestDTO) {
		
		Customer customer = new Customer();
		
		customer.setFullName(customerRequestDTO.getFullName());
		customer.setCpf(customerRequestDTO.getCpf());
		customer.setCity(customerRequestDTO.getCity());
		customer.setFederativeUnit(customerRequestDTO.getFederativeUnit());
		
		return customer;
	}

}
