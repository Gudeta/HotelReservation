package mum.myproject.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {
	@Id @GeneratedValue
	Long id;

	@Size(min=2, max=30)
	@NotEmpty(message="no empty field accepted")
	String fName;
	@NotEmpty(message="no empty field accepted")
	String lName;
	@NotEmpty(message="no empty field accepted")
	@Email
	String email;
	@NotEmpty(message="You must enter your phone number. ")
	String PhoneNumber;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
}
