package com.equiplano.application.exception;

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
