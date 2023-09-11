package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.repository.ForexCardRepository;



@Service
public class ForexCardService {
	
	@Autowired
	ForexCardRepository forexCardRepo;

	public  List<ForexCard> getAllTranscation() {
		// TODO Auto-generated method stub
		return this.forexCardRepo.findAll();
		
	}
	

	public ForexCard getForexCardByNumber(Long forexCardNumber) {
		return this.forexCardRepo.findByForexCardNumber(forexCardNumber);
	}


	public void createForexCard(ForexCard forexCard) {
		this.forexCardRepo.save(forexCard);
		
	}

	

	
	
	

}
