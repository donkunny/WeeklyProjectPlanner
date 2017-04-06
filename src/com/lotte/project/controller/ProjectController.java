package com.lotte.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lotte.emp.service.EmpService;
import com.lotte.emp.service.EmpServiceImpl;
import com.lotte.project.service.ProjectService;
import com.lotte.project.service.ProjectServiceImpl;

public class ProjectController extends HttpServlet{
	
	// service 객체 주입
	ProjectService service = ProjectServiceImpl.getProjectService();
	EmpService eService = EmpServiceImpl.getEmpService();
			
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		String path = "login.jsp";
		
		if("mlistAll".equals(command)){
			mlistAll(request, response);			
		} else if("projectTaemManagement".equals(command)) {
			projectTeamManagement(request, response);
		} else if("updateProject".equals(command)) {			
			updateProject(request, response);
		} else if("deleteProject".equals(command)) {			
			deleteProject(request, response);
		} else if("".equals(command)) {			
			
		}
	}
	

	// 개인 프로젝트 테이블을 화면에 출력
	public void mlistAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		try {
			request.setAttribute("mlistAll", service.mlistAllProjects());
			url = "view/table/management/finishChartProjectTeam.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public String listAllProjects(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
		
	}

	private void projectTeamManagement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eIndex = Integer.parseInt(request.getParameter("eIndex"));
		String url = "view/error/listError.jsp"; // 에러 창으로 이동
		
		try {
			request.setAttribute("pjtList", service.listProjectManagement(eIndex));
			url ="view/table/tableProjectTeam.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pIndex = Integer.parseInt(request.getParameter("pIndex"));
		
		try {
			service.deleteProject(pIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date pStartDate = null;
		Date pEndDate = null;
		
		String pName = request.getParameter("pName");
		double pProgress = Double.parseDouble(request.getParameter("pProgress"));
		int pIndex = Integer.parseInt(request.getParameter("pIndex"));
		int eHeadIndex = Integer.parseInt(request.getParameter("eHeadIndex"));
		
	      //java.util.Date utilDate = new java.util.Date();
	      //Date pdWriteDate = new Date(utilDate.getTime());
	    try {
	         java.util.Date pdStartDate_u = formatter.parse(request.getParameter("pStartDate"));
	         java.util.Date pdEndDate_u = formatter.parse(request.getParameter("pEndDate"));
	         pStartDate = new Date(pdStartDate_u.getTime());
	         pEndDate = new Date(pdEndDate_u.getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println(pStartDate);
		try {
			service.updateProject(pName, pProgress, pStartDate, pEndDate, pIndex, eHeadIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}