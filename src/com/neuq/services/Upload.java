package com.neuq.services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class Upload extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setMaxFileSize(1024 * 1024 * 3);
		su.setTotalMaxFileSize(1024 * 1024 * 3 * 10);
		try {
			su.upload();
			SmartFiles sfs = su.getFiles();
			// 确定路径
			// 获取当前项目的绝对路径
			String path = request.getRealPath("/");
			File f = new File(path + "/files");
			if (!f.exists()) {
				System.out.println("路径不存在");
				f.mkdir();
			}

			for (int i = 0; i < sfs.getCount(); i++) {
				SmartFile sf = sfs.getFile(i);
				if (sf.getSize() > 0) {
					sf.saveAs("/files/" + sf.getFileName());
				}
			}
			out.println("文件上传成功！");

		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.flush();
		out.close();
	}

	

}
