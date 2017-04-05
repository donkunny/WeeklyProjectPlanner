package com.lotte.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lotte.project.model.dto.ProjectDTO;
import com.lotte.util.DBUtil;

public class ProjectDAOImpl implements ProjectDAO{
	private static ResourceBundle sqlBundle;
	static{
		sqlBundle = ResourceBundle.getBundle("com.lotte.conf/sql");
	}
	
	/**
	 * DAO 싱글톤 생성
	 */
	private static ProjectDAO projectDAO = new ProjectDAOImpl();
	private ProjectDAOImpl(){}
	public static ProjectDAO getProjectDAO(){
		return projectDAO;
	}

	
	@Override
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProjectDTO> list = null;
		try{
			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sqlBundle.getString("selectAllProjects")); 	// 에러 발생
			pstmt = con.prepareStatement("select * from project");
			rset = pstmt.executeQuery();
			list = new ArrayList<ProjectDTO>();
			while(rset.next()){
				list.add(new ProjectDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getDouble(4), rset.getDate(5), rset.getDate(6), rset.getDate(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
