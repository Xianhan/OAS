package com.neuq.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * 签到签退
 * @author dell
 * 0、否     1、是   
 */
public class GateCard implements Serializable{
	private Worker worker;	//当前员工
	private Date arriveTime;	//签到时间
	private Date leaveTime;	//签退时间
	private int isLate;	//是否迟到
	private int isLeaveEarly; //是否早退

	
	
	
 @Override
	public String toString() {
		return "GateCard [worker=" + worker + ", arriveTime=" + arriveTime + ", isLate=" + isLate + ", isLeaveEarly="
				+ isLeaveEarly + "]";
	}


	public GateCard(Worker worker, Date arriveTime, int isLate, int isLeaveEarly) {
		super();
		this.worker = worker;
		this.arriveTime = arriveTime;
		this.isLate = isLate;
		this.isLeaveEarly = isLeaveEarly;
	}


	public GateCard() {
		super();
	}
	
	
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Date getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
	
	public Date getLeaveTime() {
		return leaveTime;
	}


	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}


	public int getIsLate() {
		return isLate;
	}
	public void setIsLate(int isLate) {
		this.isLate = isLate;
	}
	public int getIsLeaveEarly() {
		return isLeaveEarly;
	}
	public void setIsLeaveEarly(int isLeaveEarly) {
		this.isLeaveEarly = isLeaveEarly;
	}
	
	
	
}	
