package com.equiplano.application.services.policy;

import com.equiplano.application.controller.response.PolicyResponseDTO;
import com.equiplano.application.dto.policy.PolicyRequestDTO;

public interface PolicyService {

	PolicyResponseDTO createPolicy(String customerId, PolicyRequestDTO policy);
	PolicyRequestDTO findPolicyById(Long id);
	PolicyRequestDTO findPolicyByNumber(String policyNumber);
}
