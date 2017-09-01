package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IGateCardBiz;
import com.neuq.dao.IGateCardDao;
import com.neuq.dao.imp.GateCardDaoImp;
import com.neuq.entities.AllSignON;
import com.neuq.entities.GateCard;
import com.neuq.util.DBUtil;

public class GateCardBizImp implements IGateCardBiz {
	IGateCardDao igcd = new GateCardDaoImp();

	@Override
	public boolean signOn(GateCard gatecard) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = igcd.signOn(gatecard, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public boolean signOut(GateCard gatecard) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = igcd.signOut(gatecard, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public boolean querySignon(int id) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = igcd.querySignon(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}

		return b;
	}

	@Override
	public int queryDays(int id) {
		Connection con = DBUtil.getConnection();
		int n = 0;
		try {
			n = igcd.queryDays(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return n;
	}

	@Override
	public List<GateCard> signOnDetail(int id, String date) {
		List<GateCard> gatecards = new ArrayList<GateCard>();
		Connection con = DBUtil.getConnection();
		IGateCardDao igcd = new GateCardDaoImp();
		try {
			gatecards = igcd.signOnDetail(id, date, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return gatecards;
	}

	@Override
	public List<AllSignON> allSignOn() {
		List<AllSignON> list = new ArrayList<AllSignON>();
		Connection con = DBUtil.getConnection();
		IGateCardDao igcd = new GateCardDaoImp();
		try {
			list = igcd.allSignOn(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return list;
	}

}
