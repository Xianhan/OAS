package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuq.dao.IMessagesDao;
import com.neuq.dao.IWorkerDao;
import com.neuq.entities.Messages;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;
import com.neuq.util.DateUtil;

public class MessagesDaoImp implements IMessagesDao {

	/**
	 * 查询当前用户所有消息列表
	 */
	@Override
	public List<Messages> selectMessages(int id, Connection con) throws SQLException {
		List<Messages> list = new ArrayList<Messages>();
		ResultSet rs = null;
		Statement st = null;// 查询信息列表的Statement对象
		Messages messages = null;
		String sql = "SELECT *FROM tab_messages WHERE sender = " + id + " OR receiver = " + id + " ORDER BY id DESC";
		st = con.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			messages = new Messages();
			messages.setId(rs.getLong(1));
			// 获取发送者
			Worker sender = new Worker();
			int senderID = rs.getInt(2);
			IWorkerDao iwd = new WorkerDaoImp();
			sender = iwd.queryWorker(senderID, con);
			messages.setSender(sender);

			// 获取接受者
			Worker receiver = new Worker();
			int receiverID = rs.getInt(3);
			receiver = iwd.queryWorker(receiverID, con);
			messages.setReceiver(receiver);
			messages.setContent(rs.getString(4));	
			messages.setSendTime(rs.getTimestamp(5));//获取时间
			messages.setIsRead(rs.getInt(6));
			list.add(messages);
		}

		DBUtil.closeDB(rs, st);
		return list;
	}

	/**
	 * 删除信息
	 */
	@Override
	public boolean deleteMessages(long id, Connection con) throws SQLException {
		String sql = "Delete from tab_messages where id=" + id;
		Statement stmt = con.createStatement();// 创建Statement
		int result = stmt.executeUpdate(sql);

		DBUtil.closeDB(stmt);// 关闭Statement和连接

		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 插入信息
	 */
	@Override
	public boolean addMessages(Messages messages, Connection con) throws SQLException {
		PreparedStatement pst = null;
		String addsql = "INSERT INTO tab_messages VALUES(tab_messages_seq.nextval,?,?,?,DEFAULT,DEFAULT)";
		pst = con.prepareStatement(addsql);

		pst.setLong(1, messages.getSender().getId());
		pst.setLong(2, messages.getReceiver().getId());
		pst.setString(3, messages.getContent());
		int count = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改信息
	 */
	@Override
	public boolean updateMessagesStatus(long id, Connection con) throws SQLException {
		String updateSql = "UPDATE tab_messages SET isread = 1 WHERE Id=" + id;
		Statement st = con.createStatement();
		int count = st.executeUpdate(updateSql);
		System.out.println(count);
		DBUtil.closeDB(st);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 查询有几条未读消息
	 */
	@Override
	public int NumUnread(long recevierId,Connection con)throws SQLException {
		String sql = "SELECT COUNT(*) FROM tab_messages WHERE receiver = "+recevierId+" AND isread=0";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		DBUtil.closeDB(st,rs);
		return count;
	}

}
