package com.forex.uid.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.forex.uid.exception.AdhaarCardException;

@RestControllerAdvice
public class AdhaarCardAdvice {
	@ExceptionHandler(AdhaarCardException.class)
public ResponseEntity<String> handleEmailException(AdhaarCardException adhaarCardException){
		
		return new ResponseEntity<String>(adhaarCardException.getMessage(), HttpStatus.BAD_REQUEST);	
	}
}
