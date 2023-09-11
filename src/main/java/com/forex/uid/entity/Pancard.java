package com.forex.uid.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pancard {
	@Id
	private String uniqueId;
	
	private String pancardNumber;
	
	private Long adhaarNumber;
	
	private String name;
	
	private LocalDate dateOfBirth;
	
	private Character gender;
	
	private String phone;
	
	private String email;
	
	private Integer cibilScore;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public Pancard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pancard(String uniqueId, String pancardNumber, Long adhaarNumber, String name, LocalDate dateOfBirth, Character gender,
			String phone, String email, Address address, Integer cibilScore) {
		super();
		this.uniqueId = uniqueId;
		this.pancardNumber = pancardNumber;
		this.adhaarNumber = adhaarNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.cibilScore = cibilScore;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Long getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(Long adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}
	
	public Integer getCibilScore() {
		return this.cibilScore;
	}
	public void setCibilScore(Integer cibilScore) {
		this.cibilScore = cibilScore;
	}
	
}
