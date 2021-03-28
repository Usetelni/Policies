package com.equiplano.application.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equiplano.application.converter.customer.CustomerRequestDTOToCustomerConverter;
import com.equiplano.application.converter.customer.CustomerToCustomerResponseDTOConverter;
import com.equiplano.application.domain.Customer;
import com.equiplano.application.dto.customer.CustomerRequestDTO;
import com.equiplano.application.dto.customer.CustomerResponseDTO;
import com.equiplano.application.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;
	private final CustomerRequestDTOToCustomerConverter customerRequestDTOToCustomerConverter;
	private final CustomerToCustomerResponseDTOConverter customerToCustomerResponseDTOConverter;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository,
			CustomerRequestDTOToCustomerConverter customerRequestDTOToCustomerConverter,
			CustomerToCustomerResponseDTOConverter customerToCustomerResponseDTOConverter) {
		this.customerRepository = customerRepository;
		this.customerRequestDTOToCustomerConverter = customerRequestDTOToCustomerConverter;
		this.customerToCustomerResponseDTOConverter = customerToCustomerResponseDTOConverter;
	}
	
	@Override
	public CustomerResponseDTO findCustomerById(Long id) {
		Customer customer = this.customerRepository.findById(id).get();
		CustomerResponseDTO customerResponseDTO = this.customerToCustomerResponseDTOConverter.apply(customer);
		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
		Customer customer = this.customerRequestDTOToCustomerConverter.apply(customerRequestDTO);
		Customer customerResponse = this.customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = this.customerToCustomerResponseDTOConverter.apply(customerResponse);
		return customerResponseDTO;
	}

	
}
