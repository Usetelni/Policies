package com.equiplano.application.services.policy;

import com.equiplano.application.controller.response.PolicyResponseDTO;
import com.equiplano.application.dto.policy.PolicyRequestDTO;

public interface PolicyService {

	PolicyResponseDTO createPolicy(String customerId, PolicyRequestDTO policy);
	PolicyResponseDTO findPolicyById(Long id);
	PolicyResponseDTO findPolicyByNumber(String policyNumber);
	
}
