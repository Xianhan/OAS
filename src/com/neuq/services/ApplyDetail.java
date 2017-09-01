package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.AffairApplyBiz;
import com.neuq.biz.imp.AffairApplyBizImp;
import com.neuq.entities.Affairs;

public class ApplyDetail extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 接收affid用于查询单个事务表
		long affid = Long.parseLong((String) request.getParameter("affid"));
		AffairApplyBiz affairapply = new AffairApplyBizImp();
		// 生成事务表对象用于储存
		Affairs affdetail = new Affairs();
		affdetail = affairapply.ApplyDetail(affid);
		// 将事务表存进session
		session.setAttribute("affdetail", affdetail);
		// 重定向到事务细节页面
		response.sendRedirect("admin/managerApplyDetails.jsp");

	}

	public void init() throws ServletException {
	
	}

}
