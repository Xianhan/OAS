package com.neuq.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ScheduleBizImp;

public class DelScheduleAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String scheid = (String) request.getParameter("delsch");
		int scid = Integer.parseInt(scheid);
		ScheduleBizImp sbi = new ScheduleBizImp();
		sbi.DelSchedule(scid);
		response.sendRedirect("SelectScheduleAction");

	}

}
