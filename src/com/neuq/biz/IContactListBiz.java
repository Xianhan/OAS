package com.neuq.biz;

import java.util.List;

import com.neuq.entities.Worker;



public interface IContactListBiz {
	/**
	 * 查询所有通讯录
	 * @return
	 */
	public List<Worker> selectContactListBiz();
	/**
	 * 根据姓名模糊查询通讯录
	 * @param name
	 * @return
	 */
	public List<Worker> SelectContactListNameBiz(String name);

}
