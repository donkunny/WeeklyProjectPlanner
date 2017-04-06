package com.lotte.emp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dao.EmpDAO;
import com.lotte.emp.model.dao.EmpDAOImpl;
import com.lotte.emp.model.dto.EmpDTO;
import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.exception.NotExistException;

public class EmpServiceImpl implements EmpService{

	EmpDAO dao = EmpDAOImpl.getEmpDAO();
	
	private static EmpService empService = new EmpServiceImpl();
	private EmpServiceImpl(){}
	public static EmpService getEmpService(){
		return empService;
	}
	
	@Override
	public EmpDTO userLogin(int id, String pw) throws SQLException, NotExistException {
		return dao.userLogin(id, pw);
	}
	@Override
	public ArrayList<SuperDTO> userList() throws SQLException {
		return dao.userList();
	}
	@Override
	public boolean userCheck(int eIndex) throws SQLException {
		return dao.userCheck(eIndex);
	}

}
