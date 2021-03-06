package neu.edu.controller.person;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import neu.edu.controller.user.UserModel;


public class PersonModel {
	
	private Integer personId;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	

	public PersonModel() {
		// TODO Auto-generated constructor stub
	}
	public PersonModel(String conpanyName) {
		// TODO Auto-generated constructor stub
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
