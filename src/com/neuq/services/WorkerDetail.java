package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IJobBiz;
import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.JobBizImp;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.dao.imp.WorkerDaoImp;
import com.neuq.entities.Job;
import com.neuq.entities.Worker;

public class WorkerDetail extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
	
		IJobBiz ijb=new JobBizImp();
		List<Job> jobList=new ArrayList<Job>();
		jobList=ijb.selectAllJob();
		session.setAttribute("jobList", jobList);
		
		
		PrintWriter out = response.getWriter();
		IWorkerBiz iwb = new WorkerBizImp();
		String str = request.getParameter("id");
		String alter = request.getParameter("alter");
		String delete=request.getParameter("delete");
		String add=request.getParameter("add");
	
		if (str != null) {
			int id = Integer.parseInt(str);
			Worker worker=iwb.queryWorker(id);
			session.setAttribute("WorkerDetail", worker);
			response.sendRedirect("admin/WorkerDetail.jsp");
		}
		
		if(alter!=null){
			
			int id = Integer.parseInt(alter);
			Worker worker=iwb.queryWorker(id);
			
			session.setAttribute("alterWorker", worker);
			response.sendRedirect("admin/AlterWorker.jsp");
		}
		
		if(delete!=null){
			boolean b=iwb.deleteWorker(Integer.parseInt(delete));
			if(b){
				response.sendRedirect("admin/ManageWorker.jsp");
			}
			else{
				out.print("操作失败");
				out.flush();
				out.close();
			}
		}
		//添加员工
		if(add!=null){
			List<Worker> managerList=iwb.selectAllManager();
			session.setAttribute("managerList", managerList);
			response.sendRedirect("admin/AddWorker.jsp");
		}
	}
}
