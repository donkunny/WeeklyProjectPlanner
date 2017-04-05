package com.lotte.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lotte.project.service.ProjectService;
import com.lotte.project.service.ProjectServiceImpl;

public class ProjectController extends HttpServlet{
	
	// service 객체 주입
	ProjectService service = ProjectServiceImpl.getProjectService();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		String path = "login.jsp";
		
		if("mlistAll".equals(command)){
			mlistAll(request, response);			
		} else if("".equals(command)) {			
			
		} else if("".equals(command)) {			
			
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
	
	
	//
	
	
	//
	
	
	//
}