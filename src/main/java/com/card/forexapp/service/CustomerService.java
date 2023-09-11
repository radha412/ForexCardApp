package com.card.forexapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.dto.CustomerDTO;
import com.card.forexapp.dto.ForexCardDTO;
import com.card.forexapp.dto.PotentialCustomerDTO;
import com.card.forexapp.entity.Customer;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.repository.CustomerRepository;



@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PotentialCustomersService potentialCustomerService;
	
	@Autowired
	private ForexCardService forexCardService;
	
	
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void submitCustomerDetails(CustomerDTO customerDto) throws PotentialCustomerException {
		Customer customer = this.modelMapper.map(customerDto, Customer.class);
		this.customerRepository.save(customer);
		this.potentialCustomerService.deletePotentialCustomer(customerDto.getCustomerId());
		ForexCardDTO forexCard = this.forexCardService.generateForexCardDetails();
		
		
	}
	
	
	
}
