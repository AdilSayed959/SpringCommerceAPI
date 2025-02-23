package com.ct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ct.utils.ErrorExtracter;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericExceptions(Exception ex) {
		String errorMessage = ErrorExtracter.extractMessage(ex.getMessage());
		ErrorResponse error = new ErrorResponse(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
