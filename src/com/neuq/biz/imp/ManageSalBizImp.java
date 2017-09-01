package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IManageSalBiz;
import com.neuq.dao.IManageSalDao;
import com.neuq.dao.imp.ManageSalDaoImp;
import com.neuq.entities.Salary;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

public class ManageSalBizImp implements IManageSalBiz {

	IManageSalDao imd = new ManageSalDaoImp();

	public List<Salary> checkSal() {
		List<Salary> psal = new ArrayList<Salary>();
		Connection con = DBUtil.getConnection();
		try {
			psal = imd.checkSal(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return psal;
	}

	public Salary checkSal(int id) {
		Salary s = new Salary();
		Connection con = DBUtil.getConnection();
		try {
			s = imd.checkSal(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return s;
	}

	public boolean saveSal(Salary s) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = imd.saveSal(s, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return true;
	}

	public boolean updateSal(Salary s) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = imd.updateSal(s, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return true;
	}

	public List<Salary> pagingWorker(int start, int end) {
		List<Salary> pWorker = new ArrayList<Salary>();
		Connection con = DBUtil.getConnection();
		try {
			pWorker = imd.pagingWorker(start, end, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}

		return pWorker;
	}

}
