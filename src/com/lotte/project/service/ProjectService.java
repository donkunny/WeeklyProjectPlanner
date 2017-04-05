package com.lotte.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.exception.NotExistException;
import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectService {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException, NotExistException;
}
