package com.lotte.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lotte.emp.service.EmpService;
import com.lotte.emp.service.EmpServiceImpl;
import com.lotte.project.model.dto.PrjDetailDTO;
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
		if(request.getParameter("command") == null){
			command = (String) request.getAttribute("command");
		} else {
			command = request.getParameter("command");
		}
		System.out.println("command : " + command);
		

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
		} else if("insertDtlPrj".equals(command)) {			
			insertDetailProject(request, response);
		} else if("updateDtlPrj".equals(command)) {			
			updateDetailProject(request, response);
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
	
	private void updateDetailProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "view/error/listError.jsp"; // 에러 창으로 이동
		String pdName = request.getParameter("pdName");
		int eIndex = Integer.parseInt(request.getParameter("eIndex"));
		double pdProgress = Double.parseDouble(request.getParameter("pdProgress"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date pdStartDate = null;
		Date pdEndDate = null;
		java.util.Date utilDate = new java.util.Date();
		Date pdWriteDate = new Date(utilDate.getTime());
		int pdIndex = Integer.parseInt(request.getParameter("pdIndex"));
		try {
			java.util.Date pdStartDate_u = format.parse(request.getParameter("pdStartDate"));
			java.util.Date pdEndDate_u = format.parse(request.getParameter("pdEndDate"));
			pdStartDate = new Date(pdStartDate_u.getTime());
			pdEndDate = new Date(pdEndDate_u.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PrjDetailDTO dto = new PrjDetailDTO();
		dto.setPdName(pdName);
		dto.setPdStartDate(pdStartDate);
		dto.setPdEndDate(pdEndDate);
		dto.setPdWriteDate(pdWriteDate);
		dto.setPdIndex(pdIndex);
		try{
			boolean result = service.updateDetailProject(dto);
			if(result){
				String root = request.getContextPath();
				url =  root + "/emp?command=personalProgress";
				request.setAttribute("detailDTO", dto);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("eIndex", eIndex);
		response.sendRedirect(url);
	}
	
	// 개인 프로젝트 입력
	public void insertDetailProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error/listError.jsp"; // 에러 화면
		int pIndex = Integer.parseInt(request.getParameter("pIndex"));
		int eIndex = Integer.parseInt(request.getParameter("eIndex"));
		String pdName = request.getParameter("pdName");
		double pdProgress = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date pdStartDate = null;
		Date pdEndDate = null;
		java.util.Date utilDate = new java.util.Date();
		Date pdWriteDate = new Date(utilDate.getTime());
		try {
			java.util.Date pdStartDate_u = format.parse(request.getParameter("pdStartDate"));
			java.util.Date pdEndDate_u = format.parse(request.getParameter("pdEndDate"));
			pdStartDate = new Date(pdStartDate_u.getTime());
			pdEndDate = new Date(pdEndDate_u.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PrjDetailDTO dto = new PrjDetailDTO(pIndex, eIndex, pdName, pdProgress, pdStartDate, pdEndDate, pdWriteDate);
		try{
				boolean result = service.insertDetailProject(dto);
				if(result){
					String root = request.getContextPath();
					url =  root + "/emp?command=personalProgress";
					request.setAttribute("detailDTO", dto);
//					request.setAttribute("successMsg", "입력되었습니다.");
				} else {
//					request.setAttribute("errorMsg", "다시 시도하세요.");
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("eIndex", eIndex);
		response.sendRedirect(url);
	}
}