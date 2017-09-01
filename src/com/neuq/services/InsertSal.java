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

//��ӽ�����Ӱ�ť��AddSal.java(url:AllSal)���Servlet

public class InsertSal extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String date = request.getParameter("saldate");
		String salary = request.getParameter("salary");
		String bonus = request.getParameter("bonus");
		String tax = request.getParameter("tax");
		String attendantsal = request.getParameter("attendantsal");
		String realsal = request.getParameter("realsal");

		SimpleDateFormat d = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date saldate = null;
		try {
			saldate = new java.sql.Date(d.parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Salary s = new Salary();
		Worker w = new Worker();
		w.setId(Integer.parseInt(id));
		s.setWorker(w);
		s.setSalDate(saldate);
		s.setSalary(Integer.parseInt(salary));
		s.setBonus(Integer.parseInt(bonus));
		s.setTax(Integer.parseInt(tax));
		s.setAttendantsal(Integer.parseInt(attendantsal));
		s.setRealsal(Integer.parseInt(realsal));

		IManageSalBiz imb = new ManageSalBizImp();

		boolean b = imb.saveSal(s);
		System.out.println(s);
		if (b == false) {
			out.print("操作失败");
			out.flush();
			out.close();
		} else {
			response.sendRedirect("AddSal");
		}

	}

}
