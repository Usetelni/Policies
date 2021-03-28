package com.equiplano.application.controller.request;

import javax.validation.constraints.NotBlank;

public class CustomerRequest {

	@NotBlank(message = "Nome deve ser preenchido")
	private String fullName;
	@NotBlank(message = "O CPF deve ser preenchido")
	private String cpf;
	@NotBlank(message = "A Cidade deve ser preenchida")
	private String city;
	@NotBlank(message = "A UF deve ser preenchida")
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
