package com.equiplano.application.converter.policy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.controller.response.PolicyResponse;
import com.equiplano.application.controller.response.PolicyResponseDTO;

@Component
public class PolicyResponseDTOToPolicyResponseConverter implements Function<PolicyResponseDTO, PolicyResponse>{

	@Override
	public PolicyResponse apply(PolicyResponseDTO policyResponseDTO) {
		
		PolicyResponse policyResponse = new PolicyResponse();
		
		policyResponse.setCustomer(policyResponseDTO.getCustomer());
		policyResponse.setPolicyNumber(policyResponseDTO.getPolicyNumber());
		policyResponse.setStartTerm(policyResponseDTO.getStartTerm());
		policyResponse.setEndTerm(policyResponseDTO.getEndTerm());
		policyResponse.setVehiclePlate(policyResponseDTO.getVehiclePlate());
		policyResponse.setPolicyValue(policyResponseDTO.getPolicyValue());
		policyResponse.setCurrent(policyResponseDTO.isCurrent());
		policyResponse.setUtilDueDate((ChronoUnit.DAYS.between(LocalDate.now(),policyResponseDTO.getEndTerm())) > 0 ? ChronoUnit.DAYS.between(LocalDate.now(),policyResponseDTO.getEndTerm()):0);
		
		return policyResponse;
	}

}
