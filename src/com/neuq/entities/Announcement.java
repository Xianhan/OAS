package com.neuq.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告表
 * 
 * @author MQL
 *
 */
public class Announcement implements Serializable {
	private long id;// 公告id
	private String title;//公告标题
	private Date punTime;//公告发布时间
	private String content;//公告内容
	private Worker promulgator;//公告发布者
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 全构造方法
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
