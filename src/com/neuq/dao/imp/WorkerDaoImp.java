package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IWorkerDao;
import com.neuq.entities.Job;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

/**
 * 員工Dao
 * 
 * @author MQL
 *
 */
public class WorkerDaoImp implements IWorkerDao {

	@Override
	public boolean checkLogin(Worker worker, Connection con) throws SQLException {
		boolean res = false;
		String sql = "select * from tab_worker where id=? and password=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, worker.getId());
		pst.setString(2, worker.getPassword());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			res = true;
		}
		DBUtil.closeDB(pst, rs);
		return res;
	}

	@Override
	public Worker queryWorker(int id, Connection con) throws SQLException {
		Worker worker = new Worker();
		String sql = "SELECT tw1.ID,tw1.realname,tw1.email,tw1.phone,tw1.sex,tw1.hiredate,job.job,tw1.address,tw1.status,tw1.manager,tw1.password FROM tab_worker tw1,tab_worker tw2,tab_job job"
				+ " WHERE tw1.ID=? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		worker.setId(rs.getInt(1));
		worker.setRealname(rs.getString(2));
		worker.setEmail(rs.getString(3));
		worker.setPhone(rs.getLong(4));
		worker.setSex(rs.getString(5));
		worker.setHiredate(rs.getDate(6));
		Job job = new Job();
		job.setJob(rs.getString(7));
		worker.setJob(job);
		worker.setAddress(rs.getString(8));
		worker.setStatus(rs.getInt(9));
		Worker manager = new Worker();
		manager.setId(rs.getInt(10));
		worker.setManager(manager);
		worker.setPassword(rs.getString(11));
		DBUtil.closeDB(pst, rs);
		return worker;

	}

	@Override
	public List<Worker> selectAllWorker(Connection con) throws SQLException {
		List<Worker> workerList = new ArrayList<Worker>();
		String sql = "select tw.id,tw.realname,tw.sex,tj.job from tab_worker tw,tab_job tj where tj.id=tw.job";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Worker w = new Worker();
			w.setId(rs.getInt(1));
			w.setRealname(rs.getString(2));
			w.setSex(rs.getString(3));
			Job job = new Job();
			job.setJob(rs.getString(4));
			w.setJob(job);
			workerList.add(w);
		}
		DBUtil.closeDB(pst, rs);
		return workerList;
	}

	@Override
	public List<Worker> pagingWorker(int start, int end, Connection con) throws SQLException {
		String sql = "SELECT ID,realname,sex ,job FROM "
				+ "(SELECT ROWNUM nu,tw.id,tw.realname,tw.sex,tj.job from tab_worker tw,tab_job tj where tj.id=tw.job ) "
				+ " WHERE nu>=? AND nu<=?";
		List<Worker> pWorker = new ArrayList<Worker>();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, start);
		pst.setInt(2, end);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Worker w = new Worker();
			w.setId(rs.getInt(1));
			w.setRealname(rs.getString(2));
			w.setSex(rs.getString(3));
			Job job = new Job();
			job.setJob(rs.getString(4));
			w.setJob(job);
			pWorker.add(w);
		}

		DBUtil.closeDB(pst, rs);
		return pWorker;
	}

	@Override
	public Worker queryWorker(String realname, Connection con) throws SQLException {
		String sql = "select tw.*, tj.job from tab_worker tw,tab_job tj where tw.realname=? and tw.job=tj.id ";

		Worker worker = new Worker();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, realname);
		// pst.setString(2, "");
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			worker.setId(rs.getInt(1));
			worker.setRealname(rs.getString(2));
			worker.setPassword(rs.getString(3));
			worker.setEmail(rs.getString(4));
			worker.setPhone(rs.getLong(5));
			worker.setSex(rs.getString(6));
			worker.setHiredate(rs.getDate(7));
			worker.setAddress(rs.getString(9));
			worker.setStatus(rs.getInt(10));
			Worker manager = new Worker();
			manager.setId(rs.getInt(10));
			worker.setManager(manager);
			Job job = new Job();
			job.setJob(rs.getString(12));
			job.setId(rs.getInt(8));
			worker.setJob(job);
		}
		return worker;

	}

	@Override
	public boolean updateWorker(Worker worker, Connection con) throws SQLException {
		boolean b = false;
		String sql = "update tab_worker set realname=?,sex=?,job=?,status=?,manager=? where id=?";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, worker.getRealname());
		pst.setString(2, worker.getSex());
		pst.setInt(3, worker.getJob().getId());
		pst.setInt(4, worker.getStatus());
		pst.setInt(5, worker.getManager().getId());
		pst.setInt(6, worker.getId());
		int n = pst.executeUpdate();
		if (n > 0) {
			b = true;
		}
		DBUtil.closeDB(pst);
		return b;
	}

	@Override
	public boolean deleteWorker(int id, Connection con) throws SQLException {
		String sql = "delete from tab_worker where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int n = pst.executeUpdate();
		if (n > 0) {
			return true;
		}
		return false;

	}

	@Override
	public List<Worker> selectAllManager(Connection con) throws SQLException {
		List<Worker> managerList = new ArrayList<Worker>();
		String sql = "SELECT * FROM tab_worker WHERE nvl(manager,0)=0";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Worker man = new Worker();
			man.setId(rs.getInt(1));
			man.setRealname(rs.getString(2));
			managerList.add(man);
		}
		return managerList;
	}

	@Override
	public boolean addWorker(Worker worker, Connection con) throws SQLException {
		String sql = "insert into tab_worker values(tab_worker_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, worker.getRealname());
		pst.setString(2, worker.getPassword());
		pst.setString(3, worker.getEmail());
		pst.setLong(4, worker.getPhone());
		pst.setString(5, worker.getSex());
		pst.setDate(6, (Date) worker.getHiredate());
		pst.setInt(7, worker.getJob().getId());
		pst.setString(8, worker.getAddress());
		pst.setInt(9, worker.getStatus());
		pst.setInt(10, worker.getManager().getId());
		int n = pst.executeUpdate();
		if (n > 0) {
			return true;
		}
		return false;

	}

	@Override
	public boolean updatePwd(Worker worker, Connection con) throws SQLException {
		String sql = "update tab_worker set password=? where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, worker.getPassword());
		pst.setInt(2, worker.getId());
		int n = pst.executeUpdate();
		if (n > 0) {
			return true;
		} else {
			return false;
		}
	}

}
