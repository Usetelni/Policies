package com.equiplano.application.converter.customer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.domain.Customer;
import com.equiplano.application.dto.customer.CustomerResponseDTO;

@Component
public class CustomerResponseDTOToCustomerConverter implements Function<CustomerResponseDTO, Customer> {

	@Override
	public Customer apply(CustomerResponseDTO customerResponseDTO) {
		
		Customer customer = new Customer();

		customer.setId(customerResponseDTO.getCustomerId());
		customer.setFullName(customerResponseDTO.getFullName());
		customer.setCpf(customerResponseDTO.getCpf());
		customer.setCity(customerResponseDTO.getCity());
		customer.setFederativeUnit(customerResponseDTO.getFederalUnity());
		customer.setDateModel(customerResponseDTO.getDateModel());
		customer.setPolicies(customerResponseDTO.getPolicies());
		
		return customer;
	}

}
