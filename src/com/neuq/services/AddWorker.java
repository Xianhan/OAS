package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Job;
import com.neuq.entities.Worker;

public class AddWorker extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String realname = request.getParameter("realname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String date = request.getParameter("hiredate");
		String jobstr = request.getParameter("job");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		String managerId = request.getParameter("manager");
		SimpleDateFormat d = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date hiredate = null;
		try {
			hiredate = new java.sql.Date(d.parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Worker worker = new Worker();
		worker.setRealname(realname);
		worker.setPassword(password);
		worker.setSex(sex);
		worker.setEmail(email);
		worker.setPhone(Long.parseLong(phone));
		worker.setHiredate(hiredate);
		Job job = new Job();
		job.setId(Integer.parseInt(jobstr));
		worker.setJob(job);
		worker.setAddress(address);
		worker.setStatus(Integer.parseInt(status));
		Worker manager = new Worker();
		manager.setId(Integer.parseInt(managerId));
		worker.setManager(manager);
		IWorkerBiz iwb = new WorkerBizImp();
		boolean b = iwb.addWorker(worker);
		if (!b) {
			out.print("添加失败");
			out.flush();
			out.close();
		} else {
			response.sendRedirect("ShowAllWorker?reqNum=1");
		}

	}

}
