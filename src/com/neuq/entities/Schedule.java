package com.neuq.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * �ճ̱�
 * @author MQL
 *
 */
public class Schedule implements Serializable {
	private int scheId;
	private String title; //�ճ̱���
	private Date pubTime; //�ճ�ʱ��
	private String content; //�ճ�����
	private int userId;//�ճ������û�
	
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Schedule(String title, Date pubTime, String content, int userId) {
		super();
		this.title = title;
		this.pubTime = pubTime;
		this.content = content;
		this.userId = userId;
	}

	public int getScheId() {
		return scheId;
	}

	public void setScheId(int scheId) {
		this.scheId = scheId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Schedule [title=" + title + ", pubTime=" + pubTime + ", content=" + content + ", userId=" + userId
				+ "]";
	}
	
}
