package com.equiplano.application.converter.policy;

import java.util.ArrayList;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.equiplano.application.domain.Customer;
import com.equiplano.application.domain.Policy;
import com.equiplano.application.dto.policy.PolicyRequestDTO;

@Component
public class PolicyRequestDTOToPolicyConverter implements Function<PolicyRequestDTO, Policy>{

	@Override
	public Policy apply(PolicyRequestDTO policyRequestDTO) {
		
		Policy policy = new Policy();
		
//		Customer customer = new Customer();
//		
//		customer.setId(policyRequestDTO.getCustomer().getId());
//		customer.setFullName(policyRequestDTO.getCustomer().getFullName());
//		customer.setCpf(policyRequestDTO.getCustomer().getCpf());
//		customer.setCity(policyRequestDTO.getCustomer().getCity());
//		customer.setFederativeUnit(policyRequestDTO.getCustomer().getFederativeUnit());
//		customer.setDateModel(policyRequestDTO.getCustomer().getDateModel());
//		customer.setPolicies((policyRequestDTO.getCustomer().getPolicies() != null) ? policyRequestDTO.getCustomer().getPolicies() : new ArrayList<>() );
		
		policy.setClient(policyRequestDTO.getCustomer());
		policy.setStartTerm(policyRequestDTO.getStartTerm());
		policy.setEndTerm(policyRequestDTO.getEndTerm());
		policy.setVehiclePlate(policyRequestDTO.getVehiclePlate());
		policy.setPolicyValue(policyRequestDTO.getPolicyValue());
		
		return policy;
	}

}
