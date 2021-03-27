package com.equiplano.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equiplano.application.domain.Client;
import com.equiplano.application.services.ClientService;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

	private final ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService ) {
		this.clientService = clientService;
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<? extends Client> createClient(@RequestBody Client clientRequest){
		
		Client client = this.clientService.saveClient(clientRequest);
		return new ResponseEntity<>(client, HttpStatus.CREATED);
	}
}
