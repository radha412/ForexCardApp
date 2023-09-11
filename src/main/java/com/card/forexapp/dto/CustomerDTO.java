package com.card.forexapp.dto;

public class CustomerDTO {
	private Long customerId;
	private String phoneNumber;
	private String email;
	CustomerDTO(){
		
	}
	
	CustomerDTO(Long customerId){
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
