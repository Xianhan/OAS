package com.neuq.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

/**
 * ��ȡ�������Ӷ���
 * @return
 */
	public static Connection getConnection() {
//		Connection con = null;
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		String user = "db_neuq";
//		String password = "pwd";
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Context context;
		Connection conn=null;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource)
			context.lookup("java:comp/env/jdbc/OAS");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	/**
	 * �ر�Connection��ResultSet,PreparedStatement�ķ���
	 * @param args
	 */
	public static void closeDB(Object... args) {
		if (args == null) {
			return;
		}
		try {
			for (int i = 0; i < args.length; i++) {
				if (args[i] != null && args[i] instanceof PreparedStatement) {
					((PreparedStatement) args[i]).close();
				}
				if (args[i] != null && args[i] instanceof Connection) {
					((Connection) args[i]).close();
				}
				if (args[i] != null && args[i] instanceof ResultSet) {
					((ResultSet) args[i]).close();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
