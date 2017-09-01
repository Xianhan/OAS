package com.neuq.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Worker implements Serializable{
	public static int number;
	public static ArrayList<String> wkList=new ArrayList<String>();
	private int id;//Ա��ID
	private String realname;//Ա����ʵ����
	private String password;//Ա����¼����
	private String email;//Ա������
	private long phone;//Ա���ֻ�����
	private String sex;//Ա���Ա�
	private Date hiredate;//��Ӷ����
	private Job job;//Ա��ְλ
	private String address;//��ͥסַ
	private int status;//Ա��״̬
	private Worker manager;//Ա������
	



	/**
	 * ��worker���췽��
	 */
	public Worker() {
		
	}
	
	
	/**
	 * ȫ���췽��
	 * @param id
	 * @param realname
	 * @param password
	 * @param email
	 * @param phone
	 * @param sex
	 * @param hiredate
	 * @param job
	 * @param address
	 * @param status
	 * @param manager
	 */
	
	public Worker(int id, String realname, String password, String email, long phone, String sex, Date hiredate,
			Job job, String address, int status, Worker manager) {
		super();
		this.id = id;
		this.realname = realname;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.hiredate = hiredate;
		this.job = job;
		this.address = address;
		this.status = status;
		this.manager = manager;
	}



	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Worker getManager() {
		return manager;
	}
	public void setManager(Worker manager) {
		this.manager = manager;
	}
	
	
	
	@Override
	public String toString() {
		return "Worker [id=" + id + ", realname=" + realname + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", sex=" + sex + ", hiredate=" + hiredate + ", job=" + job + ", address="
				+ address + ", status=" + status + ", manager=" + manager + "]";
	}


	
}
