package com.neuq.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * �����
 * 
 * @author MQL
 *
 */
public class Announcement implements Serializable {
	private long id;// ����id
	private String title;//�������
	private Date punTime;//���淢��ʱ��
	private String content;//��������
	private Worker promulgator;//���淢����
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * ȫ���췽��
	 * @param id
	 * @param title
	 * @param punTime
	 * @param content
	 * @param promulgator
	 */
	public Announcement(long id, String title, Date punTime, String content, Worker promulgator) {
		super();
		this.id = id;
		this.title = title;
		this.punTime = punTime;
		this.content = content;
		this.promulgator = promulgator;
	}

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
	public Date getPunTime() {
		return punTime;
	}
	public void setPunTime(Date punTime) {
		this.punTime = punTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Worker getPromulgator() {
		return promulgator;
	}
	public void setPromulgator(Worker promulgator) {
		this.promulgator = promulgator;
	}
	@Override
	public String toString() {
		return "Announcement [id=" + id + ", title=" + title + ", punTime=" + punTime + ", content=" + content
				+ ", promulgator=" + promulgator + "]";
	}
	
}
