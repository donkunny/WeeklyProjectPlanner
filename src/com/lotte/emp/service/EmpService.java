package com.lotte.emp.service;

import java.sql.SQLException;

import com.lotte.emp.model.dto.EmpDTO;
import com.lotte.exception.NotExistException;

public interface EmpService {
	public EmpDTO userLogin(int id, String pw)  throws SQLException, NotExistException;
}
