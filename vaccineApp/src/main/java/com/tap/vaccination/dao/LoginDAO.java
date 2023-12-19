package com.tap.vaccination.dao;

import com.tap.vaccination.entity.RegisterEntity;

public interface LoginDAO {
	RegisterEntity getRegisterEntityByEmail(String email);
	void updateRegisterEntityByEmail(String email,int loginAttempts);
	int getMemberCountByEmail(String email);
}
