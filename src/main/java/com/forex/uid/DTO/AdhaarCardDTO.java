package com.forex.uid.DTO;

public class AdhaarCardDTO {
	private String adhaarCardNumber;
	private String name;
	
	AdhaarCardDTO(){
		
	}

	public AdhaarCardDTO(String adhaarCardNumber, String name) {
		super();
		this.adhaarCardNumber = adhaarCardNumber;
		this.name = name;
	}

	public String getAdhaarCardNumber() {
		return adhaarCardNumber;
	}

	public void setAdhaarCardNumber(String adhaarCardNumber) {
		this.adhaarCardNumber = adhaarCardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
