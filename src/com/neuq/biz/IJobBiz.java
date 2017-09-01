package com.neuq.biz;

import java.util.List;

import com.neuq.entities.Job;

public interface IJobBiz {
	/**
	 * 查询出所有工作职位
	 * @return
	 */
	public List<Job> selectAllJob();
}
