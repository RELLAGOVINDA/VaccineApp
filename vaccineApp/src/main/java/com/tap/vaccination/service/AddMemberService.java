package com.tap.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccination.controller.LoginController;
import com.tap.vaccination.dao.AddMemberDAO;
import com.tap.vaccination.entity.MemberTableEntity;

@Component
public class AddMemberService {
	
	private AddMemberDAO addMemberDAO;
	
	@Autowired
	public AddMemberService(AddMemberDAO addMemberDAO) {
		this.addMemberDAO = addMemberDAO;
	}
	
	public boolean validateMemberDetails(String name,String gender,String dob,String idProof,
						String idNumber,String vaccineType,int dose) {
		boolean isValid = false;
		if(name.isEmpty()||name.isBlank()||name == null)
			return isValid;
		if(gender.isEmpty()||gender.isBlank()||gender == null)
			return isValid;
		if(dob.isEmpty()||dob.isBlank()||dob == null)
			return isValid;
		if(idProof.isEmpty()||idProof.isBlank()||idProof == null)
			return isValid;
		if(idNumber.isEmpty()||idNumber.isBlank()||idNumber == null)
			return isValid;
		if(vaccineType.isEmpty()||vaccineType.isBlank()||vaccineType == null)
			return isValid;
		
		if(dose <=  0)
			return isValid;
		
		isValid = true;
		return isValid;
	}
	
	
	public boolean saveMemberEntity(String name,String gender,String dob,String idProof,
			   			String idNumber,String vaccineType,int dose) throws Exception{
		boolean isDataSave = false;
		MemberTableEntity entity = new MemberTableEntity(name, gender,dob, idProof, idNumber, vaccineType, dose,LoginController.email);
		
		if(addMemberDAO.getMemberCountByEmail(LoginController.email)<4) {
			if(addMemberDAO.saveMemberEntity(entity)) {
				addMemberDAO.updateMemberCountByEmail(entity.getUserEmail(),1);
				isDataSave = true;
				return isDataSave;
			}
		}else {
			throw new Exception("One user can store 4 members only");
		}
		
		return isDataSave;
	}
	
	
	public List<MemberTableEntity> getAll(){
		System.out.println("invoked getAll()  in sevice class");
		return addMemberDAO.getAll(LoginController.email);
	}
	
	public MemberTableEntity getMemberEntityByIdProofNumber(String idProofNumber) {
		return addMemberDAO.getMemberEntityByIdProofNumber(idProofNumber);
	}
	
	
	public boolean updateMemberEntity(int id,String name, String gender,String dob,String idProof,
									String idNumber,String vaccineType, int dose) {
		MemberTableEntity entity = new MemberTableEntity(id,name, gender, dob, idProof, idNumber, vaccineType, dose, LoginController.email);
		return addMemberDAO.updateMemberEntity(entity);
	}
	
	public boolean deleteMemberEntityByIdNumber(String idProofNumber) {
		boolean isUpdate = false;
		if(addMemberDAO.deleteMemberEntityByIdNumber(idProofNumber)== 1) {
			isUpdate = addMemberDAO.updateMemberCountByEmail(LoginController.email, -1);
			isUpdate = true;
			return isUpdate;
		}
		
		return  isUpdate;
	}
	
	
}
