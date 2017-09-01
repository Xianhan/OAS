package com.neuq.entities;

import java.io.Serializable;
/**
 * ����Ϣ��
 * @author MQL
 *
 */
import java.util.Date;
public class Messages implements Serializable {
	private long id;//����ϢID
	private Worker sender;//��Ϣ������
	private Worker receiver;//��Ϣ������
	private String content;//�¼�����
	private Date sendTime;//��Ϣ����ʱ��
	private int isRead;//��Ϣ״̬   0��δ��  1���Ѷ�
	
	public Messages() {
		super();
	}
	/**
	 * ȫ���췽��
	 * @param id
	 * @param sender
	 * @param receiver
	 * @param content
	 * @param sendTime
	 * @param isRead
	 */
	public Messages(long id, Worker sender, Worker receiver, String content, Date sendTime, int isRead) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.sendTime = sendTime;
		this.isRead = isRead;
	}

	public long getId() {
		return id;
	}
	public void setId(long iD) {
		id = iD;
	}
	public Worker getSender() {
		return sender;
	}
	public void setSender(Worker sender) {
		this.sender = sender;
	}
	public Worker getReceiver() {
		return receiver;
	}
	public void setReceiver(Worker receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	@Override
	public String toString() {
		return "Messages [ID=" + id + ", sender=" + sender + ", receiver=" + receiver + ", content=" + content
				+ ", sendTime=" + sendTime + ", isRead=" + isRead + "]";
	}
}
