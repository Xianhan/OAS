package com.neuq.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMessagesBiz;
import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.MessagesBizImp;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Worker;

public class IsReadMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public IsReadMessages() {
		super();
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		IWorkerBiz iwbz = new WorkerBizImp();

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int currentId = Integer.parseInt(id);
		Worker currentWorker = new Worker();
		currentWorker = iwbz.queryWorker(currentId);

		String receiverName = request.getParameter("recevier");
		Worker receiver = new Worker();
		receiver = iwbz.queryWorker(receiverName);
		long current = Long.parseLong(request.getParameter("msgID"));
		int isRead = Integer.parseInt(request.getParameter("isRead"));
		
		IMessagesBiz imbz = new MessagesBizImp();
		
		if(currentWorker.getId()==receiver.getId()) {
			imbz.updateMessagesStatus(current);
		}
		response.sendRedirect("GetMessagesList");
	}
	

}
