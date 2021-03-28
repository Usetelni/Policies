package com.equiplano.application.services.customer;

import com.equiplano.application.dto.customer.CustomerRequestDTO;
import com.equiplano.application.dto.customer.CustomerResponseDTO;

public interface CustomerService {

	CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO findCustomerById(Long id);
	
	
}
