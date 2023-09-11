package com.forex.uid.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.forex.uid.entity.Address;
import org.springframework.stereotype.Service;
import com.forex.uid.DTO.PancardDTO;
import com.forex.uid.entity.Pancard;
import com.forex.uid.exception.PancardException;
import com.forex.uid.repository.PancardRepository;

@Service
public class PancardService {
	@Autowired
	PancardRepository pancardRepo;
	
	public void verifyPancard(String pancard)throws PancardException{
		Pancard result = this.pancardRepo.findBypancardNumber(pancard);
		if(result == null ||  !result.getPancardNumber().equals(pancard) ){
			throw new PancardException("You have entered wrong pancard number");
		}
		Integer cibilScoreEligibility = this.cibilScoreEligibility(pancard);
		if(cibilScoreEligibility >=2) {
			System.out.println("You are eligibile for getting forex card");
		}
	}

	public String getLinkedAddress(PancardDTO pancardDto) throws PancardException {
		Pancard result = this.pancardRepo.findBypancardNumber(pancardDto.getPanCardNumber());
		this.verifyPancard(pancardDto.getPanCardNumber());
		Address address = result.getAddress();
		String permanentAddress = address.getStreet() + address.getCity()  + address.getDistrict()  + address.getState();
		return permanentAddress;
		
	}

	public Long getLinkedAdhaarCard(PancardDTO pancardDto) throws PancardException{
		Pancard result = this.pancardRepo.findBypancardNumber(pancardDto.getPanCardNumber());
		this.verifyPancard(pancardDto.getPanCardNumber());
		Long adhaarNumber = result.getAdhaarNumber();
		return adhaarNumber;
	}
	
	public Integer cibilScoreEligibility(String pancard1) throws PancardException{
		//this.verifyPancard(pancardDto);
		Pancard pancard = this.pancardRepo.findBypancardNumber(pancard1);
		Integer cibilScore = pancard.getCibilScore();
		
		if(cibilScore <= 600) {
			return 0;
		}
		else if(cibilScore >600 && cibilScore<=649) {
			return 1;
		}
		else if(cibilScore >649 && cibilScore<=699) {
			return 2;
		}
		else if(cibilScore >699 && cibilScore <=749) {
			return 3;
		}
		else {
			return 4;
		}
		
	}
}
