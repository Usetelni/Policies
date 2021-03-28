package com.equiplano.application.services.policy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equiplano.application.controller.response.PolicyResponseDTO;
import com.equiplano.application.converter.customer.CustomerResponseDTOToCustomerConverter;
import com.equiplano.application.converter.policy.PolicyRequestDTOToPolicyConverter;
import com.equiplano.application.converter.policy.PolicyToPolicyResponseDTO;
import com.equiplano.application.domain.Customer;
import com.equiplano.application.domain.Policy;
import com.equiplano.application.dto.policy.PolicyRequestDTO;
import com.equiplano.application.repository.CustomerRepository;
import com.equiplano.application.repository.PolicyRepository;
import com.equiplano.application.services.customer.CustomerService;

@Service
public class PolicyServiceImpl implements PolicyService{

	private final PolicyRepository policyRepository;
	private final CustomerService customerService;
	private final PolicyRequestDTOToPolicyConverter policyRequestDTOToPolicyConverter;
	private final PolicyToPolicyResponseDTO policyToPolicyResponseDTO;
	private final CustomerResponseDTOToCustomerConverter customerResponseDTOToCustomerConverter;
	private final CustomerRepository customerRepository;
	
	@Autowired
	public PolicyServiceImpl(PolicyRepository policyRepository,
							 CustomerService customerService,
							 PolicyRequestDTOToPolicyConverter policyRequestDTOToPolicyConverter,
							 PolicyToPolicyResponseDTO policyToPolicyResponseDTO,
							 CustomerResponseDTOToCustomerConverter customerResponseDTOToCustomerConverter,
							 CustomerRepository customerRepository) {
		this.policyRepository = policyRepository;
		this.customerService = customerService;
		this.policyRequestDTOToPolicyConverter = policyRequestDTOToPolicyConverter;
		this.policyToPolicyResponseDTO = policyToPolicyResponseDTO;
		this.customerResponseDTOToCustomerConverter = customerResponseDTOToCustomerConverter;
		this.customerRepository = customerRepository;
	}

	@Override
	public PolicyResponseDTO createPolicy(String customerId,PolicyRequestDTO policyDTO) {
		
		Customer customer = this.customerRepository.findById(Long.parseLong(customerId)).get();
		
		policyDTO.withCustomer(customer);
		
		Policy policy = this.policyRequestDTOToPolicyConverter.apply(policyDTO);
		Policy policyResponse = this.policyRepository.save(policy);
		
		PolicyResponseDTO policyReponseDto = this.policyToPolicyResponseDTO.apply(policyResponse);
		
		return policyReponseDto;
	}

	@Override
	public PolicyResponseDTO findPolicyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PolicyResponseDTO findPolicyByNumber(String policyNumber) {
		Policy policy = this.policyRepository.findPolicyByPolicyNumber(policyNumber);
		PolicyResponseDTO policyReesponseDto = this.policyToPolicyResponseDTO.apply(policy);
		return policyReesponseDto;
	}

	
}
