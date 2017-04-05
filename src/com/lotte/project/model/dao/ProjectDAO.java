package com.lotte.project.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectDAO {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException;
}
