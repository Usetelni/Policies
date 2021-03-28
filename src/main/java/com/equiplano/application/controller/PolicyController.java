package com.equiplano.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equiplano.application.domain.Customer;
import com.equiplano.application.domain.Policy;
import com.equiplano.application.request.PolicyRequest;
import com.equiplano.application.services.CustomerServiceImpl;
import com.equiplano.application.services.PolicyServiceImpl;

@RestController
@RequestMapping("/api/v1/policy")
public class PolicyController {

	private final PolicyServiceImpl policyServiceImpl;
	private final CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	public PolicyController(PolicyServiceImpl policyServiceImpl, CustomerServiceImpl customerServiceImpl ) {
		this.policyServiceImpl = policyServiceImpl;
		this.customerServiceImpl = customerServiceImpl;
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<? extends Policy> create(
			@RequestHeader(value = "id", required = true) String customerId, 
			@RequestBody PolicyRequest policyRequest){
		
		
//		Policy policy = this.policyServiceImpl.createPolicy(customerId,policyRequest);
		
//		return new ResponseEntity<>(policy, HttpStatus.CREATED);
		return null;
		
	}
}
