package com.forex.uid.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.forex.uid.DTO.PancardDTO;
import com.forex.uid.exception.PancardException;
import com.forex.uid.service.PancardService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PancardController {
	@Autowired
	PancardService pancardService;
	
	@GetMapping("pancard/pancard-verification/{pancard}")
	public ResponseEntity<String> verifyPanCard(@PathVariable("pancard") String pancard) throws PancardException{
		this.pancardService.verifyPancard(pancard);
		return ResponseEntity.ok("Pancard Verified");
	}
	
	@GetMapping("pancard/linked-address")
	public ResponseEntity<String> getLinkedAddress(@RequestBody PancardDTO pancardDto) throws PancardException{
	String permanentAddress = 	this.pancardService.getLinkedAddress(pancardDto);
	return ResponseEntity.ok(permanentAddress);
	}

	@GetMapping("pancard/linked-adhaar-card")
	public ResponseEntity<Long> getLinkedAdhaarCard(@RequestBody PancardDTO pancardDto) throws PancardException{
		Long adhaarNumber = this.pancardService.getLinkedAdhaarCard(pancardDto);
		return ResponseEntity.ok(adhaarNumber);
	}
	
	
}
