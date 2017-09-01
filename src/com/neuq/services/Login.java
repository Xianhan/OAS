package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.entities.Worker;

/**
 * ����û���¼
 * 
 * @author MQL
 *
 */
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String txt_yzm = request.getParameter("txt_yzm");
		String img_yzm = (String) session.getAttribute("rand");
		boolean b = false;
		if (username == null || username == "" || username.length() <= 0) {

			if (img_yzm.equals(txt_yzm)) {
				b = true;
			}
			out.println(b);
		} else {
			String yzm = request.getParameter("yzm");

			if (!(img_yzm.equals(yzm))) {
				out.print("验证码错误");
				return;
			}
			Worker worker = new Worker();
			worker.setId(Integer.parseInt(username));
			worker.setPassword(password);
			IWorkerBiz iwb = new WorkerBizImp();
			Worker curWorker = new Worker();
			curWorker = iwb.queryWorker(Integer.parseInt(username));

			if (iwb.checkLogin(worker)) {
				session.setAttribute("realname", curWorker.getRealname());
				session.setAttribute("id", username);

				if ((curWorker.getManager().getId() > 0)) {
					response.sendRedirect("index.html");
				} else {
					response.sendRedirect("admin/index.html");
				}
			}

			else {
				out.print("用户名或密码错误<a href='login.jsp'>点此</a>重新登录");
			}
		}
		out.flush();
		out.close();
	}

}
