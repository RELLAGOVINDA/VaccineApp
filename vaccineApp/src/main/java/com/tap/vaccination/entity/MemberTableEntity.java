package com.tap.vaccination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="MemberTable")
@Entity
public class MemberTableEntity {
	
	@Id
	@Column(name="MEMBER_ID")
	int memberId;
	
	@Column(name="MEMBER_NAME")
	String memberName;
	
	@Column(name="GENDER")
	String gender;
	
	
	@Column(name="DOB")
	String dob;
	
	@Column(name="ID_PROOF")
	String idProof;
	
	@Column(name="ID_PROOF_NUMBER")
	String idProofNumber;
	
	@Column(name="VACCINE_TYPE")
	String vaccineType;
	
	@Column(name="DOSE")
	int dose;
	
	@Column(name="USER_EMAIL")
	String userEmail;
	
	public MemberTableEntity() {
	}

	public MemberTableEntity(String memberName, String gender, String dob, String idProof, String idProofNumber,
			String vaccineType, int dose,String userEmail) {
		super();
		this.memberName = memberName;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNumber = idProofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.userEmail = userEmail;
	}

	public MemberTableEntity(int memberId, String memberName, String gender, String dob, String idProof,
			String idProofNumber, String vaccineType, int dose,String userEmail) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNumber = idProofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.userEmail = userEmail;
	}
	
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}

	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}
	
	
	
	
}
