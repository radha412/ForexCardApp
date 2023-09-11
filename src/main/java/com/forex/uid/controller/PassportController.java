package com.forex.uid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.forex.uid.DTO.PassportDTO;
import com.forex.uid.exception.PassportException;
import com.forex.uid.service.PassportService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PassportController {
	@Autowired
	private PassportService passportService;
	
	@GetMapping("passport-verification/{passport}")
	public ResponseEntity<String> verifyPassport(@PathVariable String passport) throws PassportException{
		this.passportService.verifyPassport(passport);
		return ResponseEntity.ok("Your Passport got verified");
	}
}

