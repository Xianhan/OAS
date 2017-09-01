package com.neuq.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author dell
 * 会议信息表
 */
public class Meeting implements Serializable{
	
	private long id;	//会议id
	private String title;	//标题
	private Date meetingTime;	//会议内容
	private Date pubTime;	//发布时间
	private String content;		//内容
	private int promulgator;	//发布者
	
	
	
	
	public Meeting() {
		
	}


	public Meeting(long id, String title, Date meetingTime, Date pubTime, String content, int promulgator) {
		super();
		this.id = id;
		this.title = title;
		this.meetingTime = meetingTime;
		this.pubTime = pubTime;
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


	public Date getMeetingTime() {
		return meetingTime;
	}


	public void setMeetingTime(Date meetingTime) {
		this.meetingTime = meetingTime;
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


	public int getPromulgator() {
		return promulgator;
	}


	public void setPromulgator(int promulgator) {
		this.promulgator = promulgator;
	}


	@Override
	public String toString() {
		return "Meeting [id=" + id + ", title=" + title + ", meetingTime=" + meetingTime + ", pubTime=" + pubTime
				+ ", content=" + content + ", promulgator=" + promulgator + "]";
	}
	
	
}
