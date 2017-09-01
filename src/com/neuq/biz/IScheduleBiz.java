package com.neuq.biz;

import java.util.List;

import com.neuq.entities.Schedule;

public interface IScheduleBiz {
	/**
	 * 添加日程
	 * @param s
	 * @return
	 */
	public boolean AddSchedule(Schedule s);
	/**
	 * 删除日程
	 * @param userId
	 * @return
	 */
	public boolean DelSchedule(int userId);
	/**
	 * 修改日程
	 * @param s
	 * @return
	 */
	public boolean UpdateSchedule(Schedule s);
	/**
	 * 根据员工id查出该员工所有日程
	 * @param id
	 * @return
	 */
	public List<Schedule> SelectSchedule(int id);
	/**
	 * 根据日程id查询该日程详细信息用于修改
	 * @param scheId
	 * @return
	 */
	public List<Schedule> UpdateSelectSchedule(int scheId);
	

}
