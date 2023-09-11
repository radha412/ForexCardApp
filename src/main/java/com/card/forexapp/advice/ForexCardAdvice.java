package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.card.forexapp.exception.ForexCardException;

@RestControllerAdvice
public class ForexCardAdvice {
	@ExceptionHandler(ForexCardException.class)
	public ResponseEntity<String> handleEmailException(ForexCardException forexCardException){
		
		return new ResponseEntity<String>(forexCardException.getMessage(), HttpStatus.BAD_REQUEST);	
	}
}
