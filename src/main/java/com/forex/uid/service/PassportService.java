package com.forex.uid.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.forex.uid.DTO.PassportDTO;
import com.forex.uid.entity.Passport;
import com.forex.uid.exception.PassportException;
import com.forex.uid.repository.PassportRepository;

@Service
public class PassportService {
	@Autowired
	private PassportRepository passportRepo;
	
	public Boolean verifyPassport(String passport2) throws PassportException {
		Passport passport = this.passportRepo.findBypassportNumber(passport2).get();
		if(passport == null || !passport.getPassportNumber().equals(passport2))
				throw new PassportException("Passport Number Doesn't Exist");
		return passport.getPassportNumber().equals(passport2);	
	}
}
