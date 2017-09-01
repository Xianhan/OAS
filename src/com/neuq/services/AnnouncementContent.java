package com.neuq.services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
import com.neuq.entities.Worker;


//��������
public class AnnouncementContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnnouncementContent() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		long annID = Long.parseLong((String) request.getParameter("annID"));
		IAnnouncementBiz iabz = new AnnouncementBizImp();
		
		Announcement ann = iabz.selectAnnByID(annID);
		System.out.println(ann);
		session.setAttribute("annContent", ann);
		String id = (String) session.getAttribute("id");
		int currentID = Integer.parseInt(id);
		IWorkerBiz iwbz = new WorkerBizImp();
		Worker currentWork = iwbz.queryWorker(currentID);
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		if (currentID == currentWork.getManager().getId() || currentWork.getManager().getId() == 0) {
			dispatcher = servletContext.getRequestDispatcher("/admin/ManAnnouncementContent.jsp"); // ��ת������Ա��������ҳ
		} else {
			dispatcher = servletContext.getRequestDispatcher("/AnnouncementContent.jsp"); // ��ת�����������б�ҳ
		}
		dispatcher.forward(request, response);
	}

}
