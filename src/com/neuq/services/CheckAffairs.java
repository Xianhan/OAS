package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.AffairApplyBiz;
import com.neuq.biz.imp.AffairApplyBizImp;
import com.neuq.entities.Affairs;
import com.neuq.entities.Worker;

/**
 * Servlet implementation class CheckAffairs
 */
@WebServlet("/CheckAffairs")
public class CheckAffairs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckAffairs() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		/**
		 * 从jsp页面获取输入值到Affairs 对象
		 * 
		 * 调用SubmitApply方法将对象存进数据库
		 */
		// HttpSession session=request.getSession();
		AffairApplyBiz affairapply = new AffairApplyBizImp();
		Affairs affair = new Affairs();
		// 接收事务名称，发送者姓名，接收者姓名，内容
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		Worker sender = new Worker();
		String senderid = (String) session.getAttribute("id");
		sender.setId(Integer.parseInt(senderid));
		Worker receiver = new Worker();
		String receiverid = request.getParameter("manager");
		receiver.setId(Integer.parseInt(receiverid));

		String content = request.getParameter("content");

		affair.setTitle(title);
		affair.setSender(sender);
		affair.setReceiver(receiver);
		affair.setContent(content);

		try {
			if (affairapply.SubmitApply(affair)) {
			} else {
				out.println("操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("queryApply");

	}

}
