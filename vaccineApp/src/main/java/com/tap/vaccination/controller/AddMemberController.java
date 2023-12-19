package com.tap.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccination.entity.MemberTableEntity;
import com.tap.vaccination.service.AddMemberService;

@Controller
public class AddMemberController {
	
	private AddMemberService addMemberService;
	
	@Autowired
	public AddMemberController(AddMemberService addMemberService) {
		this.addMemberService = addMemberService;
	}

	

	@RequestMapping("/getMemberPage") 
	public String addMemberPage() {
		return "/WEB-INF/addmember.jsp";
	}
	
	
	@RequestMapping("/savemember") 
	public String saveMember(@RequestParam String name,@RequestParam String gender,
							@RequestParam String dob,@RequestParam String idProof,
							@RequestParam String idNumber,@RequestParam String vaccineType,@RequestParam int dose,Model model) {
		System.out.println("invoked saveMember() in AddMemberController class");
		if(addMemberService.validateMemberDetails(name, gender, dob, idProof, idNumber, vaccineType, dose)) {
			try {
				if(addMemberService.saveMemberEntity(name, gender, dob, idProof, idNumber, vaccineType, dose)) 
					model.addAttribute("save", "member details successfully saved in database");
				else 
					model.addAttribute("save", "something went wrong try again");
			} catch (Exception e) {
				model.addAttribute("save", e.getMessage());
			}
		}else 
			model.addAttribute("save", "Provide valid information");
		
		return "/WEB-INF/addmember.jsp";
	}
	
	@RequestMapping("/getRegistermembers")
	public String getRegisterMembers(Model model) {
		System.out.println("invoked getRegisterMembers() in controller class");
		List<MemberTableEntity> members = addMemberService.getAll();
		if(members != null)
			model.addAttribute("members",members );
		else
			model.addAttribute("save","no such members" );
		return "/WEB-INF/addmember.jsp";
	}
	
	@RequestMapping("/editMemberDetails/{idProofNumber}")
	public String editMemberDetails(@PathVariable String idProofNumber,Model model) {
		MemberTableEntity entity = addMemberService.getMemberEntityByIdProofNumber(idProofNumber);
		if(entity != null) {
			model.addAttribute("id", entity.getMemberId());
			model.addAttribute("name", entity.getMemberName());
			model.addAttribute("gender", entity.getGender());
			model.addAttribute("dob", entity.getDob());
			model.addAttribute("idProof", entity.getIdProof());
			model.addAttribute("idNumber", entity.getIdProofNumber());
			model.addAttribute("vaccineType", entity.getVaccineType());
			model.addAttribute("dose", entity.getDose());
		}
		return "/WEB-INF/edit.jsp";
	}
	
	@RequestMapping("/updateMemberDetails")
	public String updateMemberdetails(@RequestParam int id,@RequestParam String name,@RequestParam String gender,
									@RequestParam String dob,
									@RequestParam String idProof,@RequestParam String idNumber,
									@RequestParam String vaccineType,@RequestParam int dose,Model model) {
		System.out.println("invoked updateMemberdetails() in controller class");
		boolean isUpdate = addMemberService.updateMemberEntity(id,name, gender, dob, idProof, idNumber, vaccineType, dose);
		if(isUpdate) {
			model.addAttribute("update", "member details successfully updated");
		} else {
			model.addAttribute("update", "something went wrong try again");
		}
		return"/WEB-INF/edit.jsp";
	}
	
	@RequestMapping("/deleteMemberDetails/{idProofNumber}")
	public String deleteMember(@PathVariable String idProofNumber) {
		addMemberService.deleteMemberEntityByIdNumber(idProofNumber);
		return "redirect:/getRegistermembers";
	}
	
	
}
