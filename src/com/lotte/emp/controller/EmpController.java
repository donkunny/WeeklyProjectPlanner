package com.lotte.emp.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lotte.emp.model.dto.EmpDTO;
import com.lotte.emp.model.dto.SuperDTO;
import com.lotte.emp.service.EmpService;
import com.lotte.emp.service.EmpServiceImpl;
import com.lotte.project.service.ProjectService;
import com.lotte.project.service.ProjectServiceImpl;

public class EmpController extends HttpServlet{

	EmpService service = EmpServiceImpl.getEmpService();
	ProjectService pService = ProjectServiceImpl.getProjectService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		if(command.equals("login")){
			userLogin(request, response);
		} else if("pesonalProgress".equals(command)) {
			
		} else if("".equals(command)) {
			
		} else if("".equals(command)) {
			
		}
	}
	
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		
		Map<String, ArrayList<SuperDTO>> detailProjects = new HashMap<String, ArrayList<SuperDTO>>();
		try {
			EmpDTO dto = service.userLogin(Integer.parseInt(id), pw);
			if(dto != null){
				ArrayList<SuperDTO> sDto = pService.listProgressingPrjManagers(dto.geteIndex());
				if(sDto != null){
					for(int i = 0; i<sDto.size(); i++){
						detailProjects.put("key"+i, pService.listProgressingPrjDtlManagers(sDto.get(i).geteIndex(), sDto.get(i).getpIndex()));
					}
				}
				url ="view/table/tablePersonal.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("msg", dto);
				session.setAttribute("dto", sDto);
				session.setAttribute("dtlPrj", detailProjects);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//public ArrayList<SuperDTO> userList() throws SQLException;
	public void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null; // 에러 창으로 이동
		System.out.println(1);
		try {System.out.println(2);
			ArrayList<SuperDTO> dto = service.userList();
			if(dto != null){
				url ="view/table/findEmpModal.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("dtoList", dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}System.out.println(3);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
