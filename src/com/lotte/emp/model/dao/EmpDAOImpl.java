package com.lotte.emp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.EmpDTO;
import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.util.DBUtil;

public class EmpDAOImpl implements EmpDAO{

	private static EmpDAO empDAO = new EmpDAOImpl();
	private EmpDAOImpl(){}
	public static EmpDAO getEmpDAO(){
		return empDAO;
	}
	
	@Override
	public EmpDTO userLogin(int id, String pw) throws SQLException {
		EmpDTO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from employee where eNum=? and ePassword=?");		
			pstmt.setInt(1, id);
			pstmt.setString(2, pw);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new EmpDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), rset.getDate(5), rset.getString(6), rset.getString(7), rset.getInt(8));
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	@Override
	public ArrayList<SuperDTO> userList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select e.eIndex, e.eNum, e.eName, e.ePosition, d.dName, d.dPart from Employee e, Department d");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while(rset.next()){
				SuperDTO tmp = new SuperDTO();
				tmp.seteIndex(rset.getInt(1));
				tmp.seteNum(rset.getInt(2));
				tmp.seteName(rset.getString(3));
				tmp.setePosition(rset.getString(4));
				tmp.setdName(rset.getString(5));
				tmp.setdPart(rset.getString(6));
				list.add(tmp);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	@Override
	public String selectDPartbyDIndex(int dIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String dName = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select e.eIndex, e.eNum, e.eName, e.ePosition, d.dName, d.dPart from Employee e, Department d");
			rset = pstmt.executeQuery();
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return null;
    
	public boolean userCheck(int eIndex) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select count(eIndex) from Employee e where eIndex = ?");
			pstmt.setInt(1, eIndex);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				flag = true;
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return flag;
	}
}
