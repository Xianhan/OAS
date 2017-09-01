package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Worker;



public interface IContactListDao {
	/**
	 * 查询所有员工通讯录
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<Worker> selectContactList(Connection con)throws SQLException;
	/**
	 * 根据姓名（模糊）查询通讯方式
	 * @param con
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public List<Worker> selectContactListName(Connection con,String name)throws SQLException;


}
