package com.equiplano.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equiplano.application.domain.Client;
import com.equiplano.application.repository.ClientRepository;

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client saveClient(Client clientRequest) {
		Client client = this.clientRepository.save(clientRequest);
		return client;
	}
}
