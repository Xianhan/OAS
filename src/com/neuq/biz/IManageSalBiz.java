package com.neuq.biz;

import java.util.List;

import com.neuq.entities.Salary;

public interface IManageSalBiz {
	//调用查询所有员工工资方法
	public List<Salary> checkSal();
	
	//调用添加员工工资方法
		public boolean saveSal(Salary s);
	//调用修改员工工资方法
		public boolean updateSal(Salary s);
	//调用根据某个人id查询个人工资方法
		public Salary checkSal(int id);
		//分页查询
		public List<Salary> pagingWorker(int start,int end);

		
		
		
}
