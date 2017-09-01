package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.biz.AffairApplyBiz;
import com.neuq.biz.imp.AffairApplyBizImp;

public class ManagerCheckAffairs extends HttpServlet {

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		AffairApplyBiz affairapply=new AffairApplyBizImp() ;
		//将页面获取状态根据affid存进数据库
		int approvalprog=Integer.parseInt((String)request.getParameter("status"));
		long affid=Long.parseLong((String)request.getParameter("affid"));
		boolean b=affairapply.CheckApply(approvalprog,affid);
		//测试是否能执行
		if(b){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		//测试成功
		
		//回到申请列表
		response.sendRedirect("managerQueryAffairs");
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		//测试开始
		//System.out.println("申请状态修改");
	}

}
