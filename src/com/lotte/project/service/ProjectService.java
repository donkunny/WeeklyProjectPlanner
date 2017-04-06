package com.lotte.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.exception.NotExistException;
import com.lotte.project.model.dto.ProjectDTO;

public interface ProjectService {
	public ArrayList<ProjectDTO> listAllProjects() throws SQLException, NotExistException;
	
	public ArrayList<SuperDTO> mplistProgress() throws SQLException, NotExistException;
	public JSONObject mpdJsonProgress() throws SQLException, NotExistException;
	public JSONObject mpJsonProgress() throws SQLException, NotExistException;
	
	public ArrayList<SuperDTO> mplistComplete() throws SQLException, NotExistException;
	public JSONObject mpJsonComplete() throws SQLException, NotExistException;
	
	public ArrayList<SuperDTO> splistProgress() throws SQLException, NotExistException;
	public JSONObject spdJsonProgress() throws SQLException, NotExistException;
	public JSONObject spJsonProgress() throws SQLException, NotExistException;
	
	public ArrayList<SuperDTO> splistComplete() throws SQLException, NotExistException;
	public JSONObject spJsonComplete() throws SQLException, NotExistException;
	
	public ArrayList<SuperDTO> teamListProgress() throws SQLException, NotExistException;
	public ArrayList<SuperDTO> teamListComplete() throws SQLException, NotExistException;
	public JSONObject teamJsonProgress() throws SQLException, NotExistException;
	public JSONObject teamJsonComplete() throws SQLException, NotExistException;
	
	
	public ArrayList<SuperDTO> listProgressingPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjManagers(int eIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressingPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
	public ArrayList<SuperDTO> listProgressedPrjDtlManagers(int eIndex, int pIndex) throws SQLException;
}
