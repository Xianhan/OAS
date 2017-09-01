package com.neuq.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.AffairApplyBiz;
import com.neuq.biz.imp.AffairApplyBizImp;
import com.neuq.entities.*;

/**
 * Servlet implementation class QueryAffairs
 */
@WebServlet("/QueryAffairs")

public class QueryAffairs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAffairs() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		//接收登录时的id
		int id=Integer.parseInt((String) session.getAttribute("id"));
		
		AffairApplyBiz affairapply=new AffairApplyBizImp() ;
		List<Affairs> arrayAff=new ArrayList<Affairs>();
		
		try {
			arrayAff=affairapply.QueryApply(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//arrayAff.add(affair);
		session.setAttribute("arrayAff", arrayAff);
		
		response.sendRedirect("myapplyList.jsp");
	}

}
