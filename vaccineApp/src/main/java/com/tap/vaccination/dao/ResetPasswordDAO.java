package com.tap.vaccination.dao;

public interface ResetPasswordDAO {
	boolean updatePasswordByEmail(String email,String password);
}
