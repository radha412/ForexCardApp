package com.card.forexapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.dto.OTPDto;
import com.card.forexapp.dto.PotentialCustomerDTO;
import com.card.forexapp.entity.PotentialCustomers;
import com.card.forexapp.exception.EmailVerificationException;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.repository.PotentialCustomerRepository;

import jakarta.mail.MessagingException;

@Service
public class PotentialCustomersService {
	
	@Autowired
	PotentialCustomerRepository potentialCustomerRepo;
	
	@Autowired
	OTPService optService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<PotentialCustomers> getAllPotencialCustomers() {
		return this.potentialCustomerRepo.findAll();
	}

	public void generateOtpForEmailVerification(PotentialCustomerDTO potnentialCustomer) throws EmailVerificationException {
		String userEmail = potnentialCustomer.getEmail();
		Integer generatedOTP  = optService.generateOTP(userEmail);
		String message = generatedOTP + " is your OTP for email verification. Don't share your otp with anyone. This Otp is valid only for 3 mninutes";
		try {
		emailService.sendOtpMessage(userEmail, "OTP For Email Verification", message);
		}
		catch(MessagingException exception) {
			throw new EmailVerificationException("Email Cannot Be Sent");
		}
	}

	public Boolean verifyOtpforEmailVerification(OTPDto otpDto) throws EmailVerificationException{
		String clientEmail = otpDto.getCustomerEmail();
		Integer clientOTP = otpDto.getOtp();
		
		Boolean isVerified = this.optService.validateOTP(clientEmail, clientOTP);
		
		if(! isVerified)
		{
			throw new EmailVerificationException("You have entered wrong OTP");
		}
		return true;
	}
	
	public void setPassword(PotentialCustomerDTO potentialCustomerDto) {
		PotentialCustomers potentialCustomer = modelMapper.map(potentialCustomerDto, PotentialCustomers.class);
		this.potentialCustomerRepo.save(potentialCustomer);
	}

	public void savePotentialCustomerDetails(PotentialCustomerDTO potentialCustomerDto) {
		//saving the data of potential customer data
		PotentialCustomers potentialCustomer = this.modelMapper.map(potentialCustomerDto, PotentialCustomers.class);
		this.potentialCustomerRepo.save(potentialCustomer);
	}

	public Boolean verifyLoginCredentials(PotentialCustomerDTO potentialCustomerDto) throws PotentialCustomerException {
		Optional<PotentialCustomers> potentialCustomerOpt = this.potentialCustomerRepo.findByEmail(potentialCustomerDto.getEmail());
		
		PotentialCustomers potentialCustomer = potentialCustomerOpt.get();
		String email = potentialCustomer.getEmail();
		String password = potentialCustomer.getPassword();
		
		if(!email.equals(potentialCustomerDto.getEmail())) {
			throw new PotentialCustomerException("You have entered a wrong email");
		}
		
		if(!password.equals(potentialCustomerDto.getPassword())){
			throw new PotentialCustomerException("You have entered a wrong password");
		}
		
		return true;
	}
}
