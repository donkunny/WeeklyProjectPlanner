package com.lotte.emp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lotte.emp.model.dto.EmpDTO;
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
			pstmt = con.prepareStatement("select * from employee where eNum = ? ");		
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			if (rset.next() && rset.getString(2).equals(pw)) {
					result = new EmpDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), rset.getDate(5), rset.getString(6), rset.getString(7), rset.getInt(8));
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
}
