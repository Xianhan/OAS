package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IManageSalDao;
import com.neuq.entities.Salary;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

import oracle.sql.DATE;

public class ManageSalDaoImp implements IManageSalDao {
	// ��ѯ�����˵Ĺ���
	public List<Salary> checkSal(Connection con) throws SQLException {
		List<Salary> psal = new ArrayList<Salary>();
		String sql = "select w.id, w.realname,s.saldate,s.salary,s.bonus,s.tax,s.attendantsal,s.realsal,s.salid from tab_worker w,tab_salary s where w.id=s.worker";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Salary s = new Salary();
			s.setSalDate(rs.getDate(3));
			s.setSalary(rs.getInt(4));
			s.setBonus(rs.getInt(5));
			s.setTax(rs.getInt(6));
			s.setAttendantsal(rs.getInt(7));
			s.setRealsal(rs.getInt(8));

			Worker w = new Worker();
			w.setId(rs.getInt(1));
			w.setRealname(rs.getString(2));
			s.setSalId(rs.getInt(9));
			s.setWorker(w);
			psal.add(s);

		}
		DBUtil.closeDB(rs,pst);
		return psal;
	}

	// 根据id查看
	public Salary checkSal(int salid, Connection con) throws SQLException {
		Salary s = new Salary();

		String sql = "select w.id, w.realname,s.saldate,s.salary,s.bonus,s.tax,s.attendantsal,s.realsal,s.salid from tab_worker w,tab_salary s where w.id=s.worker and salid="
				+ salid + "";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs = pst.executeQuery();
		if (rs.next()) {
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
			s.setSalId(rs.getInt(9));
			// pst.setInt(9, s.getWorker().getId());
		}
		System.out.println(s);
		DBUtil.closeDB(rs);
		DBUtil.closeDB(pst);
		return s;
	}

	// ���Ա������
	public boolean saveSal(Salary s, Connection con) throws SQLException {
		boolean b = false;
		String sql = "insert into tab_salary values(?,?,?,?,?,?,?,tab_sal_seq.nextval)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, s.getWorker().getId());
		pst.setDate(2, new java.sql.Date(s.getSalDate().getTime()));
		pst.setInt(3, s.getSalary());
		pst.setInt(4, s.getBonus());
		pst.setInt(5, s.getTax());
		pst.setInt(6, s.getAttendantsal());
		pst.setInt(7, s.getRealsal());
		int n = pst.executeUpdate();

		if (n > 0) {
			b = true;
		}
		DBUtil.closeDB(pst);
		
		return true;
	}

	public boolean updateSal(Salary s, Connection con) throws SQLException {
		boolean b = false;

		String sql = "update tab_salary set saldate=?,salary=?,bonus=?,tax=?,attendantsal=?,realsal=?  where salid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		// pst.setInt(1, s.getWorker().getId());
		pst.setDate(1, new java.sql.Date(s.getSalDate().getTime()));
		pst.setInt(2, s.getSalary());
		pst.setInt(3, s.getBonus());
		pst.setInt(4, s.getTax());
		pst.setInt(5, s.getAttendantsal());
		pst.setInt(6, s.getRealsal());
		pst.setInt(7, s.getSalId());
		int n = pst.executeUpdate();
		if (n > 0)
			b = true;
		DBUtil.closeDB(pst);
		return b;

	}

	public List<Salary> pagingWorker(int start, int end, Connection con) throws SQLException {
		String sql = "SELECT id,saldate,salary ,bonus,tax,attendantsal,realsal FROM "
				+ "(SELECT ROWNUM nu,tw.id,tw.realname,tw.sex,ts.saldate,ts.salary,ts.bonus,ts.tax,ts.attendantsal,ts.realsal from tab_worker tw,tab_salary ts where ts.worker=tw.id ) "
				+ " WHERE nu>=? AND nu<=?";
		List<Salary> pWorker = new ArrayList<Salary>();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, start);
		pst.setInt(2, end);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Salary s = new Salary();
			s.setSalDate(rs.getDate(2));
			s.setSalary(rs.getInt(3));
			s.setBonus(rs.getInt(4));
			s.setTax(rs.getInt(5));
			s.setAttendantsal(rs.getInt(6));
			s.setRealsal(rs.getInt(7));

			Worker w = new Worker();
			w.setId(rs.getInt(1));
			w.setRealname(rs.getString(2));
			s.setWorker(w);
			pWorker.add(s);
		}

		DBUtil.closeDB(pst, rs);
		return pWorker;

	}

}
