package com.lotte.emp.model.dao;

import java.sql.SQLException;

import com.lotte.emp.model.dto.EmpDTO;

public interface EmpDAO {

	//check login user id && name
	public EmpDTO userLogin(int id, String pw) throws SQLException;
	
}
