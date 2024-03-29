package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.exception.ForexCardDetailsException;
import com.card.forexapp.service.ForexCardDetailsService;



@RestController
public class ForexCardDetailsController {
	
	@Autowired
	ForexCardDetailsService forexCardDetailService;
	
	@GetMapping("/forexcarddetails")
	public ResponseEntity<List<ForexCardDetails>> getAllForexCardDetails(){
		List<ForexCardDetails> forexCardDetail = this.forexCardDetailService.getAllForexCardDetails();
		return ResponseEntity.ok(forexCardDetail);
	}
	
	@PutMapping("/forexcarddetail/{forexcardid}")
	public ResponseEntity<ForexCardDetails> updateForexCardDetails(@PathVariable("forexcardid") Integer forexcardid) throws ForexCardDetailsException {
		ForexCardDetails forexCardDetail = this.forexCardDetailService.updateForexCardDetailById(forexcardid);
		return ResponseEntity.ok(forexCardDetail);
	}
	
	@DeleteMapping("forexcarddetail/{forexcardid}")
	public ResponseEntity<ForexCardDetails> deleteForexCardDetail(@PathVariable("forexcardid") Integer forexcardid) throws ForexCardDetailsException{
		ForexCardDetails forexCardDetail = this.forexCardDetailService.deleteForexCardDetailById(forexcardid);
		return ResponseEntity.ok(forexCardDetail);
	}
}
