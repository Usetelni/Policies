package com.equiplano.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equiplano.application.domain.Policy;

@Repository
public interface PolicyRepository extends CrudRepository<Policy, Long>{
	Policy findPolicyByPolicyNumber(String policyNumber);
}
