package com.equiplano.application.services;

import com.equiplano.application.DTO.CustomerRequestDTO;
import com.equiplano.application.DTO.CustomerResponseDTO;

public interface CustomerService {

	CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO findCustomerById(Long id);
	
}
