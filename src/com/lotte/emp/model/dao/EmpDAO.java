package com.lotte.emp.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.EmpDTO;
import com.lotte.emp.model.dto.SuperDTO;

public interface EmpDAO {

	//check login user id && name
	public EmpDTO userLogin(int id, String pw) throws SQLException;
	public ArrayList<SuperDTO> userList() throws SQLException;
	public String selectDPartbyDIndex(int dIndex) throws SQLException;
}
