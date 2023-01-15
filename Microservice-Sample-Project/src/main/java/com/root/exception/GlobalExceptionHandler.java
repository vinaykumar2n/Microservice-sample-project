package com.root.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<CustomErrorDetails> prodException(ProductException pe, WebRequest wr){
		CustomErrorDetails ced = new CustomErrorDetails(LocalDateTime.now(),pe.getMessage(),wr.getDescription(false));
		return new ResponseEntity<CustomErrorDetails>(ced,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<CustomErrorDetails> noHandlerException(NoHandlerFoundException nfe , WebRequest wr){
		CustomErrorDetails ced = new CustomErrorDetails(LocalDateTime.now(),nfe.getMessage(),wr.getDescription(false));
		return new ResponseEntity<CustomErrorDetails>(ced,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorDetails> mainException(Exception e, WebRequest wr){
		CustomErrorDetails ced = new CustomErrorDetails(LocalDateTime.now(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<CustomErrorDetails>(ced,HttpStatus.BAD_REQUEST);
	}
}
