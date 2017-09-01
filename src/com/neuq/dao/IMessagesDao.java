package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Messages;

public interface IMessagesDao {

	public List<Messages> selectMessages(int id,Connection con) throws SQLException;//查看当前用户id下的短消息列表
	public boolean deleteMessages(long id, Connection con) throws SQLException;//删除消息
	public boolean addMessages(Messages messages, Connection con) throws SQLException;//新增消息
	boolean updateMessagesStatus(long id, Connection con) throws SQLException;//修改信息的阅读状态为已读
	public int NumUnread(long recevierId, Connection con) throws SQLException;//查询未读消息数目
	
}
