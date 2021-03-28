package com.equiplano.application.dto.policy;

import java.time.LocalDate;

import com.equiplano.application.domain.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class PolicyRequestDTO {
	
	private Customer customer;
	private String policyNumber;
	private LocalDate startTerm;
	private LocalDate endTerm;
	private String vehiclePlate;
	private Double policyValue;
	public Customer getCustomer() {
		return customer;
	}
	public void withCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void withPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public LocalDate getStartTerm() {
		return startTerm;
	}
	public void withStartTerm(LocalDate startTerm) {
		this.startTerm = startTerm;
	}
	public LocalDate getEndTerm() {
		return endTerm;
	}
	public void withEndTerm(LocalDate endTerm) {
		this.endTerm = endTerm;
	}
	public String getVehiclePlate() {
		return vehiclePlate;
	}
	public void withVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}
	public Double getPolicyValue() {
		return policyValue;
	}
	public void withPolicyValue(Double policyValue) {
		this.policyValue = policyValue;
	}
	
	

}
