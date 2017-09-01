package com.neuq.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Messages;

public interface IMessagesBiz {

	public List<Messages> selectMessages(int id);//调用查询消息列表的方法
	public boolean deleteMessages(long id) ;//调用删除消息
	public boolean addMessages(Messages messages) ;//调用新增消息
	boolean updateMessagesStatus(long id);//修改信息阅读状态为1
	int NumUnread(long recevierId);//查询有几条未读消息
}
