package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IWorkerBiz;
import com.neuq.dao.IWorkerDao;
import com.neuq.dao.imp.WorkerDaoImp;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

public class WorkerBizImp implements IWorkerBiz {
	IWorkerDao iwd = new WorkerDaoImp();
	boolean res = false;

	@Override
	public boolean checkLogin(Worker worker) {

		Connection con = null;
		con = DBUtil.getConnection();
		try {
			res = iwd.checkLogin(worker, con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return res;
	}

	@Override
	public Worker queryWorker(int id) {
		Connection con = DBUtil.getConnection();
		Worker w = new Worker();
		try {
			w = iwd.queryWorker(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return w;
	}

	@Override
	public List<Worker> selectAllWorker() {
		List<Worker> workerList = new ArrayList<Worker>();
		Connection con = DBUtil.getConnection();
		try {
			workerList = iwd.selectAllWorker(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return workerList;
	}

	@Override
	public List<Worker> pagingWorker(int start, int end) {
		List<Worker> pWorker = new ArrayList<Worker>();
		Connection con = DBUtil.getConnection();
		try {
			pWorker = iwd.pagingWorker(start, end, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}

		return pWorker;
	}

	@Override
	public Worker queryWorker(String realname) {
		Worker w = null;
		Connection con = DBUtil.getConnection();
		try {
			w = iwd.queryWorker(realname, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return w;
	}

	@Override
	public boolean updateWorker(Worker worker) {
		boolean n = false;
		Connection con = DBUtil.getConnection();
		try {
			n = iwd.updateWorker(worker, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public boolean deleteWorker(int id) {
		Connection con = DBUtil.getConnection();
		try {
			res = iwd.deleteWorker(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return res;
	}

	@Override
	public List<Worker> selectAllManager() {
		Connection con = DBUtil.getConnection();
		List<Worker> managerList = new ArrayList<Worker>();
		try {
			managerList = iwd.selectAllManager(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return managerList;
	}

	@Override
	public boolean addWorker(Worker worker) {
		Connection con = DBUtil.getConnection();
		try {
			res = iwd.addWorker(worker, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean updatePwd(Worker worker) {
		Connection con = DBUtil.getConnection();
		try {
			res = iwd.updatePwd(worker, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return res;
	}

}