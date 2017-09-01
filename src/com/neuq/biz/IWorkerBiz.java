package com.neuq.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Worker;

public interface IWorkerBiz {
	/**
	 * 登陆检查
	 * @return
	 */
	public boolean checkLogin(Worker worker);
	/**
	 * 根据id查询员工详情
	 * @param id
	 * @return
	 */
	public Worker queryWorker(int id);
	/**
	 * 查询所有员工详情
	 * @return
	 */
	public List<Worker> selectAllWorker();
	/**
	 * 分页查询
	 * @return
	 */
	public List<Worker> pagingWorker(int start ,int end);
	/**
	 * 根据真实姓名查询员工详情
	 * @param realname
	 * @return
	 */
	public Worker queryWorker(String realname);
	/**
	 * 修改员工详情
	 * @param worker
	 * @return
	 */
	public boolean updateWorker(Worker worker) ;
	/**
	 * 根据员工id删除
	 * @param id
	 * @return
	 */
	public boolean deleteWorker(int id);
	/**
	 * 选出所有经理
	 * @return
	 */
	public List<Worker> selectAllManager();
	/**
	 * 添加员工
	 * @param worker
	 * @return
	 */
	public boolean addWorker(Worker worker);
	/**
	 * 修改密码
	 * @param worker
	 * @return
	 */
	public boolean updatePwd(Worker worker);
}
