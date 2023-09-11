package com.forex.uid.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.forex.uid.entity.Address;
import org.springframework.stereotype.Service;
import com.forex.uid.DTO.AdhaarCardDTO;
import com.forex.uid.entity.AdhaarCard;
import com.forex.uid.exception.AdhaarCardException;
import com.forex.uid.repository.AdhaarCardRepository;

@Service
public class AdhaarCardService {

	@Autowired
	private AdhaarCardRepository adhaarCardRepo;
	
	public void verifyAdhaarCard(Long adhaarNumber) throws AdhaarCardException{
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(adhaarNumber);
		if(result.isEmpty()|| !result.get().getAdhaarNumber().equals(adhaarNumber)) {
			throw new AdhaarCardException("Please Enter a valid Adhaar number");
		}		
	}
	
	public String getLinkedPancard(AdhaarCardDTO adhaarCardDto) throws AdhaarCardException {
		this.verifyAdhaarCard(Long.parseLong(adhaarCardDto.getAdhaarCardNumber()));
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(Long.parseLong(adhaarCardDto.getAdhaarCardNumber()));
		return result.get().getPancard().getPancardNumber();
	}
	
	public String getLinkedAddress(AdhaarCardDTO adhaarCardDto) throws AdhaarCardException{
		this.verifyAdhaarCard(Long.parseLong(adhaarCardDto.getAdhaarCardNumber()));
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(Long.parseLong(adhaarCardDto.getAdhaarCardNumber()));
		Address address = result.get().getAddress();
		String permanentAddress = address.getStreet() + address.getCity() + address.getDistrict() + address.getState();
		return permanentAddress;
	}

	public Boolean getAdhaarCardOwnerName(AdhaarCardDTO adhaarCardDTO) throws AdhaarCardException{
		String adhaarCard = adhaarCardDTO.getAdhaarCardNumber();
		if(adhaarCard == null) {
			throw new AdhaarCardException("You must enter the adhaar card");
		}
		this.verifyAdhaarCard(Long.parseLong(adhaarCardDTO.getAdhaarCardNumber()));
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(Long.parseLong(adhaarCardDTO.getAdhaarCardNumber()));
		
		if(result.get().getName() != adhaarCardDTO.getName()) {
			throw new AdhaarCardException("You must entered the name same as Adhaar Card");
		}
		return true;
		
	}
}
