package com.forex.uid.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.forex.uid.exception.PassportException;

@RestControllerAdvice
public class PassportAdvice {
@ExceptionHandler(PassportException.class)
	public ResponseEntity<String> handlepassportException(PassportException passportException){
	return new ResponseEntity<String>(passportException.getMessage(), HttpStatus.BAD_REQUEST);
}
}
