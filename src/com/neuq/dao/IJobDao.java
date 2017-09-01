package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Job;

public interface IJobDao {

/**
 * 查询所有职位
 * @param con
 * @return
 * @throws SQLException
 */
	public List<Job> selectAllJob(Connection con) throws SQLException;
}
