package com.tap.vaccination.dao;

import java.util.List;

import com.tap.vaccination.entity.MemberTableEntity;

public interface AddMemberDAO {
	boolean saveMemberEntity(MemberTableEntity memberTableEntity);
	List<MemberTableEntity> getAll(String email);
	boolean updateMemberCountByEmail(String email);
	int getMemberCountByEmail(String email);
	MemberTableEntity getMemberEntityByIdProofNumber(String idProofNumber);
	boolean updateMemberEntity(MemberTableEntity memberTableEntity);
	int deleteMemberEntityByIdNumber(String IdNumber);
}
