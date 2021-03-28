package com.equiplano.application.controller.request;

import java.time.LocalDate;

import com.equiplano.application.domain.Customer;

public class PolicyRequest {

	private Customer customer;
	private String policyNumber;
	private LocalDate startTerm;
	private LocalDate endTerm;
	private String vehiclePlate;
	private Double policyValue;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public LocalDate getStartTerm() {
		return startTerm;
	}

	public void setStartTerm(LocalDate startTerm) {
		this.startTerm = startTerm;
	}

	public LocalDate getEndTerm() {
		return endTerm;
	}

	public void setEndTerm(LocalDate endTerm) {
		this.endTerm = endTerm;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

	public Double getPolicyValue() {
		return policyValue;
	}

	public void setPolicyValue(Double policyValue) {
		this.policyValue = policyValue;
	}

}
