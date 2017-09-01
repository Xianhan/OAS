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
	 * 新增公告
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
		// 找到当前登录用户对应对象
		String id = (String) session.getAttribute("id");
		int promulgatorId = Integer.parseInt(id);// 当前员工的登录的Id
		Worker promulgator = new Worker();
		promulgator = iwbz.queryWorker(promulgatorId);
		
		String title = request.getParameter("anntitle");
		String content = request.getParameter("anncontent");
		//创建公告对象
		Announcement ann = new Announcement();
		ann.setTitle(title);
		ann.setContent(content);
		ann.setPromulgator(promulgator);
		//调用添加公告的方法
		IAnnouncementBiz iabz = new AnnouncementBizImp();
		iabz.addAnnouncement(ann);
		response.sendRedirect("GetAnnouncement");
	}

}
