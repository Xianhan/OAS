package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neuq.biz.IManageSalBiz;
import com.neuq.biz.imp.ManageSalBizImp;
import com.neuq.entities.Job;
import com.neuq.entities.Salary;
import com.neuq.entities.Worker;

public class AlterSal extends HttpServlet {

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

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IManageSalBiz imb = new ManageSalBizImp();
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String date = request.getParameter("saldate");
		SimpleDateFormat d = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date saldate = null;
		try {
			saldate = new java.sql.Date(d.parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String id = request.getParameter("id");
		Salary s = new Salary();
		Worker w = new Worker();
		w.setId(Integer.parseInt(id));
		s.setWorker(w);

		s.setSalDate(saldate);
		s.setSalary(Integer.parseInt(request.getParameter("salary")));
		s.setBonus(Integer.parseInt(request.getParameter("bonus")));
		s.setTax(Integer.parseInt(request.getParameter("tax")));
		s.setAttendantsal(Integer.parseInt(request.getParameter("attendantsal")));
		s.setRealsal(Integer.parseInt(request.getParameter("realsal")));

		System.out.println(s);
		boolean res = imb.updateSal(s);
		if (res) {
			response.sendRedirect("AddSal");
			
		} else {
			out.print("修改失败");
		}
	}

}
