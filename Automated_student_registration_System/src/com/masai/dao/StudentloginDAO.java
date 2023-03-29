package com.masai.dao;

import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface StudentloginDAO {
	public void login(String email, String password) 
			throws SomethingWentWrongException, NoRecordFoundException;
	public void logout();
}
