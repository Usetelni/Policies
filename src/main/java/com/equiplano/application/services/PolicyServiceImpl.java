package com.equiplano.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equiplano.application.domain.Customer;
import com.equiplano.application.domain.Policy;
import com.equiplano.application.repository.PolicyRepository;

@Service
public class PolicyServiceImpl {

	private final PolicyRepository policyRepository;
	
	@Autowired
	public PolicyServiceImpl(PolicyRepository policyRepository) {
		this.policyRepository = policyRepository;
	}
	
	

//	@Override
//	public PolicyResponseDTO createPolicy(Long id,PolicyRequestDTO policy) {
//		Policy policy = this.policyRepository.save(policyRequest);
//		Customer customer = this.customerServiceImpl.findCustomerById(Long.parseLong(customerId));
//		return policy;
//	}
//
//	@Override
//	public PolicyResponseDTO findPolicyById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PolicyResponseDTO findPolicyByNumber(String policyNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
