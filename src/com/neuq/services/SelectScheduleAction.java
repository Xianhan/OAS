package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ScheduleBizImp;
import com.neuq.entities.Schedule;

public class SelectScheduleAction extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		ScheduleBizImp sbi=new ScheduleBizImp();
		String ID = (String) session.getAttribute("id");
		int id=Integer.parseInt(ID) ;//当前用户id
		List<Schedule> ss=sbi.SelectSchedule(id);
		session.setAttribute("Schedule", ss);
		response.sendRedirect("Schedule.jsp");
		
	}

}
