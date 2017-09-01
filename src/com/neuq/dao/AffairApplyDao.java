package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.*;
//事务申请与事务审核接口
public interface AffairApplyDao {
	//事务申请
	public boolean SubmitApply(Affairs aff,Connection con)throws SQLException;
	//事务查询
	public List<Affairs> QueryApply(int id,Connection con)throws SQLException;
	//事务审核 第一步、查看事务
	public List<Affairs> ManagerQueryApply(int id,Connection con)throws SQLException;
	//事务详情
	public Affairs ApplyDetail(long affid,Connection con)throws SQLException;
	//事务审核 第二步、返回结果
	public boolean CheckApply(int approvalprog,long affid,Connection con)throws SQLException;
	
}
