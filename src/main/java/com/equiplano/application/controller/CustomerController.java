package com.equiplano.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equiplano.application.controller.request.CustomerRequest;
import com.equiplano.application.controller.response.CustomerResponse;
import com.equiplano.application.converter.customer.CustomerRequestDTOConverter;
import com.equiplano.application.converter.customer.CustomerResponseDTOConverter;
import com.equiplano.application.dto.customer.CustomerRequestDTO;
import com.equiplano.application.dto.customer.CustomerResponseDTO;
import com.equiplano.application.services.customer.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;
	private final CustomerRequestDTOConverter customerRequestDTOConverter;
	private final CustomerResponseDTOConverter customerResponseDTOConverter;

	@Autowired
	public CustomerController(CustomerService customerService,
								CustomerRequestDTOConverter customerRequestDTOConverter,
								CustomerResponseDTOConverter customerResponseDTOConverter
								) {
		this.customerService = customerService;
		this.customerRequestDTOConverter = customerRequestDTOConverter;
		this.customerResponseDTOConverter = customerResponseDTOConverter;
	}

	@PostMapping(path = "/create")
	public ResponseEntity<? extends CustomerResponse> createClient(@RequestBody CustomerRequest customerRequest){
		
		CustomerRequestDTO customerRequestDTO = customerRequestDTOConverter.apply(customerRequest);
		CustomerResponseDTO customerResponseDTO = this.customerService.createCustomer(customerRequestDTO);
		CustomerResponse response = this.customerResponseDTOConverter.apply(customerResponseDTO);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
