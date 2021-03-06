package com.equiplano.application.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.equiplano.application.domain.base.DomainModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "clientes")
public class Customer extends DomainModel<Customer> {

	private static final long serialVersionUID = -5203930890027185670L;
	
	@Column(name = "nome_completo", nullable = false)
	@NotBlank(message = "O Nome deve ser preenchido.")
	private String fullName;
	@Column(name = "cpf", nullable = false, unique = true)
	@CPF(message = "Cpf informado invalido")
	@NotBlank(message = "Cpf deve ser infomado.")
	private String cpf;
	@Column(name = "cidade", nullable = false)
	@NotBlank(message = "Cidade deve ser infomado")
	private String city;
	@Column(name = "uf", nullable = false)
	@NotBlank(message = "O UF deve ser infomado.")
	private String federativeUnit;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	@JsonBackReference
	private List<Policy> policies;

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

	
	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(city, cpf, federativeUnit, fullName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(city, other.city) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(federativeUnit, other.federativeUnit) && Objects.equals(fullName, other.fullName);
	}

	@Override
	public String toString() {
		return String.format("Customer [fullName=%s, cpf=%s, city=%s, federativeUnit=%s]", fullName, cpf,
				city, federativeUnit);
	}

	
	
}
