package com.equiplano.application.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.equiplano.application.domain.base.DomainModel;

@Entity
@Table(name = "apolice")
public class Policy extends DomainModel<Policy> {

	private static final long serialVersionUID = 8303858629788568223L;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Client client;
	
	@Column(name = "numero_apolice", unique = true, nullable = false)
	private String policyNumber;
	@Column(name = "inicio_vigencia", nullable = false)
	private LocalDate startTerm;
	@Column(name = "fim_vigencia", nullable = false)
	private LocalDate endTerm;
	@Column(name = "placa_veiculo", nullable = false)
	private String vehiclePlate;
	@Column(name = "valor_apolice", nullable = false)
	private Double policyValue;

	public String getPolicyNumber() {
		return policyNumber;
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
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@PrePersist
	public void createPolicyNumber() {
		this.policyNumber = "PLC - " + UUID.randomUUID().toString();
	}

	public boolean isCurrent() {
		return this.getEndTerm().isBefore(LocalDate.now()) ? true : false;
	}
	
	public Long untilDueDate() {
	
		return ChronoUnit.DAYS.between(this.getEndTerm(), LocalDate.now());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(client, endTerm, policyNumber, policyValue, startTerm, vehiclePlate);
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
		Policy other = (Policy) obj;
		return Objects.equals(client, other.client) && Objects.equals(endTerm, other.endTerm)
				&& Objects.equals(policyNumber, other.policyNumber) && Objects.equals(policyValue, other.policyValue)
				&& Objects.equals(startTerm, other.startTerm) && Objects.equals(vehiclePlate, other.vehiclePlate);
	}

	@Override
	public String toString() {
		return String.format(
				"Policy [client=%s, policyNumber=%s, startTerm=%s, endTerm=%s, vehiclePlate=%s, policyValue=%s]",
				client, policyNumber, startTerm, endTerm, vehiclePlate, policyValue);
	}
	
	
}