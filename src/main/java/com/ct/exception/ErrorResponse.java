package com.ct.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private LocalDateTime localDateTime;
	private String message;
	private String status;

	public ErrorResponse() {
	}

	public ErrorResponse(String message, String status) {
		this.localDateTime = LocalDateTime.now();
		this.message = message;
		this.status = status;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
