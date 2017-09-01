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

public class AddAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ��������
	 */
	public AddAnnouncement() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		IWorkerBiz iwbz = new WorkerBizImp();
		HttpSession session = request.getSession();
		// �ҵ���ǰ��¼�û���Ӧ����
		String id = (String) session.getAttribute("id");
		int promulgatorId = Integer.parseInt(id);// ��ǰԱ���ĵ�¼��Id
		Worker promulgator = new Worker();
		promulgator = iwbz.queryWorker(promulgatorId);
		
		String title = request.getParameter("anntitle");
		String content = request.getParameter("anncontent");
		//�����������
		Announcement ann = new Announcement();
		ann.setTitle(title);
		ann.setContent(content);
		ann.setPromulgator(promulgator);
		//������ӹ���ķ���
		IAnnouncementBiz iabz = new AnnouncementBizImp();
		iabz.addAnnouncement(ann);
		response.sendRedirect("GetAnnouncement");
	}

}
