package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IGateCardBiz;
import com.neuq.biz.IWorkerBiz;
import com.neuq.biz.imp.GateCardBizImp;
import com.neuq.biz.imp.WorkerBizImp;
import com.neuq.dao.imp.GateCardDaoImp;
import com.neuq.entities.AllSignON;
import com.neuq.entities.Worker;

public class AllSignOnAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		IWorkerBiz iwb = new WorkerBizImp();
		List<AllSignON> allList = new ArrayList<AllSignON>();
		IGateCardBiz igcb = new GateCardBizImp();
		allList = igcb.allSignOn();
		for (AllSignON a : allList) {
			Worker worker = iwb.queryWorker(a.getWorker().getId());
			a.setWorker(worker);
			System.out.print(a.getWorker().getId() + "   " + a.getLateDays() + "  " + a.getLeaveearlyDays() + "  "
					+ a.getArriveDays());
		}
		session.setAttribute("allList", allList);
		response.sendRedirect("admin/allSignOn.jsp");
	}

}
