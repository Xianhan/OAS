package com.neuq.services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
/**
 * 此servlet用于获得可下载的文件名称
 * @author MQL
 *
 */

@WebServlet("/WatchAction")
public class WatchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WatchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");			
		PrintWriter out = response.getWriter();

				    File fi=new File("F:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\OAS\\files");
				    if(!(fi.exists())){
				    	fi.mkdir();
				    }
						File [] ls=fi.listFiles();
						String files="";
						for(File file:ls)
							{
							files+="<tr><td class=\"first\">"+file.getName()+"</td><td class=\"td\"><a href=DownLoad?path="+file.getName()+">下载</a></td></tr><br>";

						
							}
	out.print("<link href=\"../css/Table.css\" rel=\"stylesheet\" type=\"text/css\"/><div id=\"box\"><div id=\"pos\">"+files+"</div></div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
