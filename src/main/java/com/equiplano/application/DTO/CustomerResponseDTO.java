package com.equiplano.application.DTO;

import java.util.List;

import com.equiplano.application.domain.Policy;
import com.equiplano.application.domain.base.DateModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class CustomerResponseDTO {

	private Long customerId;
	private String fullName;
	private String cpf;
	private String city;
	private String federalUnity;
	private List<Policy> policies;
	private DateModel dateModel;
	private Integer version;

	public Long getCustomerId() {
		return customerId;
	}

	public void withCustomerId(Long customerId) {
		this.customerId = customerId;
	}

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

	public String getFederalUnity() {
		return federalUnity;
	}

	public void withFederalUnity(String federalUnity) {
		this.federalUnity = federalUnity;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void withPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public DateModel getDateModel() {
		return dateModel;
	}

	public void withDateModel(DateModel dateModel) {
		this.dateModel = dateModel;
	}

	public Integer getVersion() {
		return version;
	}

	public void withVersion(Integer version) {
		this.version = version;
	}

}
