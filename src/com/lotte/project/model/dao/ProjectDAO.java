package com.lotte.project.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectDAO {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjManagers() throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjManagers() throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers() throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers() throws SQLException;
}
