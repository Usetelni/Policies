package com.equiplano.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equiplano.application.domain.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
	

}
