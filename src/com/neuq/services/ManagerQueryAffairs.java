package com.neuq.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.AffairApplyBiz;
import com.neuq.biz.imp.AffairApplyBizImp;
import com.neuq.entities.Affairs;

@SuppressWarnings("serial")
public class ManagerQueryAffairs extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ManagerQueryAffairs() {
		super();
	}

	/**
		 * Destruction of the servlet.
		 */
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
		HttpSession session=request.getSession();
		//PrintWriter out = response.getWriter();
		//接收登录时的id
		int id=Integer.parseInt((String) session.getAttribute("id"));
		//测试能否接收到id
		//System.out.println(id);
		//返回集合
		AffairApplyBiz affairapply=new AffairApplyBizImp() ;
		List<Affairs> maffair=new ArrayList<Affairs>();
		try {
			maffair=affairapply.ManagerQueryApply(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//将集合存到session
		session.setAttribute("maffair",maffair);
		//测试
		//		System.out.println(maffair);
		//转到审核列表界面
		response.sendRedirect("admin/managerApply.jsp");
	}

	public void init() throws ServletException {
		//测试是否开始
		//System.out.println("查询开始");
	}

}
