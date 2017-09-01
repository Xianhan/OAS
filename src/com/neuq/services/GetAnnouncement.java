package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IAnnouncementBiz;
import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.AnnouncementBizImp;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Announcement;
import com.neuq.entities.Worker;

//��ȡ�����б�

public class GetAnnouncement extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public GetAnnouncement() {
		super();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		IAnnouncementBiz iad = new AnnouncementBizImp();
		HttpSession session = request.getSession();
		List<Announcement> annList = iad.selectAnnouncement();
		session.setAttribute("AnnouncementList", annList);
	
		String id = (String) session.getAttribute("id");
		int currentID = Integer.parseInt(id);

		IWorkerBiz iwbz = new WorkerBizImp();
		Worker currentWork = iwbz.queryWorker(currentID);

		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
	
		if (currentID == currentWork.getManager().getId() || currentWork.getManager().getId() == 0) {
			dispatcher = servletContext.getRequestDispatcher("/admin/ManAnnouncement.jsp"); // ��ת������Ա�������б�ҳ
		} else {
			dispatcher = servletContext.getRequestDispatcher("/Announcement.jsp"); // ��ת�������б�ҳ
		}
		dispatcher.forward(request, response);
	}

}
