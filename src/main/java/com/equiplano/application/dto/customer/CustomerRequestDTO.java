package com.equiplano.application.dto.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class CustomerRequestDTO {

	private String fullName;
	private String cpf;
	private String city;
	private String federativeUnit;

	public String getFullName() {
		return fullName;
	}

	public void withFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCpf() {
		return cpf;
	}

	public void withCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCity() {
		return city;
	}

	public void withCity(String city) {
		this.city = city;
	}

	public String getFederativeUnit() {
		return federativeUnit;
	}

	public void withFederativeUnit(String federativeUnit) {
		this.federativeUnit = federativeUnit;
	}

	@Override
	public String toString() {
		return String.format("CustomerRequestDTO [fullName=%s, cpf=%s, city=%s, federativeUnit=%s]", fullName, cpf,
				city, federativeUnit);
	}

	
}
