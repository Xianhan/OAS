package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Worker;

public interface IWorkerDao {
	/**
	 * 登录检查
	 * @param worker
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean checkLogin(Worker worker,Connection con) throws SQLException;
	/**
	 * 根据员工id查询详情
	 * @param id
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public Worker queryWorker(int id,Connection con) throws SQLException;
	/**
	 * 查询所有员工
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<Worker> selectAllWorker(Connection con) throws SQLException;
	/**
	 * 分页查询
	 * @param start
	 * @param end
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<Worker> pagingWorker(int start, int end, Connection con) throws SQLException;
	/**
	 * 根据真实姓名查询该员工详情
	 * @param name
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public Worker queryWorker(String name,Connection con) throws SQLException;
	/**
	 * 修改员工信息
	 * @param worker
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean updateWorker(Worker worker,Connection con) throws SQLException;
	/**
	 * 删除员工
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteWorker(int id,Connection con)throws SQLException;
	/**
	 * 查询出所有经理
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<Worker> selectAllManager(Connection con) throws SQLException;
	/**
	 * 添加员工
	 * @param worker
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean addWorker(Worker worker,Connection con) throws SQLException;
	/**
	 * 修改密码
	 * @param worker
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePwd(Worker worker,Connection con) throws SQLException;
}
