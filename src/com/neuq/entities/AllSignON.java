package com.neuq.entities;

public class AllSignON {
	private Worker worker;
	private int lateDays;
	private  int leaveearlyDays;
	private int arriveDays;
	private String month;
	public AllSignON() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public int getLateDays() {
		return lateDays;
	}
	public void setLateDays(int lateDays) {
		this.lateDays = lateDays;
	}
	public int getLeaveearlyDays() {
		return leaveearlyDays;
	}
	public void setLeaveearlyDays(int leaveearlyDays) {
		this.leaveearlyDays = leaveearlyDays;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getArriveDays() {
		return arriveDays;
	}
	public void setArriveDays(int arriveDays) {
		this.arriveDays = arriveDays;
	}
	@Override
	public String toString() {
		return "AllSignON [worker=" + worker + ", lateDays=" + lateDays + ", leaveearlyDays=" + leaveearlyDays
				+ ", arriveDays=" + arriveDays + "]";
	}
}
