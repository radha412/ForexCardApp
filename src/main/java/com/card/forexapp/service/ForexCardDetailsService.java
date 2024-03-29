package com.card.forexapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.exception.AdminException;
import com.card.forexapp.exception.ForexCardDetailsException;
import com.card.forexapp.repository.ForexCardDetailsRepository;



@Service
public class ForexCardDetailsService {
	
	@Autowired
	ForexCardDetailsRepository forexCardDetailRepo;
	
	public List<ForexCardDetails> getAllForexCardDetails(){
		return this.forexCardDetailRepo.findAll();
	}

	public ForexCardDetails createnewForexCardType(ForexCardDetails forexCardDetails) throws ForexCardDetailsException {
		String forexCardName = forexCardDetails.getForexCardName();
		System.out.println(forexCardName);
		if(forexCardDetails.getForexCardName().isEmpty())
			throw new ForexCardDetailsException("Give some name to ForexCardType . ");
		return this.forexCardDetailRepo.save(forexCardDetails);
	}

	public ForexCardDetails updateForexCardDetailById(Integer forexcardid) throws ForexCardDetailsException {
		Optional<ForexCardDetails> forexCardDetailOpt = this.forexCardDetailRepo.findById(forexcardid);
		if(!forexCardDetailOpt.isPresent())
			throw new ForexCardDetailsException("Forex Card Id does not exist!!");
		ForexCardDetails forexCardDetail = forexCardDetailOpt.get();
		
		return forexCardDetail;
	}

	public ForexCardDetails deleteForexCardDetailById(Integer forexcardid) throws ForexCardDetailsException{
		Optional<ForexCardDetails> forexCardDetailOpt = this.forexCardDetailRepo.findById(forexcardid);
		if(!forexCardDetailOpt.isPresent())
			throw new ForexCardDetailsException("Forex Card Id does not exist!!");
		ForexCardDetails forexCardDetail = forexCardDetailOpt.get();
		this.forexCardDetailRepo.deleteById(forexcardid);	
		return forexCardDetail;
	}

	public ForexCardDetails updateForexCardType(ForexCardDetails forexCardDetail ,Integer forexcardid) throws AdminException{
		return this.forexCardDetailRepo.save(forexCardDetail);
	}
	
	public ForexCardDetails getForexCardById(Integer forexCardTypeId) throws ForexCardDetailsException {
		Optional<ForexCardDetails> forexCardDetailOpt = this.forexCardDetailRepo.findById(forexCardTypeId);
		if(!forexCardDetailOpt.isPresent())
			throw new ForexCardDetailsException("Forex Card Type Not found!!");
		ForexCardDetails forexCardDetail = forexCardDetailOpt.get();
		return forexCardDetail;
		
		
	}

}
