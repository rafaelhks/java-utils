package com.rafaelhks.exception;

public class UtilsException extends Exception{
	
	private String customMessage;
	
	public UtilsException(String message) {
		super(message);
	}
	
	public UtilsException(String message, String customMessage) {
		super(message);
		this.customMessage = customMessage;
	}
	
	public UtilsException(String message, Throwable t) {
		super(message, t);
	}
	
	public UtilsException(String message, String customMessage, Throwable t) {
		super(message, t);
		this.customMessage = customMessage;
	}
	
	public String getCustomMessage() {
		return customMessage;
	}
	
	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
}
