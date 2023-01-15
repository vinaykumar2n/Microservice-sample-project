package com.root.exception;

import java.time.LocalDateTime;

public class CustomErrorDetails {
	
	private LocalDateTime errorTime;
	private String message;
	private String description;
	
	public CustomErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public CustomErrorDetails(LocalDateTime errorTime, String message, String description) {
		super();
		this.errorTime = errorTime;
		this.message = message;
		this.description = description;
	}

	public LocalDateTime getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
