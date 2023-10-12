package com.example.microservices.CurrencyConvertion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptions {
	
	
	GlobalExceptions(){
		super();}
	
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<String> exceptionHandler(Exception ex)
	  {
	
		  ex.printStackTrace();
		  return new ResponseEntity<String>(" oops!!! something went wrong :    " + ex.getMessage(),org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	 
}
