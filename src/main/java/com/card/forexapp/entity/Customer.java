package com.card.forexapp.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private Long customerId;
	
	private String phoneNumber;
	
	private String email;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<LoadingTranscation> loadingTranscations=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PaymentTransaction> paymentTranscations =  new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private ForexCard forexCard;

	public Customer() {
		super();
	}
	
	public Customer(Long customerId, String phoneNumber, String email, List<LoadingTranscation> loadingTranscations,
			List<PaymentTransaction> paymentTranscations, ForexCard forexCard) {
		super();
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.loadingTranscations = loadingTranscations;
		this.paymentTranscations = paymentTranscations;
		this.forexCard = forexCard;
	}

	public Customer(Long customerId, List<LoadingTranscation> loadingTranscations,
			List<PaymentTransaction> paymentTranscations, ForexCard forexCard) {
		super();
		this.customerId = customerId;
		this.loadingTranscations = loadingTranscations;
		this.paymentTranscations = paymentTranscations;
		this.forexCard = forexCard;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<LoadingTranscation> getLoadingTranscations() {
		return loadingTranscations;
	}

	public void setLoadingTranscations(List<LoadingTranscation> loadingTranscations) {
		this.loadingTranscations = loadingTranscations;
	}

	public List<PaymentTransaction> getPaymentTranscations() {
		return paymentTranscations;
	}

	public void setPaymentTranscations(List<PaymentTransaction> paymentTranscations) {
		this.paymentTranscations = paymentTranscations;
	}

	public ForexCard getForexCard() {
		return forexCard;
	}

	public void setForexCard(ForexCard forexCard) {
		this.forexCard = forexCard;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
