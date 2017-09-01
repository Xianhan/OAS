package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.biz.IScheduleBiz;
import com.neuq.dao.IScheduleDao;
import com.neuq.dao.imp.ScheduleDaoImp;
import com.neuq.entities.Schedule;
import com.neuq.util.DBUtil;

public class ScheduleBizImp implements IScheduleBiz {

	@Override
	// 增
	public boolean AddSchedule(Schedule s) {
		IScheduleDao isd = new ScheduleDaoImp();
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = isd.AddSchedule(con, s);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	// 删
	public boolean DelSchedule(int userId) {
		IScheduleDao isd = new ScheduleDaoImp();
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = isd.DelSchedule(con, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	// 改
	public boolean UpdateSchedule(Schedule s) {
		IScheduleDao isd = new ScheduleDaoImp();
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = isd.UpdateSchedule(con, s);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	// 查
	public List<Schedule> SelectSchedule(int id) {
		IScheduleDao isd = new ScheduleDaoImp();
		Connection con = DBUtil.getConnection();
		List<Schedule> list = null;
		try {
			list = isd.SelectSchedule(con, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return list;
	}

	@Override
	public List<Schedule> UpdateSelectSchedule(int scheId) {
		IScheduleDao isd = new ScheduleDaoImp();
		Connection con = DBUtil.getConnection();
		List<Schedule> list = null;
		list = isd.UpdateSelectSchedule(con, scheId);

		DBUtil.closeDB(con);

		return list;
	}

}
