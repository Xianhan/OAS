package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMessagesBiz;
import com.neuq.biz.imp.MessagesBizImp;
import com.neuq.dao.IMessagesDao;
import com.neuq.dao.imp.MessagesDaoImp;
import com.neuq.entities.Messages;
import com.neuq.entities.Paging;

/**
 * ��ȡ��Ϣ�б�
 * @author Calvin
 *
 */
public class GetMessagesList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetMessagesList() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int senderId = Integer.parseInt(id);

		IMessagesBiz imbz = new MessagesBizImp();
		List<Messages> messages = imbz.selectMessages(senderId);
	
		session.setAttribute("MessagesList", messages);
	
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/Messages.jsp"); // ��ת����Ϣ�б�ҳ
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	

}
