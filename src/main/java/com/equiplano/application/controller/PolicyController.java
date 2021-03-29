package com.equiplano.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equiplano.application.controller.request.PolicyRequest;
import com.equiplano.application.controller.response.PolicyResponse;
import com.equiplano.application.controller.response.PolicyResponseDTO;
import com.equiplano.application.converter.policy.PolicyRequestToPolicyRequestDTOConverter;
import com.equiplano.application.converter.policy.PolicyResponseDTOToPolicyResponseConverter;
import com.equiplano.application.dto.policy.PolicyRequestDTO;
import com.equiplano.application.services.policy.PolicyService;

@RestController
@RequestMapping("/api/v1/policy")
public class PolicyController {

	private final PolicyService policyService;
	private final PolicyRequestToPolicyRequestDTOConverter policyRequestToPolicyRequestDTOConverter;
	private final PolicyResponseDTOToPolicyResponseConverter policyResponseDTOToPolicyResponseConverter;
	
	@Autowired
	public PolicyController(PolicyService policyService,
							PolicyRequestToPolicyRequestDTOConverter policyRequestToPolicyRequestDTOConverter,
							PolicyResponseDTOToPolicyResponseConverter policyResponseDTOToPolicyResponseConverter) {
		this.policyService = policyService;
		this.policyRequestToPolicyRequestDTOConverter = policyRequestToPolicyRequestDTOConverter;
		this.policyResponseDTOToPolicyResponseConverter = policyResponseDTOToPolicyResponseConverter;
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<? extends PolicyResponse> create(
			@RequestHeader(value = "id", required = true) String customerId, 
			@RequestBody PolicyRequest policyRequest){
		
		PolicyRequestDTO policyRequestDTO = this.policyRequestToPolicyRequestDTOConverter.apply(policyRequest);
		
		PolicyResponseDTO policyResponseDTO = this.policyService.createPolicy(customerId,policyRequestDTO);
		PolicyResponse policyResponse = this.policyResponseDTOToPolicyResponseConverter.apply(policyResponseDTO);
		
		
		return new ResponseEntity<>(policyResponse, HttpStatus.CREATED);
		
	}
	
	@GetMapping(path = "/number/{policyNumber}")
	public ResponseEntity<? extends PolicyResponse> getPolicyByPolicyNumber(@PathVariable("policyNumber") String policyNumber){
		
		PolicyResponseDTO policyResponseDTO = this.policyService.findPolicyByNumber(policyNumber);
		PolicyResponse policyResponse = this.policyResponseDTOToPolicyResponseConverter.apply(policyResponseDTO);
		
		return new ResponseEntity<>(policyResponse, HttpStatus.OK);
	}
	
	@GetMapping(path = "/number/{id}")
	public ResponseEntity<? extends PolicyResponse> getPolicyById(@PathVariable("id") String id){

		PolicyResponseDTO policyResponseDTO = this.policyService.findPolicyByNumber(id);
		PolicyResponse policyResponse = this.policyResponseDTOToPolicyResponseConverter.apply(policyResponseDTO);
		
		return new ResponseEntity<>(policyResponse, HttpStatus.OK);
	}
}
