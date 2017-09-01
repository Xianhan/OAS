package com.neuq.biz;

import java.sql.Connection;
import java.util.List;

import com.neuq.entities.AllSignON;
import com.neuq.entities.GateCard;

public interface IGateCardBiz {
	/**
	 * 签到
	 * @param gatecard
	 * @return
	 */
	public boolean signOn(GateCard gatecard) ;
	/**
	 * 签退
	 * @param gatecard
	 * @return
	 */
	
	public boolean signOut(GateCard gatecard) ;
	/**
	 * 查询是否已经签到
	 * @param id
	 * @return
	 */
	public boolean querySignon(int id);
	/**
	 * 查询签到了多少天
	 * @param id
	 * @return
	 */
	public int queryDays(int id);
	/**
	 * 查询本月详细考勤记录
	 * @param id
	 * @return
	 */
	public List<GateCard> signOnDetail(int id,String date);
	/**
	 * 查询所有员工考勤记录
	 * @return
	 */
	public List<AllSignON> allSignOn();
}
