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
	 * ��ѯ��ǰ�û�������Ϣ�б�
	 */
	@Override
	public List<Messages> selectMessages(int id, Connection con) throws SQLException {
		List<Messages> list = new ArrayList<Messages>();
		ResultSet rs = null;
		Statement st = null;// ��ѯ��Ϣ�б��Statement����
		Messages messages = null;
		String sql = "SELECT *FROM tab_messages WHERE sender = " + id + " OR receiver = " + id + " ORDER BY id DESC";
		st = con.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			messages = new Messages();
			messages.setId(rs.getLong(1));
			// ��ȡ������
			Worker sender = new Worker();
			int senderID = rs.getInt(2);
			IWorkerDao iwd = new WorkerDaoImp();
			sender = iwd.queryWorker(senderID, con);
			messages.setSender(sender);

			// ��ȡ������
			Worker receiver = new Worker();
			int receiverID = rs.getInt(3);
			receiver = iwd.queryWorker(receiverID, con);
			messages.setReceiver(receiver);
			messages.setContent(rs.getString(4));	
			messages.setSendTime(rs.getTimestamp(5));//��ȡʱ��
			messages.setIsRead(rs.getInt(6));
			list.add(messages);
		}

		DBUtil.closeDB(rs, st);
		return list;
	}

	/**
	 * ɾ����Ϣ
	 */
	@Override
	public boolean deleteMessages(long id, Connection con) throws SQLException {
		String sql = "Delete from tab_messages where id=" + id;
		Statement stmt = con.createStatement();// ����Statement
		int result = stmt.executeUpdate(sql);

		DBUtil.closeDB(stmt);// �ر�Statement������

		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * ������Ϣ
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
	 * �޸���Ϣ
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
	 * ��ѯ�м���δ����Ϣ
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
