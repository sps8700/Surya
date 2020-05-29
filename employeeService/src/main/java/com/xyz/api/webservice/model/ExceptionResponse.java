package com.xyz.api.webservice.model;

public class ExceptionResponse {

	private String message;
	private String details;
	
	public ExceptionResponse() {}
	/**
	 * @param message
	 * @param details
	 */
	public ExceptionResponse(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", details=" + details + "]";
	}
	
	
}
