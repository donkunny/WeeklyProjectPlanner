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
		
		if("mlistProgress".equals(command)){
			mlistProgress(request, response);			
		} else if("mlistComplete".equals(command)) {			
			mlistComplete(request, response);
		} else if("slistProgress".equals(command)) {			
			slistProgress(request,response);
		} else if("slistComplete".equals(command)) {			
			slistComplete(request, response);
		} else if("teamlistProgress".equals(command)) {			
			teamlistProgress(request, response);
		} else if("teamlistComplete".equals(command)) {			
			teamlistComplete(request, response);
		}
		
	}
	
	// 개인 프로젝트 테이블을 화면에 출력
	public void mlistProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		try {
			request.setAttribute("mlistProgress", service.mplistProgress());
			request.setAttribute("mdlistProgress", service.mpdJsonProgress());
			request.setAttribute("pmdlistProgress", service.mpJsonProgress());
			url = "view/table/chart/ChartProjectTeam.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void mlistComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		try {
			request.setAttribute("mlistProgress", service.mplistComplete());
			request.setAttribute("mdlistProgress", service.mpdJsonProgress());
			request.setAttribute("pmdlistProgress", service.mpJsonComplete());
			url = "view/table/chart/ChartProjectTeam.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//slistProgress
	public void slistProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		try {
			request.setAttribute("mlistProgress", service.splistProgress());
			request.setAttribute("mdlistProgress", service.spdJsonProgress());
			request.setAttribute("pmdlistProgress", service.spJsonProgress());
			url = "view/table/chart/ChartProjectTeam.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void slistComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		try {
			request.setAttribute("mlistProgress", service.splistComplete());
			request.setAttribute("mdlistProgress", service.spdJsonProgress());
			request.setAttribute("pmdlistProgress", service.spJsonComplete());
			url = "view/table/chart/ChartTeam.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void teamlistProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		try {
			request.setAttribute("mlistProgress", service.teamListProgress());
			request.setAttribute("pmdlistProgress", service.teamJsonProgress());
//			request.setAttribute("mdlistProgress", service.spdJsonProgress());
			url = "view/table/chart/ChartTeam.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void teamlistComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		try {
			request.setAttribute("mlistProgress", service.teamListComplete());
			request.setAttribute("pmdlistProgress", service.teamJsonComplete());
//			request.setAttribute("mdlistProgress", service.spdJsonProgress());
			url = "view/table/chart/ChartTeam.jsp";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public String listAllProjects(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
		
	}
}