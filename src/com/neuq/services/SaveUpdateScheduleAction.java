package com.neuq.services;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ScheduleBizImp;
import com.neuq.entities.Schedule;
import com.neuq.util.DateUtil;

public class SaveUpdateScheduleAction extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	
}
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	HttpSession session=request.getSession();
	String title=request.getParameter("title");
	String pubtime=request.getParameter("pubtime");
	DateUtil dateu=new DateUtil();
	Timestamp date=new java.sql.Timestamp((dateu.StrToDate(pubtime)).getTime());
	
	String content=request.getParameter("content");
	
	String ID = (String) session.getAttribute("id");
	int id=Integer.parseInt(ID) ;//当前用户id
	
	String scheid=(String) request.getParameter("scheid");
	System.out.println(scheid);
	int scid=Integer.parseInt(scheid);//该日程的scheId
	
	Schedule s=new Schedule();
	s.setTitle(title);
	s.setPubTime(date);
	s.setContent(content);
	s.setUserId(id);
	s.setScheId(scid);
	
	
	ScheduleBizImp sbi=new ScheduleBizImp();
	sbi.UpdateSchedule(s);
	response.sendRedirect("SelectScheduleAction");
	
	
	
}

}
