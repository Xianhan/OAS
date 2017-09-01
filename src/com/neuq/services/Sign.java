package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IGateCardBiz;
import com.neuq.biz.imp.GateCardBizImp;
import com.neuq.entities.GateCard;
import com.neuq.entities.Worker;

public class Sign extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		IGateCardBiz igcb=new GateCardBizImp();
		PrintWriter out = response.getWriter();
		GateCard gatecard=new GateCard();
		Worker worker=new Worker();
		
		if(request.getParameter("signon")!=null){
			boolean res = igcb.querySignon(Integer.parseInt((String)session.getAttribute("id")));
			if(res){
				out.print("您今日已经签到，<a href=\"SignOn.jsp\">点此</a>返回");
			}else{
				worker.setId(Integer.parseInt((String)session.getAttribute("id")));
				
				gatecard.setArriveTime(new Date());
				gatecard.setWorker(worker);
				System.out.println(worker);
				if(igcb.signOn(gatecard)){
					response.sendRedirect("Sign");
					return;
				}
				else{
					out.print("操所失败，<a href=\"SignOn.jsp\">点此</a>返回");
				}
			}
		}
		if(request.getParameter("signout")!=null){
			boolean res = igcb.querySignon(Integer.parseInt((String)session.getAttribute("id")));
			if(!res){
				out.print("请先签到，<a href=\"SignOn.jsp\">点此</a>返回");
			}else{
				worker.setId(Integer.parseInt((String)session.getAttribute("id")));
				
				gatecard.setWorker(worker);
				gatecard.setLeaveTime(new Date());
				if(igcb.signOut(gatecard)){
					response.sendRedirect("Sign");
					return;
				}
				else{
					out.print("操所失败，<a href=\"SignOn.jsp\">点此</a>返回");
				}
			}
		}
		int days=igcb.queryDays(Integer.parseInt((String)session.getAttribute("id")));
		session.setAttribute("signedDays", days);
		response.sendRedirect("SignOn.jsp");
	}

}
