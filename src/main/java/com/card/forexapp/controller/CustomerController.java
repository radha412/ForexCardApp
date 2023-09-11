package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.dto.CustomerDTO;
import com.card.forexapp.entity.Customer;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.service.CustomerService;



@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers/")
	public List<Customer> getAllUser(){
		return customerService.getAllCustomers();
	}
	
	@PostMapping("customers/submit-customer-details")
	public ResponseEntity<String> submitCustomerDetails(@RequestBody CustomerDTO customerDto) throws PotentialCustomerException{
		this.customerService.submitCustomerDetails(customerDto);
		return ResponseEntity.ok("form submitted successfully");
	}
}
