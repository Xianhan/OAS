package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Messages;

public interface IMessagesDao {

	public List<Messages> selectMessages(int id,Connection con) throws SQLException;//�鿴��ǰ�û�id�µĶ���Ϣ�б�
	public boolean deleteMessages(long id, Connection con) throws SQLException;//ɾ����Ϣ
	public boolean addMessages(Messages messages, Connection con) throws SQLException;//������Ϣ
	boolean updateMessagesStatus(long id, Connection con) throws SQLException;//�޸���Ϣ���Ķ�״̬Ϊ�Ѷ�
	public int NumUnread(long recevierId, Connection con) throws SQLException;//��ѯδ����Ϣ��Ŀ
	
}
