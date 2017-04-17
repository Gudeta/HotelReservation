package mum.myproject.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long staffId;
	@NotEmpty(message="no empty field accpted")
	String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String staffFirstName;
	@NotEmpty(message="no empty field accpted")
	
	private String staffLastName;
	@NotEmpty(message="no empty field accpted")
	
	private String staffSsn;
	@NotEmpty(message="no empty field accpted")
	
	private String staffEmail;
	@NotEmpty(message="no empty field accpted")
	
	private String staffPhoneNumber;
	@NotEmpty(message="no empty field accpted")
	
	private String staffGender;
	@NotEmpty(message="no empty field accpted")
	
	private String staffUserName;
	@NotEmpty(message="no empty field accpted")
	
	private String staffPassword;
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public String getStaffFirstName() {
		return staffFirstName;
	}
	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}
	public String getStaffLastName() {
		return staffLastName;
	}
	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}
	public String getStaffSsn() {
		return staffSsn;
	}
	public void setStaffSsn(String staffSsn) {
		this.staffSsn = staffSsn;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}
	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}
	public String getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffUserName() {
		return staffUserName;
	}
	public void setStaffUserName(String staffUserName) {
		this.staffUserName = staffUserName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	
}
