package com.lotte.emp.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.ArrayList;

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
		String command = null;
		if(request.getParameter("command") == null){
			command = (String) request.getAttribute("command");
		} else {
			command = request.getParameter("command");
		}
		System.out.println("command : " + command);
		
		if(command.equals("login")){
			userLogin(request, response);
		} else if("personalProgress".equals(command)) {
			personalProgress(request, response);
		} else if("personalCompletedProgress".equals(command)) {
			personalCompletedProgress(request, response);
		} else if("".equals(command)) {
			
		}
	}

	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		String url = "view/error/loginError.jsp"; // 에러 창으로 이동
		String dPart = "";

		ArrayList<ArrayList<SuperDTO>> detailProjects = new ArrayList<ArrayList<SuperDTO>>();

		try {
			EmpDTO dto = service.userLogin(Integer.parseInt(id), pw);
			if(dto != null){
				ArrayList<SuperDTO> sDto = pService.listProgressingPrjManagers(dto.geteIndex());
				if(sDto != null){
					for(int i = 0; i<sDto.size(); i++){
//						System.out.println(sDto.get(i).geteIndex() +", " + sDto.get(i).getpIndex());
						detailProjects.add(pService.listProgressingPrjDtlManagers(sDto.get(i).geteIndex(), sDto.get(i).getpIndex()));
					}
				}
//				System.out.println(sDto.toString());
				dPart = pService.selectDpartbyDIndex(dto.getdIndex());
				url ="view/table/tablePersonal.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("msg", dto);
				request.setAttribute("dto", sDto);
				request.setAttribute("dtlPrj", detailProjects);
				request.setAttribute("dPart", dPart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void personalProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = -1;
		if(request.getParameter("eIndex")==null) {
			id = (Integer)session.getAttribute("eIndex");			
		} else {			
			id =Integer.parseInt(request.getParameter("eIndex"));
		}
		String url = "view/error/listError.jsp"; // 에러 창으로 이동
		ArrayList<ArrayList<SuperDTO>> detailProjects = new ArrayList<ArrayList<SuperDTO>>();

		try {
				ArrayList<SuperDTO> sDto = pService.listProgressingPrjManagers(id);
				if(sDto != null){
					for(int i = 0; i<sDto.size(); i++){
						detailProjects.add(pService.listProgressingPrjDtlManagers(sDto.get(i).geteIndex(), sDto.get(i).getpIndex()));
					}
				}
				url ="view/table/tablePersonal.jsp";
				session = request.getSession();
				session.setAttribute("dto", sDto);
				session.setAttribute("dtlPrj", detailProjects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void personalCompletedProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("eIndex"));
		String url = "view/error/listError.jsp"; // 에러 창으로 이동
		ArrayList<ArrayList<SuperDTO>> detailProjects = new ArrayList<ArrayList<SuperDTO>>();

		try {
				ArrayList<SuperDTO> sDto = pService.listProgressedPrjManagers(id);
				if(sDto != null){
					for(int i = 0; i<sDto.size(); i++){
						detailProjects.add(pService.listProgressedPrjDtlManagers(sDto.get(i).geteIndex(), sDto.get(i).getpIndex()));
					}
				}
				url ="view/table/tablePersonalCompleted.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("dto", sDto);
				session.setAttribute("dtlPrj", detailProjects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
