package mum.myproject.Domain;

import javax.persistence.Embeddable;


import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Location {
	@NotEmpty(message="no empty field accepted")
	private int houseNumber;
	@NotEmpty(message="no empty field accepted")
	private String street;
	@NotEmpty(message="no empty field accepted")
	private String city;
	@NotEmpty(message="no empty field accepted")
	private String state;
	@NotEmpty(message="no empty field accepted")
	private String zipcode;
	
	
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
