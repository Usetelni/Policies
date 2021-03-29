package com.equiplano.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomerException extends RuntimeException{
	
	private static final long serialVersionUID = -4730153296462421593L;

	public CustomerException() {
		
	}
	
	public CustomerException(String message) {
		super(message);
	}
	
	public CustomerException(Throwable e) {
		super(e);
	}
	
	public CustomerException(String message, Throwable e) {
		super(message,e);
	}

}
