package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMessagesBiz;
import com.neuq.biz.imp.MessagesBizImp;

/**
 * ɾ����Ϣ
 * 
 * @author Calvin
 *
 */
public class DeleteMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteMessages() {
		super();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		IMessagesBiz imbz = new MessagesBizImp();
		long messagesId = Long.parseLong(request.getParameter("messagesId"));
		boolean flag = imbz.deleteMessages(messagesId);
		if (!flag) {
			out.write("<script language='javascript'>alert('Failed')</script>");
		} else {
			out.write("<script language='javascript'>alert('OK')</script>");
		}
		response.sendRedirect("GetMessagesList");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
