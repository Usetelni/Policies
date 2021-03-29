package com.equiplano.application.converter.policy;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.domain.Policy;
import com.equiplano.application.dto.policy.PolicyRequestDTO;

@Component
public class PolicyRequestDTOToPolicyConverter implements Function<PolicyRequestDTO, Policy>{

	@Override
	public Policy apply(PolicyRequestDTO policyRequestDTO) {
		
		Policy policy = new Policy();
		
		policy.setClient(policyRequestDTO.getCustomer());
		policy.setStartTerm(policyRequestDTO.getStartTerm());
		policy.setEndTerm(policyRequestDTO.getEndTerm());
		policy.setVehiclePlate(policyRequestDTO.getVehiclePlate());
		policy.setPolicyValue(policyRequestDTO.getPolicyValue());
		
		return policy;
	}

}
