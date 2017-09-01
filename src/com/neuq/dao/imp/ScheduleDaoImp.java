package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IScheduleDao;
import com.neuq.entities.Schedule;
import com.neuq.util.DBUtil;

public class ScheduleDaoImp implements IScheduleDao {

	@Override
	// 增
	public boolean AddSchedule(Connection con, Schedule s) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement pst = con.prepareStatement("insert into tab_Schedule values(?,?,?,?,tab_sche_seq.nextval)");
		pst.setString(1, s.getTitle());
		pst.setTimestamp(2, new java.sql.Timestamp(s.getPubTime().getTime()));
		pst.setString(3, s.getContent());
		pst.setInt(4, s.getUserId());
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	// 删
	public boolean DelSchedule(Connection con, int userId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst = con.prepareStatement("delete from tab_schedule where scheid=? ");
		pst.setInt(1, userId);
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0)
			return true;
		else
			return false;
	}

	@Override
	// 改
	public boolean UpdateSchedule(Connection con, Schedule s) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst = con
				.prepareStatement("update tab_schedule set title=?,pubtime=?,content=? where scheid=? ");
		pst.setString(1, s.getTitle());
		pst.setTimestamp(2, new java.sql.Timestamp(s.getPubTime().getTime()));
		pst.setString(3, s.getContent());
		pst.setInt(4, s.getScheId());
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0)
			return true;
		else
			return false;
	}

	@Override
	// 查
	public List<Schedule> SelectSchedule(Connection con, int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Schedule> ss = new ArrayList<Schedule>();
		pst = con.prepareStatement("SELECT * FROM tab_schedule where userid=?");
		pst.setInt(1, id);
		rs = pst.executeQuery();
		while (rs.next()) {
			Schedule s = new Schedule();
			s.setTitle(rs.getString(1));
			s.setPubTime(rs.getTimestamp(2));
			s.setContent(rs.getString(3));
			s.setUserId(rs.getInt(4));
			s.setScheId(rs.getInt(5));
			ss.add(s);
		}
		DBUtil.closeDB(rs, pst);
		return ss;
	}

	// 改的查询
	public List<Schedule> UpdateSelectSchedule(Connection con, int scheId) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Schedule> ss = new ArrayList<Schedule>();
		try {
			pst = con.prepareStatement("select * from tab_schedule where scheid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setInt(1, scheId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = pst.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				Schedule s = new Schedule();
				s.setTitle(rs.getString(1));
				s.setPubTime(rs.getTimestamp(2));
				s.setContent(rs.getString(3));
				s.setUserId(rs.getInt(4));
				s.setScheId(rs.getInt(5));
				ss.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeDB(rs, pst);
		return ss;
	}
	

}
