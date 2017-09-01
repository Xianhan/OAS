package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMessagesBiz;
import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.MessagesBizImp;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Worker;

public class NumUnreadMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NumUnreadMessages() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		IMessagesBiz imbz = new MessagesBizImp();
		// 当前用户登录ID
		String id = (String) session.getAttribute("id");
		int currentID = Integer.parseInt(id);
		// 找到当前用户未读的消息的数量
		String count = String.valueOf(imbz.NumUnread(currentID));
		response.getWriter().print(count);
	}

}
