package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IAnnouncementBiz;
import com.neuq.dao.IAnnouncementDao;
import com.neuq.dao.imp.AnnouncementDaoImp;
import com.neuq.entities.Announcement;
import com.neuq.util.DBUtil;

public class AnnouncementBizImp implements IAnnouncementBiz {

	IAnnouncementDao iad = new AnnouncementDaoImp();

	/**
	 * 添加公告
	 */
	@Override
	public boolean addAnnouncement(Announcement ann) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = iad.addAnnouncement(ann, con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	/**
	 * 删除公告
	 */
	@Override
	public boolean deleteAnnouncement(long id) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = iad.deleteAnnouncement(id, con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	/**
	 *	查询所有公告 
 	 */
	@Override
	public List<Announcement> selectAnnouncement() {
		Connection con = DBUtil.getConnection();
		List<Announcement> list = new ArrayList<Announcement>();
		try {
			list = iad.selectAnnouncement(con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return list;
	}
	/**
	 * 根据公告id查询该公告详情
	 */
	@Override
	public Announcement selectAnnByID(long id) {
		Connection con = DBUtil.getConnection();
		Announcement ann = new Announcement();
		try {
			ann = iad.selectAnnByID(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return ann;
	}


	/**
	 *根据公告id修改公告
	 */
	@Override
	public boolean updateAnnouncement(String content,long id) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = iad.updateAnnouncement(content, id, con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
}
