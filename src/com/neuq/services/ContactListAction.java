package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ContactListBizImp;
import com.neuq.entities.Worker;

public class ContactListAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		ContactListBizImp ctbi = new ContactListBizImp();
		List<Worker> ws = ctbi.selectContactListBiz();
		session.setAttribute("ContactList", ws);
		response.sendRedirect("ContactList.jsp");

	}
}
