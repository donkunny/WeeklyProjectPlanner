package com.lotte.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.exception.NotExistException;
import com.lotte.project.model.dao.ProjectDAO;
import com.lotte.project.model.dao.ProjectDAOImpl;
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
	
}
