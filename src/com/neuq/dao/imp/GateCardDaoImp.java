package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.neuq.dao.IGateCardDao;
import com.neuq.entities.AllSignON;
import com.neuq.entities.GateCard;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

public class GateCardDaoImp implements IGateCardDao {

	@Override
	public boolean signOn(GateCard gatecard, Connection con) throws SQLException {
		String sql = "insert into tab_gatecard(worker,arrivetime,islate) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, gatecard.getWorker().getId());
		pst.setTimestamp(2, new java.sql.Timestamp(gatecard.getArriveTime().getTime()));
		Time arriveTime = new Time(gatecard.getArriveTime().getHours(), gatecard.getArriveTime().getMinutes(), gatecard.getArriveTime().getSeconds());
		if (arriveTime.compareTo(new Time(9, 0, 0)) > 0) {
			pst.setInt(3, 1);
		} else {
			pst.setInt(3, 0);
		}
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean signOut(GateCard gatecard, Connection con) throws SQLException {

		String sql = "update tab_gatecard set leavetime=?,isleaveearly=? where worker=? and to_char(arrivetime,'yyyy-mm-dd')=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setTimestamp(1, new java.sql.Timestamp(gatecard.getLeaveTime().getTime()));
		Time leaveTime = new Time(gatecard.getLeaveTime().getTime());

		System.out.println(leaveTime.compareTo(new Time(17, 0, 0)) < 0);
		if (new Time(leaveTime.getHours(), leaveTime.getMinutes(), leaveTime.getSeconds())
				.compareTo(new Time(17, 0, 0)) > 0) {

			pst.setInt(2, 0);
		} else {
			pst.setInt(2, 1);
		}
		pst.setInt(3, gatecard.getWorker().getId());
		pst.setString(4, new java.sql.Date(gatecard.getLeaveTime().getTime()).toString());
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean querySignon(int id, Connection con) throws SQLException {
		boolean b = false;
		String sql = "select * from tab_gatecard where worker=? and to_char(arrivetime,'yyyy-mm-dd')=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.setString(2, new java.sql.Date(new Date().getTime()).toString());
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			b = true;
		}
		DBUtil.closeDB(pst, rs);
		return b;
	}

	@Override
	public int queryDays(int id, Connection con) throws SQLException {
		int n = 0;
		String sql = "select count(*) from tab_gatecard where to_char(arrivetime,'yyyy-mm')=? and worker =?";
		PreparedStatement pst = con.prepareStatement(sql);
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		if (("" + month).length() < 2)
			pst.setString(1, year + "-" + ("0" + month));
		pst.setInt(2, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			n = rs.getInt(1);
		}
		DBUtil.closeDB(pst, rs);
		return n;
	}

	@Override
	public List<GateCard> signOnDetail(int id, String date, Connection con) throws SQLException {
		List<GateCard> gateCards = new ArrayList<GateCard>();
		String sql = "select * from tab_gatecard where to_char(arrivetime,'yyyy-mm')=? and worker =?";
		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, date);
		pst.setInt(2, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			GateCard g = new GateCard();
			Worker worker = new Worker();
			worker.setId(rs.getInt(1));
			g.setWorker(worker);
			g.setArriveTime(rs.getTimestamp(2));
			g.setLeaveTime(rs.getTimestamp(3));
			g.setIsLate(rs.getInt(4));
			g.setIsLeaveEarly(rs.getInt(5));

			gateCards.add(g);
		}

		DBUtil.closeDB(rs, pst);

		return gateCards;
	}

	@Override
	public List<AllSignON> allSignOn(Connection con) throws SQLException {
		List<AllSignON> allSignON = new ArrayList<AllSignON>();
		String sql = "SELECT count(*),COUNT(islate),COUNT(isleaveearly),worker,to_char(arrivetime,'yyyy-mm')  FROM tab_gatecard GROUP BY worker,to_char(arrivetime,'yyyy-mm') ORDER BY to_char(arrivetime,'yyyy-mm') desc";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			AllSignON ag = new AllSignON();
			Worker worker = new Worker();
			worker.setId(rs.getInt(4));
			ag.setWorker(worker);
			ag.setLateDays(rs.getInt(2));
			ag.setLeaveearlyDays(rs.getInt(3));
			ag.setArriveDays(rs.getInt(1));
			ag.setMonth(rs.getString(5));
			allSignON.add(ag);
		}
		return allSignON;
	}

}
