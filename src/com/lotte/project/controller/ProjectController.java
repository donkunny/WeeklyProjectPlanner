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
		if(command.equals("listAll")){
			listAllProjects(request, response);
		}
	}
	
	// 모든 프로젝트 리스트를 화면에 출력
	public void listAllProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = ""; 	// 에러 메시지 화면
		try {
			request.setAttribute("projectAll", service.listAllProjects());
			url = "view/projectList.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}