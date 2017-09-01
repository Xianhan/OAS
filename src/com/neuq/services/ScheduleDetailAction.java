package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ScheduleBizImp;
import com.neuq.entities.Schedule;

public class ScheduleDetailAction extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	
}
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	HttpSession session=request.getSession();
	String scheid=(String) request.getParameter("ussch");
	int scid=Integer.parseInt(scheid);
	//System.out.println(scid);
	ScheduleBizImp sbi=new ScheduleBizImp();
	List<Schedule> uss=sbi.UpdateSelectSchedule(scid);
	//System.out.println(uss);
	session.setAttribute("USSchedule", uss);
	response.sendRedirect("ScheduleDetail.jsp");
	
	
}

}
