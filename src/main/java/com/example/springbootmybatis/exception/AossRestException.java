package com.example.springbootmybatis.exception;


public class AossRestException extends Exception {
	private static final long serialVersionUID = -4762181054514075995L;
	
	public AossRestException(String message, Exception cause){
		super(message, cause);
	}

	public AossRestException(String message) {
		this(message, null);
	}

	public AossRestException(Exception cause) {
		this(cause.getMessage(), cause);
	}
}
