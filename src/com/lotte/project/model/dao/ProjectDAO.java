package com.lotte.project.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectDAO {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException;
	public ArrayList<SuperDTO> mlistAllProjects() throws SQLException;
	public ArrayList<SuperDTO> slistAllProjects() throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
}
