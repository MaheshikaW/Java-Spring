package com.example.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.restfulwebservices.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
	
ExceptionResponse exceptionResponse =	new ExceptionResponse(ex.getMessage());
	return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException  ex, HttpHeaders http ,HttpStatus status, WebRequest request){
	
ExceptionResponse exceptionResponse =	new ExceptionResponse("VAlidation failed");
	return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
}
	
	
	}
