package com.equiplano.application.domain.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.TimeZone;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public class DomainModel<T extends DomainModel<T>> implements Serializable {

	private static final long serialVersionUID = -4412839424426999064L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private DateModel dateModel;
	
	@Version
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateModel getDateModel() {
		return dateModel;
	}

	public void setDateModel(DateModel dateModel) {
		this.dateModel = dateModel;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@PrePersist
	public void initializeDates() {
		LocalDateTime now = LocalDateTime.now(TimeZone.getDefault().toZoneId());
		dateModel = new DateModel(now,now);
	}
	
	@PreUpdate
	public void updateUpdateAt() {
		dateModel.setUpdatedAt(LocalDateTime.now(TimeZone.getDefault().toZoneId()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateModel, id, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainModel<?> other = (DomainModel<?>) obj;
		return Objects.equals(dateModel, other.dateModel) && Objects.equals(id, other.id)
				&& Objects.equals(version, other.version);
	}

	@Override
	public String toString() {
		return String.format("DomainModel [id=%s, dateModel=%s, version=%s]", id, dateModel, version);
	}
	
}
