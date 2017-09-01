package com.neuq.entities;

import java.io.Serializable;

/**
 * ְ����
 * @author MQL
 *
 */
public class Job implements Serializable{
	
	private int id;   //ְλid
	private String job;//ְλ����
	/**
	 * �չ��췽��
	 */
	public Job() {
		super();
	}
	
	/**
	 * ȫ���췽��
	 * @param id
	 * @param job
	 */
	public Job(int id, String job) {
		super();
		this.id = id;
		this.job = job;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", job=" + job + "]";
	}
}
