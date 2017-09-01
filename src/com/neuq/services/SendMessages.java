package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMessagesBiz;
import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.MessagesBizImp;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Messages;
import com.neuq.entities.Worker;
import com.neuq.util.DateUtil;

/**
 * ������Ϣ(����Ϣ��������ݿ�)
 * 
 * @author Calvin
 *
 */

public class SendMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendMessages() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		IWorkerBiz iwbz = new WorkerBizImp();
		HttpSession session = request.getSession();

		// �ҵ���ǰ��¼�û���Ӧ����
		String id = (String) session.getAttribute("id");
		int senderId = Integer.parseInt(id);// ��ǰԱ���ĵ�¼��Id
		Worker sender = new Worker();
		sender = iwbz.queryWorker(senderId);

		String content = request.getParameter("content");

	
		String receiverName = request.getParameter("receiver");
		Worker receiver = new Worker();
		receiver = iwbz.queryWorker(receiverName);

		Messages message = new Messages();
		message.setSender(sender);
		message.setReceiver(receiver);
		message.setContent(content);
		
		
		IMessagesBiz imbz = new MessagesBizImp();
		boolean flag=imbz.addMessages(message);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		if (!flag) {
			out.write("<script language='javascript'>alert('Failed')</script>");
		}
		else {
			   out.write("<script language='javascript'>alert('OK')</script>");
		}
		dispatcher = servletContext.getRequestDispatcher("/GetMessagesList"); // ��ת����Ϣ�б�ҳ
		
		dispatcher.forward(request, response);

	}

}
