package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IManageSalBiz;
import com.neuq.biz.imp.ManageSalBizImp;
import com.neuq.entities.Salary;
import com.neuq.entities.Worker;



//�޸İ�ť���޸�ĳ���˹���ҳ���servlet



public class LinkAlter extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
        String id = request.getParameter("salid");

		int n=Integer.parseInt(id);
		HttpSession session=request.getSession();
		IManageSalBiz imb=new ManageSalBizImp();
		Salary s=imb.checkSal(n);
		System.out.println(s);
		session.setAttribute("MySalList",s);			
		response.sendRedirect("admin/MySalList.jsp");	  
	
	}
}
