package com.lotte.project.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.project.model.dto.PrjDetailDTO;
import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectDAO {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException;
	
	public ArrayList<SuperDTO> mplistProgress() throws SQLException;
	public ArrayList<SuperDTO> mpdlistProgress() throws SQLException;
	
	public ArrayList<SuperDTO> mplistComplete() throws SQLException;
	
	public ArrayList<SuperDTO> splistProgress() throws SQLException;
	public ArrayList<SuperDTO> spdlistProgress() throws SQLException;
	
	public ArrayList<SuperDTO> splistComplete() throws SQLException;
	
	public ArrayList<SuperDTO> teamlistProgress() throws SQLException;
	public ArrayList<SuperDTO> teamlistComplete() throws SQLException;
	
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
	public boolean insertDetailProject(PrjDetailDTO dto) throws SQLException;
	public String selectDpartbyDIndex(int dIndex) throws SQLException;
	public int selectPIndexbyPdIndex(int pdIndex) throws SQLException;
	public boolean updateDetailProject(PrjDetailDTO dto) throws SQLException;
}
