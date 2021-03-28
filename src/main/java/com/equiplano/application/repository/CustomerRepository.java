package com.equiplano.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equiplano.application.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	

}
