package com.forex.uid.DTO;

public class PassportDTO {
	private Integer passportId;
	private String passportNumber;

	public PassportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassportDTO(Integer passportId, String passportNumber) {
		super();
		this.passportId = passportId;
		this.passportNumber = passportNumber;
	}

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}
}
