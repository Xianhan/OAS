package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IManageSalBiz;
import com.neuq.biz.imp.ManageSalBizImp;
import com.neuq.entities.Salary;

public class AddSal extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		IManageSalBiz ims = new ManageSalBizImp();
		List<Salary> sal = ims.checkSal();
		session.setAttribute("empList", sal);
		response.sendRedirect("admin/AllSal.jsp");

	}

}
