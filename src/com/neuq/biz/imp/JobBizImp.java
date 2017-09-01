package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IJobBiz;
import com.neuq.dao.IJobDao;
import com.neuq.dao.imp.JobDaoImp;
import com.neuq.entities.Job;
import com.neuq.util.DBUtil;

public class JobBizImp implements IJobBiz {
	IJobDao ijb = new JobDaoImp();

	@Override
	public List<Job> selectAllJob() {
		List<Job> jobList = new ArrayList<Job>();
		Connection con = DBUtil.getConnection();
		try {
			jobList = ijb.selectAllJob(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return jobList;
	}

}
