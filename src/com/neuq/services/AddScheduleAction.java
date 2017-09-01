package com.neuq.services;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ScheduleBizImp;
import com.neuq.entities.Schedule;
import com.neuq.util.DateUtil;

/**
 * Servlet implementation class AddScheduleAction
 */
@WebServlet("/AddScheduleAction")
public class AddScheduleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScheduleAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		doGet(request, response);
		HttpSession session=request.getSession();
		String title=(String) request.getParameter("title");
		
		String ID = (String) session.getAttribute("id");
		int id=Integer.parseInt(ID) ;//当前用户id
		
		String d=(String) request.getParameter("date");
		DateUtil dateu=new DateUtil();
		java.util.Date date= dateu.StrToDate(d);
		System.out.println(date);
		String content=(String) request.getParameter("content");
		Schedule s=new Schedule();
		
		s.setTitle(title);
		s.setPubTime(date);
		s.setContent(content);
		s.setUserId(id);
		
		ScheduleBizImp sbi=new ScheduleBizImp();
		sbi.AddSchedule(s);
		response.sendRedirect("SelectScheduleAction");
		
	}

}
