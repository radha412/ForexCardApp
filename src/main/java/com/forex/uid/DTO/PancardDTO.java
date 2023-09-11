package com.forex.uid.DTO;

public class PancardDTO {
	private String pancardNumber;
	
	PancardDTO(){
		
	}
	
	PancardDTO(String pancardNumber){
		this.pancardNumber = pancardNumber;
	}
	
	public String getPanCardNumber() {
		return this.pancardNumber;
	}
	
	public void setPanCardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}
}
