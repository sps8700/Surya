package com.xyz.api.webservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.xyz.api.webservice.exception.VlogNotFound;
import com.xyz.api.webservice.exception.EmployeeNotFound;
import com.xyz.api.webservice.model.ExceptionResponse;

@ControllerAdvice
@RestController
public class ResponseExceptionHandlerController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<Object> handleException1(Exception ex, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException2(Exception ex, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(VlogNotFound.class)
	public ResponseEntity<Object> handleException3(Exception ex, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
