package com.neuq.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Affairs;
import com.neuq.entities.Worker;

public interface AffairApplyBiz {
	/**
	 * 提交申请表
	 * @param aff
	 * @return
	 */
	public boolean SubmitApply(Affairs aff);
	/**
	 * 查询申请表
	 * @param id
	 * @return
	 */
	public List<Affairs> QueryApply(int id);
	/**
	 * 领导查询总申请表
	 * @param id
	 * @return
	 */
	public List<Affairs> ManagerQueryApply(int id);
	/**
	 * 事务详情
	 * @param affid
	 * @return
	 */
	public Affairs ApplyDetail(long affid);
	/**
	 * 领导审核申请表
	 * @param approvalprog
	 * @param id
	 * @return
	 */
	public boolean CheckApply(int approvalprog,long id);
}
