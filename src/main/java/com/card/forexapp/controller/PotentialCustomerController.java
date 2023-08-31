package com.card.forexapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.card.forexapp.dto.OTPDto;
import com.card.forexapp.dto.PotentialCustomerDTO;
import com.card.forexapp.entity.PotentialCustomers;
import com.card.forexapp.exception.EmailVerificationException;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.service.PotentialCustomersService;

@RestController
public class PotentialCustomerController {
	
	@Autowired
	PotentialCustomersService potentialCustomerservice;
	
	@GetMapping("/potencialcustomers/")
	public List<PotentialCustomers> getAllForexCardDetails(){
		return this.potentialCustomerservice.getAllPotencialCustomers();
	}
	
	@PostMapping("potential-customer/get-otp-for-email-verification/")
	public ResponseEntity<String> getOTPForEmailVerification(@RequestBody PotentialCustomerDTO potentialCustomer) throws EmailVerificationException{
			 this.potentialCustomerservice.generateOtpForEmailVerification(potentialCustomer);
			 return  ResponseEntity.ok("Email sent successfully");
	}

	@PostMapping("potential-customer/verify-otp-for-email-verification/")
	public ResponseEntity<String> verifyOtpForEmailVerification(@RequestBody OTPDto otpDto) throws EmailVerificationException{
		this.potentialCustomerservice.verifyOtpforEmailVerification(otpDto);
		 return ResponseEntity.ok("Email Got Verified");
	}

	@PostMapping("potential-customer/set-password")
	public ResponseEntity<String> setPassword(@RequestBody PotentialCustomerDTO potentialCustomer){
		this.potentialCustomerservice.setPassword(potentialCustomer);
		return ResponseEntity.ok("Login Successfully");
	}
	
	@PostMapping("/poential-customer/save-details")
	public ResponseEntity<String> savePotentialCustomerDetails(@RequestBody PotentialCustomerDTO potentialCustomerDto){
		this.potentialCustomerservice.savePotentialCustomerDetails(potentialCustomerDto);
		return ResponseEntity.ok("Details Saved Successfully");
	}
	
	@GetMapping("/potential-customer/login-credentials/")
	public ResponseEntity<String> verifyLoginCredentials(@RequestBody PotentialCustomerDTO potentialCustomerDto) throws PotentialCustomerException{
		 this.potentialCustomerservice.verifyLoginCredentials(potentialCustomerDto);
		return ResponseEntity.ok("Login Successfully");
	}
}
