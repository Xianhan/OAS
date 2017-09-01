package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IMessagesBiz;
import com.neuq.dao.IMessagesDao;
import com.neuq.dao.imp.MessagesDaoImp;
import com.neuq.entities.Messages;
import com.neuq.util.DBUtil;

public class MessagesBizImp implements IMessagesBiz {

	IMessagesDao imd = new MessagesDaoImp();

	@Override
	// 根据当前用户id查询信息
	public List<Messages> selectMessages(int id) {
		Connection con = DBUtil.getConnection();
		List<Messages> list = new ArrayList<Messages>();
		try {
			list = imd.selectMessages(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return list;
	}

	// 根据信息id号删除信息
	@Override
	public boolean deleteMessages(long id) {
		Connection con = DBUtil.getConnection();
		boolean flag = false;
		try {
			flag = imd.deleteMessages(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return flag;
	}

	// 添加新信息、往数据库添加信息
	@Override
	public boolean addMessages(Messages messages) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = imd.addMessages(messages, con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	// 修改信息阅读状态为1
	@Override
	public boolean updateMessagesStatus(long id) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = imd.updateMessagesStatus(id, con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
	//查询有几条未读消息
	@Override
	public int NumUnread(long recevierId) {
		Connection con = DBUtil.getConnection();
		int count = 0;
		try {
			count = imd.NumUnread(recevierId, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return count;
	}

}
