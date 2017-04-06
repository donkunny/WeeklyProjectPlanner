package com.lotte.project.model.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.exception.NotExistException;
import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectDAO {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException;
	public ArrayList<SuperDTO> mlistAllProjects() throws SQLException;
	public ArrayList<SuperDTO> slistAllProjects() throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
	public ArrayList<SuperDTO> listProjectManagement(int eIndex) throws SQLException;
	public boolean deleteProject(int pIndex) throws SQLException;
	public boolean updateProject(String pName, double pProgress, Date pStartDate, Date pEndDate,int pIndex, int eHeadIndex) throws SQLException;
}
