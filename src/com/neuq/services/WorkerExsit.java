package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Worker;
import com.sun.mail.iap.Response;

public class WorkerExsit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WorkerExsit() {
		super();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		
		IWorkerBiz iwbz = new WorkerBizImp();
		Worker b = iwbz.queryWorker(name);
	
		String id = (String) session.getAttribute("id");
		int currentID = Integer.parseInt(id);
		
		Worker currentWork = iwbz.queryWorker(currentID);
		if (b.getId() == 0) {
			response.getWriter().print("no");
		} else if(b.getId()==currentWork.getId())  {
			response.getWriter().print("current");
		}
		else {
			response.getWriter().print("yes");
		}
	}

}
