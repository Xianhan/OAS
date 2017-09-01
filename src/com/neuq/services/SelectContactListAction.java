package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.ContactListBizImp;
import com.neuq.entities.Worker;


	public class SelectContactListAction extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			 response.setContentType("text/html");
			 request.setCharacterEncoding("UTF-8");
			 response.setCharacterEncoding("UTF-8");
			
			 
				
				PrintWriter out = response.getWriter();
	         
			 String str=request.getParameter("realname");
			 str=java.net.URLDecoder.decode(str,"utf-8");
			 //System.out.println(str);
			 ContactListBizImp ctbi=new ContactListBizImp();
			 List<Worker> ws=ctbi.SelectContactListNameBiz(str);
			 String s="";
			 for(int i=0;i<ws.size();i++){
			   s+="<h4>查询结果<br></h4><table class=tab><tr>"
	           +"<td class=first>ID</td><td class=first> RealName</td><td class=first> Email</td><td class=first> Phone</td>"
	           + "</tr><tr><td class=td>"+ws.get(i).getId()+"</td><td class=td>"+ws.get(i).getRealname()+"</td><td class=td>"+ws.get(i).getEmail()+"</td><td class=td>"+ws.get(i).getPhone()+"</td> </tr></table>";
					 
			 }

			out.println(s);
			out.flush();
			out.close();
			 
		
			// } 
		
	}	
}
