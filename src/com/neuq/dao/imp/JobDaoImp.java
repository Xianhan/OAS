package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IJobDao;
import com.neuq.entities.Job;
import com.neuq.util.DBUtil;

public class JobDaoImp implements IJobDao {

	@Override
	public List<Job> selectAllJob(Connection con) throws SQLException {
		List<Job> jobList = new ArrayList<Job>();
		String sql = "select * from tab_job";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Job job = new Job();
			job.setId(rs.getInt(1));
			job.setJob(rs.getString(2));
			jobList.add(job);
		}
		DBUtil.closeDB(rs, pst);
		return jobList;
	}

}
