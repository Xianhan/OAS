package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Job;
import com.neuq.entities.Paging;
import com.neuq.entities.Worker;

public class AlterWorker extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
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
		IWorkerBiz iwb=new WorkerBizImp();
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Worker  w=new Worker();
		w.setId(Integer.parseInt(request.getParameter("id")));
		w.setRealname(request.getParameter("realname"));
		w.setSex(request.getParameter("sex"));
		Job job=new Job();
		job.setId(Integer.parseInt(request.getParameter("job")));
		w.setJob(job);
		Worker manager =new Worker();
		manager.setId(Integer.parseInt(request.getParameter("manager")));
		w.setManager(manager);
		System.out.println(w);
		boolean res = iwb.updateWorker(w);
		if(res){
			response.sendRedirect("ShowAllWorker?reqNum="+((Paging)(session.getAttribute("page"))).getReqPage());
		}
		else{
			out.print("修改失败");
		}
	}

}
