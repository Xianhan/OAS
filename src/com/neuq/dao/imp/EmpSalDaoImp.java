package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IEmpSalDao;
import com.neuq.entities.Salary;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

public class EmpSalDaoImp implements IEmpSalDao {
	public List<Salary> checkSal(int id, Connection con) throws SQLException {
		List<Salary> ls = new ArrayList<Salary>();
		String sql = "select w.id, w.realname,s.saldate,s.salary,s.bonus,s.tax,s.attendantsal,s.realsal from tab_worker w,tab_salary s where w.id=s.worker and id="
				+ id + "";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs = pst.executeQuery();
		while (rs.next()) {
			Salary s = new Salary();
			Worker w = new Worker();
			w.setId(rs.getInt(1));
			w.setRealname(rs.getString(2));
			s.setWorker(w);
			s.setSalDate(rs.getDate(3));
			s.setSalary(rs.getInt(4));
			s.setBonus(rs.getInt(5));
			s.setTax(rs.getInt(6));
			s.setAttendantsal(rs.getInt(7));
			s.setRealsal(rs.getInt(8));
			ls.add(s);
		}
		DBUtil.closeDB(rs,pst);
		return ls;
	}

}
