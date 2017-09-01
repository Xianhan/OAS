package com.neuq.entities;

import java.io.Serializable;

/**
 * 职务类
 * @author MQL
 *
 */
public class Job implements Serializable{
	
	private int id;   //职位id
	private String job;//职位名称
	/**
	 * 空构造方法
	 */
	public Job() {
		super();
	}
	
	/**
	 * 全构造方法
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
