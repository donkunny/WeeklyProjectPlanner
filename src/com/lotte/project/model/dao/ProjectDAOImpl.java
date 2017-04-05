package com.lotte.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lotte.emp.model.dto.SuperDTO;
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
	@Override //2-1. 업무 테이블 당 제목 출력 (진행중 목록)
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO tmp = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select p.pName, e2.eName, e2.eIndex, p.pIndex, pt.ptIndex"
					+ " from Employee e1, Employee e2, Project p, ProjectTeam pt"
					+ " where e1.eIndex = ? and e1.eIndex = pt.eIndex and pt.pIndex = p.pIndex and p.eIndex = e2.eIndex and p.pProgress < 100");
			pstmt.setInt(1, eIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while(rset.next()){
				tmp = new SuperDTO();
				tmp.setpName(rset.getString(1));
				tmp.seteName(rset.getString(2));
				tmp.seteIndex(rset.getInt(3));
				tmp.setpIndex(rset.getInt(4));
				tmp.setPtIndex(rset.getInt(5));
				list.add(tmp);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	@Override //2-5. 업무 테이블 당 제목 출력 (완료 목록)
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select p.pName, e2.eName,"
					+ "e2.eIndex, p.pIndex, pt.ptIndex"
					+ " from Employee e1, Employee e2, Project p, ProjectTeam pt"
					+ " where e1.eIndex = ? and e1.eIndex = pt.eIndex and pt.pIndex = p.pIndex and p.eIndex = e2.eIndex and p.pProgress = 100");
			pstmt.setInt(1, eIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while(rset.next()){
				SuperDTO tmp = new SuperDTO();
				tmp.setpName(rset.getString(1));
				tmp.seteName(rset.getString(2));
				tmp.seteIndex(rset.getInt(3));
				tmp.setpIndex(rset.getInt(4));
				tmp.setPtIndex(rset.getInt(5));
				list.add(tmp);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	@Override //2-1. 업무 테이블의 세부 업무 출력 (진행중 목록)
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select d.dPart, pd.pdName, e.eName, "
					+ "pd.pdStartDate, pd.pdEndDate, pd.pdProgress,"
					+ "d.dIndex, pd.pdIndex"
					+ " from Employee e, Department d, ProjectDetail pd, Project p"
					+ " where e.eIndex = ? and e.dIndex = d.dIndex and e.eIndex = pd.eIndex and pd.pdProgress < 100 and p.pIndex = ? and pd.pIndex = p.pIndex");
			pstmt.setInt(1, eIndex);
			pstmt.setInt(2, pIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while(rset.next()){
				SuperDTO tmp = new SuperDTO();
				tmp.setdPart(rset.getString(1));
				tmp.setPdName(rset.getString(2));
				tmp.seteName(rset.getString(3));
				tmp.setPdStartDate(rset.getDate(4));
				tmp.setPdEndDate(rset.getDate(5));
				tmp.setPdProgress(rset.getInt(6));
				tmp.setdIndex(rset.getInt(7));
				tmp.setPdIndex(rset.getInt(8));
				list.add(tmp);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	@Override //2-5. 업무 테이블의 세부 업무 출력 (완료 목록)
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select d.dPart, pd.pdName, e.eName, "
					+ "pd.pdStartDate, pd.pdEndDate, pd.pdProgress,"
					+ "d.dIndex, pd.pdIndex"
					+ " from Employee e, Department d, ProjectDetail pd, Project p"
					+ " where e.eIndex = ? and e.dIndex = d.dIndex and e.eIndex = pd.eIndex and pd.pdProgress = 100 and p.pIndex = ? and pd.pIndex = p.pIndex");
			pstmt.setInt(1, eIndex);
			pstmt.setInt(2, pIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while(rset.next()){
				SuperDTO tmp = new SuperDTO();
				tmp.setdPart(rset.getString(1));
				tmp.setPdName(rset.getString(2));
				tmp.seteName(rset.getString(3));
				tmp.setPdStartDate(rset.getDate(4));
				tmp.setPdEndDate(rset.getDate(5));
				tmp.setPdProgress(rset.getInt(6));
				tmp.setdIndex(rset.getInt(7));
				tmp.setPdIndex(rset.getInt(8));
				list.add(tmp);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
