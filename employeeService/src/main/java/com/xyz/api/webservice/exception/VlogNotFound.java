package com.xyz.api.webservice.exception;

public class VlogNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VlogNotFound(String message) {
		super(message);
	}
}
