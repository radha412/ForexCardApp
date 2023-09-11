package com.forex.uid.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.forex.uid.exception.PancardException;

@RestControllerAdvice
public class PancardAdvice {
	@ExceptionHandler(PancardException.class)
	public ResponseEntity<String> handlePancardException(PancardException pancardException){
			
			return new ResponseEntity<String>(pancardException.getMessage(), HttpStatus.BAD_REQUEST);	
		}
}
