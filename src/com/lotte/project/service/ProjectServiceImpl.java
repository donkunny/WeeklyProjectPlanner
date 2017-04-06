package com.lotte.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.exception.NotExistException;
import com.lotte.project.model.dao.ProjectDAO;
import com.lotte.project.model.dao.ProjectDAOImpl;
import com.lotte.project.model.dto.PrjDetailDTO;
import com.lotte.project.model.dto.ProjectDTO;

public class ProjectServiceImpl implements ProjectService{
	
	private static ProjectService projectService = new ProjectServiceImpl();
	private ProjectServiceImpl(){}
	public static ProjectService getProjectService(){
		return projectService;
	}

	ProjectDAO projectDAO = ProjectDAOImpl.getProjectDAO();
	
	@Override
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException, NotExistException {
		ArrayList<ProjectDTO> dao = projectDAO.listAllProjects();
		if(dao == null)
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
	public ArrayList<SuperDTO> mlistAllProjects() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.mlistAllProjects();
		if(dao == null)
			throw new NotExistException("값이 존재하지 않습니다.");
		return dao;
	}
	@Override
	public ArrayList<SuperDTO> slistAllProjects() throws SQLException, NotExistException {
		ArrayList<SuperDTO> dao = projectDAO.slistAllProjects();
		if(dao == null)
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
}
