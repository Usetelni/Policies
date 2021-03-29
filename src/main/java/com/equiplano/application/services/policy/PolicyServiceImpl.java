package com.equiplano.application.services.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equiplano.application.controller.response.PolicyResponseDTO;
import com.equiplano.application.converter.customer.CustomerResponseDTOToCustomerConverter;
import com.equiplano.application.converter.policy.PolicyRequestDTOToPolicyConverter;
import com.equiplano.application.converter.policy.PolicyToPolicyResponseDTO;
import com.equiplano.application.domain.Customer;
import com.equiplano.application.domain.Policy;
import com.equiplano.application.dto.policy.PolicyRequestDTO;
import com.equiplano.application.exception.PolicyException;
import com.equiplano.application.repository.CustomerRepository;
import com.equiplano.application.repository.PolicyRepository;
import com.equiplano.application.services.customer.CustomerService;

@Service
public class PolicyServiceImpl implements PolicyService{

	private final PolicyRepository policyRepository;
	private final PolicyRequestDTOToPolicyConverter policyRequestDTOToPolicyConverter;
	private final PolicyToPolicyResponseDTO policyToPolicyResponseDTO;
	private final CustomerRepository customerRepository;
	
	@Autowired
	public PolicyServiceImpl(PolicyRepository policyRepository,
							 CustomerService customerService,
							 PolicyRequestDTOToPolicyConverter policyRequestDTOToPolicyConverter,
							 PolicyToPolicyResponseDTO policyToPolicyResponseDTO,
							 CustomerResponseDTOToCustomerConverter customerResponseDTOToCustomerConverter,
							 CustomerRepository customerRepository) {
		this.policyRepository = policyRepository;
		this.policyRequestDTOToPolicyConverter = policyRequestDTOToPolicyConverter;
		this.policyToPolicyResponseDTO = policyToPolicyResponseDTO;
		this.customerRepository = customerRepository;
	}

	@Override
	public PolicyResponseDTO createPolicy(String customerId,PolicyRequestDTO policyDTO) {
		PolicyResponseDTO policyReponseDto  = null;
		Customer customer = this.customerRepository.findById(Long.parseLong(customerId)).get();
		try {
		policyDTO.withCustomer(customer);
		
		Policy policy = this.policyRequestDTOToPolicyConverter.apply(policyDTO);
		Policy policyResponse = this.policyRepository.save(policy);
		
		 policyReponseDto = this.policyToPolicyResponseDTO.apply(policyResponse);
		 
		}catch(Exception e) {
			throw new PolicyException("Houve um problema ao criar a apolice, favor validar os dados", e.getCause());
		}
		return policyReponseDto;
	}

	@Override
	public PolicyResponseDTO findPolicyById(Long id) {
		Policy policy = this.policyRepository.findById(id).get();
		PolicyResponseDTO policyReesponseDto = this.policyToPolicyResponseDTO.apply(policy);
		return policyReesponseDto;
	}

	@Override
	public PolicyResponseDTO findPolicyByNumber(String policyNumber) {
		Policy policy = this.policyRepository.findPolicyByPolicyNumber(policyNumber);
		PolicyResponseDTO policyReesponseDto = this.policyToPolicyResponseDTO.apply(policy);
		return policyReesponseDto;
	}

	
}
