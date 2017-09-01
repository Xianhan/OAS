package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IGateCardBiz;
import com.neuq.biz.imp.GateCardBizImp;
import com.neuq.entities.GateCard;

public class SignOnDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		IGateCardBiz igcb = new GateCardBizImp();
		List<GateCard> gatecards = new ArrayList<GateCard>();
		String d;
		if ((d = request.getParameter("date")) != null) {
			gatecards = igcb.signOnDetail(Integer.parseInt((String) session.getAttribute("id")), d);
		} else {
			d = new Date().getYear() + 1900 + "-" ;
			int month = new Date().getMonth() + 1;
			if ((month + "").length() < 2) {
				d += "0" + month;
			} else {
				d += month;
			}
			gatecards = igcb.signOnDetail(Integer.parseInt((String) session.getAttribute("id")), d);

		}
		System.out.println(d);
		session.setAttribute("gatecards", gatecards);
		response.sendRedirect("SignOnDetail.jsp");
	}

}
