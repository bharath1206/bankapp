package com.demo.bankapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> exceptionHandler(Exception ex) {
		ApiError error = new ApiError();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage("The request could not be completed successfully.");
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}

}