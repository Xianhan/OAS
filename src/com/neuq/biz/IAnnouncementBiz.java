package com.neuq.biz;

import java.util.List;

import com.neuq.entities.Announcement;

public interface IAnnouncementBiz {
	/**
	 * 添加新公告
	 * @param ann
	 * @return
	 */
	public boolean addAnnouncement(Announcement ann);
	/**
	 * 删除公告
	 * @param id
	 * @return
	 */
	public boolean deleteAnnouncement(long id);
	/**
	 * 查询出所有公告
	 * @return
	 */
	public List<Announcement> selectAnnouncement();
/**
 * 根据id号修改公告的内容
 * @param content
 * @param id
 * @return
 */
	public boolean updateAnnouncement(String content, long id);
	/**
	 * 根据id号查询公告的内容
	 * @param id
	 * @return
	 */
	public Announcement selectAnnByID(long id);

	
}
