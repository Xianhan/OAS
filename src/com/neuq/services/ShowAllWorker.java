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
import com.neuq.entities.Paging;
import com.neuq.entities.Worker;

public class ShowAllWorker extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		 int reqnum=Integer.parseInt(request.getParameter("reqNum"));
		IWorkerBiz iwb=new WorkerBizImp();
		List<Worker> workerList=iwb.selectAllWorker();
		Paging p=new Paging(workerList.size(), 7);
		p.doPaging(reqnum);
		List<Worker> pWorker=iwb.pagingWorker(p.getStart(),p.getEnd());
		session.setAttribute("pWorker",pWorker);
		session.setAttribute("allWorker", workerList);
		session.setAttribute("page", p);
		
		response.sendRedirect("admin/ManageWorker.jsp");
	}

}
