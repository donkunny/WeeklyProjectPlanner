package com.lotte.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lotte.emp.model.dto.SuperDTO;
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

	private void projectTeamManagement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eIndex = Integer.parseInt(request.getParameter("eIndex"));
		String url = "view/error/listError.jsp"; // 에러 창으로 이동
		
		//Map<Integer, ArrayList<SuperDTO>> projectMember = new HashMap<Integer, ArrayList<SuperDTO>>();
		ArrayList<ArrayList<SuperDTO>> projectMember = new ArrayList<ArrayList<SuperDTO>>();
		
		try {
			ArrayList<SuperDTO> dto = service.listProjectManagement(eIndex); 
			if(dto != null){
				for(int i = 0; i<dto.size(); i++){
					//System.out.println(dto.get(i).toString());
					//projectMember.put(dto.get(i).getpIndex(), eService.memberList(dto.get(i).getpIndex()));
					projectMember.add(eService.memberList(dto.get(i).getpIndex()));
				}//projectMember.get(1).get(1).getdName();
			}
			url ="view/table/tableProjectTeam.jsp";
			request.setAttribute("pjtList", dto);
			request.setAttribute("memList", projectMember);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}