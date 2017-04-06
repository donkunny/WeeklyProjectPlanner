package com.lotte.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.project.model.dto.PrjDetailDTO;
import com.lotte.project.model.dto.ProjectDTO;
import com.lotte.util.DBUtil;

public class ProjectDAOImpl implements ProjectDAO {
	private static ResourceBundle sqlBundle;
	static {
		sqlBundle = ResourceBundle.getBundle("com.lotte.conf/sql");
	}

	/**
	 * DAO 싱글톤 생성
	 */
	private static ProjectDAO projectDAO = new ProjectDAOImpl();

	private ProjectDAOImpl() {
	}

	public static ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	@Override
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProjectDTO> list = null;
		try {
			con = DBUtil.getConnection();
			// pstmt =
			// con.prepareStatement(sqlBundle.getString("selectAllProjects"));
			// // 에러 발생
			pstmt = con.prepareStatement("select * from project");
			rset = pstmt.executeQuery();
			list = new ArrayList<ProjectDTO>();
			while (rset.next()) {
				list.add(new ProjectDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getDouble(4),
						rset.getDate(5), rset.getDate(6), rset.getDate(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override // 2-1. 업무 테이블 당 제목 출력 (진행중 목록)
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO tmp = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select p.pName, e2.eName, e2.eIndex, p.pIndex, pt.ptIndex"
					+ " from Employee e1, Employee e2, Project p, ProjectTeam pt"
					+ " where e1.eIndex = ? and e1.eIndex = pt.eIndex and pt.pIndex = p.pIndex and p.eIndex = e2.eIndex and p.pProgress < 100"
					+ " order by p.pStartDate");
			pstmt.setInt(1, eIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				tmp = new SuperDTO();
				tmp.setpName(rset.getString(1));
				tmp.seteHeadName(rset.getString(2));
				tmp.seteIndex(rset.getInt(3));
				tmp.setpIndex(rset.getInt(4));
				tmp.setPtIndex(rset.getInt(5));
				list.add(tmp);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override // 2-5. 업무 테이블 당 제목 출력 (완료 목록)
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select p.pName, e2.eName, e2.eIndex, p.pIndex, pt.ptIndex"
					+ " from Employee e1, Employee e2, Project p, ProjectTeam pt"
					+ " where e1.eIndex = ? and e1.eIndex = pt.eIndex and pt.pIndex = p.pIndex and p.eIndex = e2.eIndex and p.pIndex in "
					+ " (select pIndex from ProjectDetail where pdProgress = 100)" + " order by p.pStartDate");
			pstmt.setInt(1, eIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				SuperDTO tmp = new SuperDTO();
				tmp.setpName(rset.getString(1));
				tmp.seteHeadName(rset.getString(2));
				tmp.seteIndex(rset.getInt(3));
				tmp.setpIndex(rset.getInt(4));
				tmp.setPtIndex(rset.getInt(5));
				list.add(tmp);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override // 2-1. 업무 테이블의 세부 업무 출력 (진행중 목록)
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"select d.dPart, pd.pdName, e.eName, " + "pd.pdStartDate, pd.pdEndDate, pd.pdProgress,"
							+ "d.dIndex, pd.pdIndex" + " from Employee e, Department d, ProjectDetail pd, Project p"
							+ " where e.eIndex = ? and e.dIndex = d.dIndex and e.eIndex = pd.eIndex and pd.pdProgress < 100 and p.pIndex = ? and pd.pIndex = p.pIndex"
							+ " order by pd.pdStartDate");
			pstmt.setInt(1, eIndex);
			pstmt.setInt(2, pIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
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
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override // 2-5. 업무 테이블의 세부 업무 출력 (완료 목록)
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"select d.dPart, pd.pdName, e.eName, " + "pd.pdStartDate, pd.pdEndDate, pd.pdProgress,"
							+ "d.dIndex, pd.pdIndex" + " from Employee e, Department d, ProjectDetail pd, Project p"
							+ " where e.eIndex = ? and e.dIndex = d.dIndex and e.eIndex = pd.eIndex and pd.pdProgress = 100 and p.pIndex = ? and pd.pIndex = p.pIndex"
							+ " order by pd.pdStartDate");
			pstmt.setInt(1, eIndex);
			pstmt.setInt(2, pIndex);
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
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
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public ArrayList<SuperDTO> mplistProgress() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			// pstmt =
			// con.prepareStatement(sqlBundle.getString("selectAllProjects"));
			// // 에러 발생
			pstmt = con.prepareStatement(
					"select p.pName, e.eName, p.pProgress, p.pStartDate, p.pEndDate, p.pIndex, e.eIndex "
							+ "from Project p, Employee e, Department d "
							+ "where p.eIndex = e.eIndex and e.dIndex = d.dIndex and d.dIndex = 2 and p.pProgress<100"
							+"order by e.eName asc, p.pstartdate asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setpName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setpProgress(rset.getDouble(3));
				sdto.setpStartDate(rset.getDate(4));
				sdto.setpEndDate(rset.getDate(5));
				sdto.setpIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public ArrayList<SuperDTO> mpdlistProgress() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select pd.pdName, e.eName, pd.pdStartDate, pd.pdEndDate, pd.pdProgress,"
					+ "pd.pdIndex, e.eIndex, p.pIndex " + "from Project p, ProjectDetail pd,Employee e, Department d "
					+ "where p.pIndex = pd.pIndex and e.eIndex = pd.eIndex and e.dIndex = d.dIndex and d.dindex = 2 and pd.pdProgress<100" 
					+"order by e.eName asc, pd.pdstartdate asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setPdName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setPdStartDate(rset.getDate(3));
				sdto.setPdEndDate(rset.getDate(4));
				sdto.setPdProgress(rset.getDouble(5));
				sdto.setPdIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				sdto.setpIndex(rset.getInt(8));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public ArrayList<SuperDTO> splistProgress() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			// pstmt =
			// con.prepareStatement(sqlBundle.getString("selectAllProjects"));
			// // 에러 발생
			pstmt = con.prepareStatement(
					"select p.pName, e.eName, p.pProgress, p.pStartDate, p.pEndDate, p.pIndex, e.eIndex "
							+ "from Project p, Employee e, Department d "
							+ "where p.eIndex = e.eIndex and e.dIndex = d.dIndex and d.dIndex = 1 and p.pProgress<100 "
							+"order by e.eName asc, p.pstartdate asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setpName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setpProgress(rset.getDouble(3));
				sdto.setpStartDate(rset.getDate(4));
				sdto.setpEndDate(rset.getDate(5));
				sdto.setpIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public ArrayList<SuperDTO> spdlistProgress() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select pd.pdName, e.eName, pd.pdStartDate, pd.pdEndDate, pd.pdProgress,"
					+ "pd.pdIndex, e.eIndex, p.pIndex " + "from Project p, ProjectDetail pd,Employee e, Department d "
					+ "where p.pIndex = pd.pIndex and e.eIndex = pd.eIndex and e.dIndex = d.dIndex and d.dindex = 1 and pd.pdProgress<100 "
					+"order by e.eName asc, pd.pdstartdate asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setPdName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setPdStartDate(rset.getDate(3));
				sdto.setPdEndDate(rset.getDate(4));
				sdto.setPdProgress(rset.getDouble(5));
				sdto.setPdIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				sdto.setpIndex(rset.getInt(8));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public ArrayList<SuperDTO> mplistComplete() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			// pstmt =
			// con.prepareStatement(sqlBundle.getString("selectAllProjects"));
			// // 에러 발생
			pstmt = con.prepareStatement(
					"select p.pName, e.eName, p.pProgress, p.pStartDate, p.pEndDate, p.pIndex, e.eIndex "
							+ "from Project p, Employee e, Department d "
							+ "where p.eIndex = e.eIndex and e.dIndex = d.dIndex and d.dIndex = 2 and p.pProgress=100 "
							+"order by e.eName asc, p.pstartdate asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setpName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setpProgress(rset.getDouble(3));
				sdto.setpStartDate(rset.getDate(4));
				sdto.setpEndDate(rset.getDate(5));
				sdto.setpIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public ArrayList<SuperDTO> splistComplete() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			// pstmt =
			// con.prepareStatement(sqlBundle.getString("selectAllProjects"));
			// // 에러 발생
			pstmt = con.prepareStatement(
					"select p.pName, e.eName, p.pProgress, p.pStartDate, p.pEndDate, p.pIndex, e.eIndex "
							+ "from Project p, Employee e, Department d "
							+ "where p.eIndex = e.eIndex and e.dIndex = d.dIndex and d.dIndex = 1 and p.pProgress=100 "
							+"order by e.eName asc, p.pstartdate asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setpName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setpProgress(rset.getDouble(3));
				sdto.setpStartDate(rset.getDate(4));
				sdto.setpEndDate(rset.getDate(5));
				sdto.setpIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public ArrayList<SuperDTO> teamlistProgress() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			// pstmt =
			// con.prepareStatement(sqlBundle.getString("selectAllProjects"));
			// // 에러 발생
			pstmt = con.prepareStatement(
					"select p.pName, e.eName, p.pProgress, p.pStartDate, p.pEndDate, p.pIndex, e.eIndex, d.dPart "
							+ "from Project p, Employee e, Department d "
							+ "where p.eIndex = e.eIndex and e.dIndex = d.dIndex and p.pProgress<100 "
							+"order by e.eName asc, p.pstartdate asc, dPart asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setpName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setpProgress(rset.getDouble(3));
				sdto.setpStartDate(rset.getDate(4));
				sdto.setpEndDate(rset.getDate(5));
				sdto.setpIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				sdto.setdPart(rset.getString(8));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override

	public ArrayList<SuperDTO> teamlistComplete() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SuperDTO> list = null;
		SuperDTO sdto = null;
		try {
			con = DBUtil.getConnection();
			// pstmt =
			// con.prepareStatement(sqlBundle.getString("selectAllProjects"));
			// // 에러 발생
			pstmt = con.prepareStatement(
					"select p.pName, e.eName, p.pProgress, p.pStartDate, p.pEndDate, p.pIndex, e.eIndex, d.dPart "
							+ "from Project p, Employee e, Department d "
							+ "where p.eIndex = e.eIndex and e.dIndex = d.dIndex and p.pProgress=100 "
							+"order by e.eName asc, p.pstartdate asc, dPart asc");
			rset = pstmt.executeQuery();
			list = new ArrayList<SuperDTO>();
			while (rset.next()) {
				sdto = new SuperDTO();
				sdto.setpName(rset.getString(1));
				sdto.seteName(rset.getString(2));
				sdto.setpProgress(rset.getDouble(3));
				sdto.setpStartDate(rset.getDate(4));
				sdto.setpEndDate(rset.getDate(5));
				sdto.setpIndex(rset.getInt(6));
				sdto.seteIndex(rset.getInt(7));
				sdto.setdPart(rset.getString(8));
				list.add(sdto);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	@Override
	public boolean insertDetailProject(PrjDetailDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into ProjectDetail (pdIndex, pIndex, eIndex, pdName, pdProgress, pdStartDate, pdEndDate, pdWriteDate)" 
			+ " values(seq_pd.nextval, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, dto.getpIndex());
			pstmt.setInt(2, dto.geteIndex());
			pstmt.setString(3, dto.getPdName());
			pstmt.setDouble(4, dto.getPdProgress());
			pstmt.setDate(5, dto.getPdStartDate());
			pstmt.setDate(6, dto.getPdEndDate());
			pstmt.setDate(7, dto.getPdWriteDate());
			int result = pstmt.executeUpdate();
			if(result ==1){
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	@Override
	public String selectDpartbyDIndex(int dIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String dPart = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select dPart from department where dIndex = ? ");
			pstmt.setInt(1, dIndex);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				dPart = rset.getString(1);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return dPart;
	}

	@Override
	public int selectPIndexbyPdIndex(int pdIndex) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int pIndex = -1;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select pIndex from ProjectDetail where pdIndex = ? ");
			pstmt.setInt(1, pdIndex);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pIndex = rset.getInt(1);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return pIndex;
	}

	@Override
	public boolean updateDetailProject(PrjDetailDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update ProjectDetail set pdName = ?, pdProgress = ?, pdStartDate = ?, pdEndDate = ?,	"
					+ "pdWriteDate=? where  pdIndex = ?");
			pstmt.setString(1, dto.getPdName());
			pstmt.setDouble(2, dto.getPdProgress());
			pstmt.setDate(3, dto.getPdStartDate());
			pstmt.setDate(4, dto.getPdEndDate());
			pstmt.setDate(5,  dto.getPdWriteDate());
			pstmt.setInt(6, dto.getPdIndex());
			int result = pstmt.executeUpdate();
			if(result ==1){
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
