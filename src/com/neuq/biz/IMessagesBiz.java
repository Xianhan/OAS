package com.neuq.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Messages;

public interface IMessagesBiz {

	public List<Messages> selectMessages(int id);//���ò�ѯ��Ϣ�б�ķ���
	public boolean deleteMessages(long id) ;//����ɾ����Ϣ
	public boolean addMessages(Messages messages) ;//����������Ϣ
	boolean updateMessagesStatus(long id);//�޸���Ϣ�Ķ�״̬Ϊ1
	int NumUnread(long recevierId);//��ѯ�м���δ����Ϣ
}
