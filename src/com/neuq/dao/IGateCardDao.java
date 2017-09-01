package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.AllSignON;
import com.neuq.entities.GateCard;

public interface IGateCardDao {
	/**
	 * 签到
	 * @param gatecard
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean signOn(GateCard gatecard,Connection con) throws SQLException;
	/**
	 * 签退
	 * @param gatecard
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean signOut(GateCard gatecard,Connection con) throws SQLException;
	/**
	 * 查询是否已经签到
	 * @param id
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean querySignon(int id,Connection con) throws SQLException;
	/**
	 * 查询本月签到多少天
	 * @param id
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public int queryDays(int id,Connection con) throws SQLException;
	/**
	 * 查某月签到的详细信息
	 * @param id
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<GateCard> signOnDetail(int id,String date,Connection con) throws SQLException;
	/**
	 * 管理员查看所有员工签到情况
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<AllSignON> allSignOn(Connection con) throws SQLException;
}
