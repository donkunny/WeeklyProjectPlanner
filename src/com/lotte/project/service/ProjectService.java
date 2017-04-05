package com.lotte.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.exception.NotExistException;
import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectService {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException, NotExistException;
	public ArrayList<SuperDTO> mlistAllProjects() throws SQLException, NotExistException;
	public ArrayList<SuperDTO> slistAllProjects() throws SQLException, NotExistException;
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
}
