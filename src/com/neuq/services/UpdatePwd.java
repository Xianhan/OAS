package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Worker;

public class UpdatePwd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String oldPassword = request.getParameter("oldPassword");
		IWorkerBiz iwb = new WorkerBizImp();
		Worker cw = iwb.queryWorker(Integer.parseInt((String) (session.getAttribute("id"))));
	
		if (cw.getPassword().equals(oldPassword)) {
			Worker worker = new Worker();
			worker.setId(Integer.parseInt((String) (session.getAttribute("id"))));
			worker.setPassword(request.getParameter("newPassword"));
			if (iwb.updatePwd(worker)) {
				response.sendRedirect("login.jsp");
			} 
		}
		else {
			
			out.print("修改失败");
			
		}
	}

}
