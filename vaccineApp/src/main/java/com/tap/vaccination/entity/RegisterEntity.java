package com.tap.vaccination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Register")
@Entity
public class RegisterEntity {
	@Id
	@Column(name="ID")
	int id;
	
	@Column(name="USER_NAME")
	String userName;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="MOBILE")
	String mobileNumber;
	
	@Column(name="GENDER")
	String gender;
	
	@Column(name="DOB")
	String dob;
	
	@Column(name="PASSWORD")
	String password;

	@Column(name="LOGIN_ATTEMPTS")
	int loginAttempts;
	
	@Column(name="MEMBER_COUNT")
	int memberCount;
	
	
	
	public RegisterEntity() {
	}
	
	
	public RegisterEntity(int id, String userName, String email, String mobileNumber, String gender, String dob,
			String password) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dob = dob;
		this.password = password;
	}

	public RegisterEntity(String userName, String email, String mobileNumber, String gender, String dob,
			String password) {
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dob = dob;
		this.password = password;
	}
	
	
	

	public int getMemberCount() {
		return memberCount;
	}


	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}


	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
