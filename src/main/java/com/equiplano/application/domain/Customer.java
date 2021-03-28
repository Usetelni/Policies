package com.equiplano.application.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.equiplano.application.domain.base.DomainModel;

@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer extends DomainModel<Customer> {

	private static final long serialVersionUID = -5203930890027185670L;
	
	@Column(name = "nome_completo", nullable = false)
	private String fullName;
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	@Column(name = "cidade", nullable = false)
	private String city;
	@Column(name = "uf", nullable = false)
	private String federativeUnit;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
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