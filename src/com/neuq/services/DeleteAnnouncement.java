package com.neuq.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.biz.IAnnouncementBiz;
import com.neuq.biz.imp.AnnouncementBizImp;

public class DeleteAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAnnouncement() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		IAnnouncementBiz iabz = new AnnouncementBizImp();
		String annID = (String) request.getParameter("annID1");// ��ȡ��ǰ����id
		long annId = Long.parseLong(annID);
		iabz.deleteAnnouncement(annId);
		response.sendRedirect("GetAnnouncement");
	}

}
