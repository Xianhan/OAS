package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IContactListDao;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

public class ContactListDaoImp implements IContactListDao {

	@Override
	public List<Worker> selectContactList(Connection con) throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Worker> ws = new ArrayList<Worker>();
		pst = con.prepareStatement("SELECT id,realname,email,phone FROM tab_worker");
		rs = pst.executeQuery();
		while (rs.next()) {
			Worker w = new Worker();
			w.setId(rs.getInt(1));
			w.setRealname(rs.getString(2));
			w.setEmail(rs.getString(3));
			w.setPhone(rs.getLong(4));
			ws.add(w);
		}
		com.neuq.util.DBUtil.closeDB(rs, pst, con);
		return ws;
	}

	public List<Worker> selectContactListName(Connection con, String name) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Worker> ws = new ArrayList<Worker>();
		pst = con.prepareStatement("SELECT id,realname,email,phone FROM tab_worker where realname like ?");
		pst.setString(1, "%" + name + "%");
		rs = pst.executeQuery();
		while (rs.next()) {
			Worker w = new Worker();
			w.setId(rs.getInt(1));
			w.setRealname(rs.getString(2));
			w.setEmail(rs.getString(3));
			w.setPhone(rs.getLong(4));
			ws.add(w);
		}
		com.neuq.util.DBUtil.closeDB(rs, pst, con);
		return ws;
	}


}
