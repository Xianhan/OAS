package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ScheduleBizImp;
import com.neuq.entities.Schedule;


public class UpdateSelectScheduleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateSelectScheduleAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
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
		response.sendRedirect("UpdateSchedule.jsp");

	}

}
