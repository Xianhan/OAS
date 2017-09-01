package com.neuq.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author dell
 *	�����
 */
public class Affairs implements Serializable{
	private long id;	//����id
	private String title;	//��Ŀ
	private Worker sender;	//������
	private Worker receiver;	//������
	private String content;		//����
	private Date sendTime;	//����ʱ��
	private int approvalProgress;		//��������
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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



	public int getApprovalProgress() {
		return approvalProgress;
	}



	public void setApprovalProgress(int approvalProgress) {
		this.approvalProgress = approvalProgress;
	}



	@Override
	public String toString() {
		return "Affairs [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", content=" + content
				+ ", sendTime=" + sendTime + ", approvalProgress=" + approvalProgress + "]";
	}



	public Affairs() {
		super();
	}



	public Affairs(long id, Worker sender, Worker receiver, String content, Date sendTime, int approvalProgress) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.sendTime = sendTime;
		this.approvalProgress = approvalProgress;
	}
	
	
	
}
