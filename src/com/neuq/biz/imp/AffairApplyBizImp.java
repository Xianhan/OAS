package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.AffairApplyBiz;
import com.neuq.dao.AffairApplyDao;
import com.neuq.dao.imp.AffairApplyDaoImp;
import com.neuq.entities.Affairs;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

public class AffairApplyBizImp implements AffairApplyBiz{
		
	//全局变量  Dao包对象
	AffairApplyDao AffApp=new AffairApplyDaoImp();
	
	//判断提交申请表是否成功
	@Override
	public boolean SubmitApply(Affairs aff){
		Connection con=DBUtil.getConnection();
		boolean b=false;
		try {
			b=AffApp.SubmitApply(aff, con);
			if(b){
				System.out.println("提交成功");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
	//返回查询申请表结果
	@Override
	public List<Affairs> QueryApply(int id){
		Connection con=DBUtil.getConnection();
		List<Affairs> arraffair=new ArrayList<Affairs>();
		try {
			arraffair=AffApp.QueryApply(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arraffair;
	}
	//领导页面返回申请表
	@Override
	public List<Affairs> ManagerQueryApply(int id){
		Connection con=DBUtil.getConnection();
		List<Affairs> arraff=new ArrayList<Affairs>();
		try {
			arraff= AffApp.ManagerQueryApply(id, con);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return arraff;
	}
	@Override
	public boolean CheckApply(int approvalprog,long affid) {
		Connection con=DBUtil.getConnection();
		boolean b=false;
		try {
			b=AffApp.CheckApply(approvalprog, affid, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
	//管理员（领导）查询事务表详情
	@Override
	public Affairs ApplyDetail(long affid) {
		Connection con=DBUtil.getConnection();
		Affairs aff=new Affairs();
		try {
			aff=AffApp.ApplyDetail(affid, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return aff;
	}

}
