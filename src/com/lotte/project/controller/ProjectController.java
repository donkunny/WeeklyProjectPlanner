package com.lotte.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lotte.emp.service.EmpService;
import com.lotte.emp.service.EmpServiceImpl;
import com.lotte.project.model.dto.PrjDetailDTO;
import com.lotte.project.service.ProjectService;
import com.lotte.project.service.ProjectServiceImpl;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

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
		} else if("insertDtlPrj".equals(command)) {			
			insertDetailProject(request, response);
		} else if("".equals(command)) {			
			
		} else if("".equals(command)) {			
			
		}
	}
	
	// 개인 프로젝트 테이블을 화면에 출력
	public void mlistAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/listError.jsp"; // 에러 창으로 이동
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
	
	public void insertDetailProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/listError.jsp"; // 에러 화면
		int pdIndex = Integer.parseInt(request.getParameter("pdIndex"));
		int pIndex = Integer.parseInt(request.getParameter("pIndex"));
		int eIndex = Integer.parseInt(request.getParameter("eIndex"));
		String pdName = request.getParameter("pdName");
		double pdProgress = Double.parseDouble(request.getParameter("0"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date pdStartDate = null;
		Date pdEndDate = null;
		Date pdWriteDate = null;
		try {
			java.util.Date pdStartDate_u = format.parse(request.getParameter("pdStartDate"));
			java.util.Date pdEndDate_u = format.parse(request.getParameter("pdEndDate"));
			java.util.Date pdWriteDate_u = format.parse(request.getParameter("pdWriteDate"));
			pdStartDate = new Date(pdStartDate_u.getTime());
			pdEndDate = new Date(pdEndDate_u.getTime());
			pdWriteDate = new Date(pdWriteDate_u.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PrjDetailDTO dto = new PrjDetailDTO(pIndex, eIndex, pdIndex, pdName, pdProgress, pdStartDate, pdEndDate, pdWriteDate);
		try{
				boolean result = service.insertDetailProject(dto);
				if(result){
					request.setAttribute("detailDTO", dto);
					request.setAttribute("successMsg", "입력되었습니다.");
					url = "view/table/tablePersonal.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요.");
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}