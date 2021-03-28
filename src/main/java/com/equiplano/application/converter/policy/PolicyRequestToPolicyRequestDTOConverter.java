package com.equiplano.application.converter.policy;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.controller.request.PolicyRequest;
import com.equiplano.application.dto.policy.PolicyRequestDTO;

@Component
public class PolicyRequestToPolicyRequestDTOConverter implements Function<PolicyRequest, PolicyRequestDTO>{

	@Override
	public PolicyRequestDTO apply(PolicyRequest policyRequest) {
		
		PolicyRequestDTO policyRequestDTO = new PolicyRequestDTO();
		
		policyRequestDTO.withCustomer(policyRequest.getCustomer());
		policyRequestDTO.withStartTerm(policyRequest.getStartTerm());
		policyRequestDTO.withEndTerm(policyRequest.getEndTerm());
		policyRequestDTO.withVehiclePlate(policyRequest.getVehiclePlate());
		policyRequestDTO.withPolicyValue(policyRequest.getPolicyValue());

		return policyRequestDTO;
	}

}
