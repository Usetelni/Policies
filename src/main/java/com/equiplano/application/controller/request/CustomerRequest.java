package com.equiplano.application.controller.request;

public class CustomerRequest {

	private String fullName;
	private String cpf;
	private String city;
	private String federativeUnit;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFederativeUnit() {
		return federativeUnit;
	}

	public void setFederativeUnit(String federativeUnit) {
		this.federativeUnit = federativeUnit;
	}

	
}
