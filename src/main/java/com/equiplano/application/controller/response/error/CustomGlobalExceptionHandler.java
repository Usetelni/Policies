package com.equiplano.application.controller.response.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.equiplano.application.exception.CustomerException;
import com.equiplano.application.exception.PolicyException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PolicyException.class)
	public ResponseEntity<CustomErrorResponse> customHandlePolicy(Exception ex, WebRequest request) {

		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimeStamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setstatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<CustomErrorResponse> customHandleCustomer(Exception ex, WebRequest request) {

		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimeStamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setstatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	}
}
