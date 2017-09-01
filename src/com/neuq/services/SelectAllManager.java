package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Worker;

public class SelectAllManager extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		IWorkerBiz iwb=new WorkerBizImp();
		List<Worker> managerList=iwb.selectAllManager();
		HttpSession session = request.getSession();
		session.setAttribute("managerList", managerList);
		System.out.println(managerList.size());
		response.sendRedirect("makeapply.jsp");
		out.flush();
		out.close();
	}

}
