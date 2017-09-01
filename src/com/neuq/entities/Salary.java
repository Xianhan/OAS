package com.neuq.entities;

import java.util.Date;
/**
 * 
 * @author dell
 * н���
 */
public class Salary {
	private Worker worker;	//Ա��
	private Date salDate;	//����
	private int salary;		//��н
	private int bonus;		//����
	private int tax;		//˰��
	private int attendantSal;//��ȱ�ڿ˿۹���
	private int realSal;	//ʵ������
	private int salId;
	
	
	public Salary() {
		super();
	}
	public Salary(Worker worker, Date salDate, int salary, int bonus, int tax, int attendantsal, int realsal) {
		super();
		this.worker = worker;
		this.salDate = salDate;
		this.salary = salary;
		this.bonus = bonus;
		this.tax = tax;
		this.attendantSal = attendantsal;
		this.realSal = realsal;
	}
	
	public int getAttendantSal() {
		return attendantSal;
	}
	public void setAttendantSal(int attendantSal) {
		this.attendantSal = attendantSal;
	}
	public int getRealSal() {
		return realSal;
	}
	public void setRealSal(int realSal) {
		this.realSal = realSal;
	}
	public int getSalId() {
		return salId;
	}
	public void setSalId(int salId) {
		this.salId = salId;
	}
	
	
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Date getSalDate() {
		return salDate;
	}
	public void setSalDate(Date salDate) {
		this.salDate = salDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getAttendantsal() {
		return attendantSal;
	}
	public void setAttendantsal(int attendantsal) {
		this.attendantSal = attendantsal;
	}
	public int getRealsal() {
		return realSal;
	}
	public void setRealsal(int realsal) {
		this.realSal = realsal;
	}
	@Override
	public String toString() {
		return "Salary [worker=" + worker + ", salDate=" + salDate + ", salary=" + salary + ", bonus=" + bonus
				+ ", tax=" + tax + ", attendantSal=" + attendantSal + ", realSal=" + realSal + ", salId=" + salId + "]";
	}
	
	
	
}
