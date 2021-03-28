package com.equiplano.application.converter.policy;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.controller.response.PolicyResponseDTO;
import com.equiplano.application.domain.Policy;

@Component
public class PolicyToPolicyResponseDTO implements Function<Policy, PolicyResponseDTO>{

	@Override
	public PolicyResponseDTO apply(Policy policy) {
		
		PolicyResponseDTO polucyResponseDTO = new PolicyResponseDTO();
		
		polucyResponseDTO.setCustomer(policy.getClient());
		polucyResponseDTO.setPolicyNumber(policy.getPolicyNumber());
		polucyResponseDTO.setStartTerm(policy.getStartTerm());
		polucyResponseDTO.setEndTerm(policy.getEndTerm());
		polucyResponseDTO.setVehiclePlate(policy.getVehiclePlate());
		polucyResponseDTO.setPolicyValue(policy.getPolicyValue());
		polucyResponseDTO.setCurrent(policy.isCurrent());
		polucyResponseDTO.setUntilDueDate(policy.getUtilDueDate());
		
		return polucyResponseDTO;
	}

}
