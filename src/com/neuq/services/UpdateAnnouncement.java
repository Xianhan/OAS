package com.neuq.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IAnnouncementBiz;
import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.AnnouncementBizImp;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Announcement;

/**
 * Servlet implementation class DeleteAnnouncement
 */
public class UpdateAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAnnouncement() {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		System.out.println("ִ����");
		HttpSession session = request.getSession();
		long id = Long.parseLong((String)request.getParameter("annID"));
		String content = request.getParameter("content");
		
	
		Announcement ann = new Announcement();
		ann.setContent(content);
		
		IAnnouncementBiz iabz = new AnnouncementBizImp();
		iabz.updateAnnouncement(content, id);
		response.sendRedirect("GetAnnouncement");
	}

}
