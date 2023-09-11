package com.forex.uid.DTO;

public class AddressDTO {
	private String Id;
	private String street;
	private String city;
	private String district;
	private String state;
	
	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDTO(String id, String street, String city, String district, String state) {
		super();
		Id = id;
		this.street = street;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
