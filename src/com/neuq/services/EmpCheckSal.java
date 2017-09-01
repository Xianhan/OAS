package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IEmpSalBiz;
import com.neuq.biz.imp.EmpSalBizImp;
import com.neuq.entities.Salary;

public class EmpCheckSal extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
	    HttpSession session=request.getSession();

	    int id=Integer.parseInt((String) session.getAttribute("id"));
	       
		  IEmpSalBiz ies=new EmpSalBizImp();
		   List<Salary> sal=ies.checkSal(id);
            System.out.println(sal);
			session.setAttribute("empList",sal);
			response.sendRedirect("MySal.jsp");	   
         
	}

}
