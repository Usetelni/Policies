package com.equiplano.application.exception;

public class PolicyException extends RuntimeException{

	private static final long serialVersionUID = -4164772057370980637L;

	public PolicyException() {
		
	}
	
	public PolicyException(String message) {
		super(message);
	}
	
	public PolicyException(Throwable e) {
		super(e);
	}
	
	public PolicyException(String message, Throwable e) {
		super(message, e);
	}
}
