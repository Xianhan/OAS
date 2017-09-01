package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IEmpSalBiz;
import com.neuq.dao.IEmpSalDao;
import com.neuq.dao.imp.EmpSalDaoImp;
import com.neuq.entities.Salary;
import com.neuq.util.DBUtil;

public class EmpSalBizImp implements IEmpSalBiz{
	IEmpSalDao isd=new EmpSalDaoImp();
	public List<Salary> checkSal(int id){
		List<Salary> ls = new ArrayList<Salary>();
		Connection con=DBUtil.getConnection();
		Salary s=new Salary();
		try{
			ls=isd.checkSal(id, con);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(con);
		}
		return ls;
	}
}
