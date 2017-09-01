package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Schedule;

public interface IScheduleDao {
	
	/**
	 * 添加日程
	 * @param con
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public boolean AddSchedule(Connection con,Schedule s) throws SQLException;
	/**
	 * 删除 日程
	 * @param con
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public boolean DelSchedule(Connection con,int userId) throws SQLException;
	/**
	 * 修改日程
	 * @param con
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public boolean UpdateSchedule(Connection con,Schedule s) throws SQLException;
	/**
	 * 根据id查询自己所有日程
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Schedule> SelectSchedule(Connection con,int id) throws SQLException;
	/**
	 * 根据id查询所有日程以便修改
	 * @param con
	 * @param scheId
	 * @return
	 */
	public List<Schedule> UpdateSelectSchedule(Connection con,int scheId);

}
