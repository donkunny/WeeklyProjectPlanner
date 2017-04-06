package com.lotte.project.service;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.exception.NotExistException;
import com.lotte.project.model.dao.ProjectDAO;
import com.lotte.project.model.dao.ProjectDAOImpl;
import com.lotte.project.model.dto.PrjDetailDTO;
import com.lotte.project.model.dto.ProjectDTO;

public class ProjectServiceImpl implements ProjectService {

	private static ProjectService projectService = new ProjectServiceImpl();

	private ProjectServiceImpl() {
	}

	public static ProjectService getProjectService() {
		return projectService;
	}

	ProjectDAO projectDAO = ProjectDAOImpl.getProjectDAO();

	@Override
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException, NotExistException {
		ArrayList<ProjectDTO> dao = projectDAO.listAllProjects();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}

	// 진행 중인 개인 작업을 화면에 테이블로 출력
	@Override
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException {
		ArrayList<SuperDTO> dao = projectDAO.listProgressingPrjManagers(eIndex);
		return dao;
	}

	@Override
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException {
		ArrayList<SuperDTO> dao = projectDAO.listProgressedPrjManagers(eIndex);
		return dao;
	}

	@Override
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException {
		ArrayList<SuperDTO> dao = projectDAO.listProgressingPrjDtlManagers(eIndex, pIndex);
		return dao;
	}

	@Override
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException {
		ArrayList<SuperDTO> dao = projectDAO.listProgressedPrjDtlManagers(eIndex, pIndex);
		return dao;
	}

	@Override
	public ArrayList<SuperDTO> mplistProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.mplistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}

	@Override
	public JSONObject mpdJsonProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.mpdlistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pdJsonMake(dao);
	}

	@Override
	public JSONObject mpJsonProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.mplistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pJsonMake(dao);
	}

	@Override
	public ArrayList<SuperDTO> mplistComplete() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.mplistComplete();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}
	@Override
	public boolean insertDetailProject(PrjDetailDTO dto) throws SQLException {
		return projectDAO.insertDetailProject(dto);
	}
	@Override
	public String selectDpartbyDIndex(int dIndex) throws SQLException {
		return projectDAO.selectDpartbyDIndex(dIndex);
	}
	@Override
	public int selectPIndexbyPdIndex(int pdIndex) throws SQLException {
		return projectDAO.selectPIndexbyPdIndex(pdIndex);
	}
	@Override
	public boolean updateDetailProject(PrjDetailDTO dto) throws SQLException {
		return projectDAO.updateDetailProject(dto);
	}

	@Override
	public JSONObject mpJsonComplete() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.mplistComplete();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pJsonMake(dao);
	}

	@Override
	public ArrayList<SuperDTO> splistProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.splistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}

	@Override
	public JSONObject spdJsonProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.spdlistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pdJsonMake(dao);
	}

	@Override
	public JSONObject spJsonProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.splistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pJsonMake(dao);
	}

	@Override
	public ArrayList<SuperDTO> splistComplete() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.splistComplete();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}
	@Override
	public ArrayList<SuperDTO> listProjectManagement(int eIndex) throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.listProjectManagement(eIndex);
		if(dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}
	@Override
	public boolean deleteProject(int pIndex) throws SQLException, NotExistException {
		boolean dao = projectDAO.deleteProject(pIndex);
		return dao;
	}
	@Override
	public boolean updateProject(String pName, double pProgress, Date pStartDate, Date pEndDate,int pIndex, int eHeadIndex) throws SQLException, NotExistException {
		boolean dao = projectDAO.updateProject(pName,pProgress,pStartDate,pEndDate,pIndex, eHeadIndex);
		return dao;
	}
	
	@Override
	public JSONObject spJsonComplete() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.splistComplete();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pJsonMake(dao);
	}
	
	
	
	//공통 JSON Method
	public JSONObject pdJsonMake(ArrayList<SuperDTO> dao) {
		JSONObject jsonObject = new JSONObject();
		JSONArray pdArray = new JSONArray();
		JSONObject pdDto = null;
		
		for (SuperDTO sdto : dao) {
			pdDto = new JSONObject();
			pdDto.put("pdName", sdto.getPdName());
			pdDto.put("eName", sdto.geteName());
			pdDto.put("pdStartDate", sdto.getPdStartDate() + "");
			pdDto.put("pdEndDate", sdto.getPdEndDate() + "");
			pdDto.put("pdProgress", sdto.getPdProgress());
			pdDto.put("pdIndex", sdto.getPdIndex());
			pdDto.put("eIndex", sdto.geteIndex());
			pdDto.put("pIndex", sdto.getpIndex());
			pdArray.add(pdDto);
		}

		jsonObject.put("pdArray", pdArray);
		return jsonObject;		
	}
	
	public JSONObject pJsonMake(ArrayList<SuperDTO> dao) {
		JSONObject jsonObject = new JSONObject();
		JSONArray pArray = new JSONArray();
		JSONObject pDto = null;

		for (SuperDTO sdto : dao) {
			pDto = new JSONObject();
			pDto.put("eName", sdto.geteName());
			pDto.put("pName", sdto.getpName());
			pDto.put("pProgress", sdto.getpProgress());
			pDto.put("pStartDate", sdto.getpStartDate() + "");
			pDto.put("pEndDate", sdto.getpEndDate() + "");
			pDto.put("pIndex", sdto.getpIndex());
			pDto.put("dPart", sdto.getdPart());
			pArray.add(pDto);
		}

		jsonObject.put("pArray", pArray);

		return jsonObject;
	}

	@Override
	public JSONObject teamJsonProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.teamlistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pJsonMake(dao);
	}

	@Override
	public JSONObject teamJsonComplete() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.teamlistComplete();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return pJsonMake(dao);
	}

	@Override
	public ArrayList<SuperDTO> teamListProgress() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.teamlistProgress();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}

	@Override
	public ArrayList<SuperDTO> teamListComplete() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.teamlistComplete();
		if (dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}
	
	@Override
	public boolean deleteDetailProject(int pdIndex) throws SQLException {
		return projectDAO.deleteDetailProject(pdIndex);
	}

}
