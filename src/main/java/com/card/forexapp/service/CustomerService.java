package com.card.forexapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.dto.CustomerDTO;
import com.card.forexapp.entity.Customer;
import com.card.forexapp.repository.CustomerRepository;



@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void submitCustomerDetails(CustomerDTO customerDto) {
		Customer customer = this.modelMapper.map(customerDto, Customer.class);
		this.customerRepository.save(customer);
	}
	
	

}
