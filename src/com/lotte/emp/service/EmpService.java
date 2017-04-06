package com.lotte.emp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.EmpDTO;
import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.exception.NotExistException;

public interface EmpService {
	public EmpDTO userLogin(int id, String pw)  throws SQLException, NotExistException;
	public ArrayList<SuperDTO> userList() throws SQLException;
	public ArrayList<SuperDTO> memberList(int pIndex) throws SQLException;
	public boolean insertTeamMember(int eIndex, int pIndex) throws SQLException;
}
