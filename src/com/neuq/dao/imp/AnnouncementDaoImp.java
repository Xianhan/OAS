package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuq.dao.IAnnouncementDao;
import com.neuq.dao.IWorkerDao;
import com.neuq.entities.Announcement;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

import oracle.net.aso.a;

public class AnnouncementDaoImp implements IAnnouncementDao {

	/**
	 * 添加公告
	 */
	@Override
	public boolean addAnnouncement(Announcement ann, Connection con) throws SQLException {
		PreparedStatement pst = null;
		String addsql = "INSERT INTO tab_announcement VALUES(tab_ann_seq.nextval,?,SYSDATE,?,?)";
		pst = con.prepareStatement(addsql);
		pst.setString(1, ann.getTitle());
		pst.setString(2, ann.getContent());
		pst.setInt(3, ann.getPromulgator().getId());
		int count = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除公告
	 */
	@Override
	public boolean deleteAnnouncement(long id, Connection con) throws SQLException {
		String sql = "Delete from tab_announcement where id=" + id;
		Statement stmt = con.createStatement();// ����Statement
		int result = stmt.executeUpdate(sql);
		DBUtil.closeDB(stmt);// �ر�Statement������
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 更新公告
	 */
	@Override
	public boolean updateAnnouncement(String content, long id, Connection con) throws SQLException {
		String updateSql = "UPDATE tab_announcement SET content = '" + content + "' WHERE Id=" + id;
		Statement st = con.createStatement();
		System.out.println(id);
		int count = st.executeUpdate(updateSql);
		System.out.println(count);
		DBUtil.closeDB(st);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查询所有公告
	 */
	@Override
	public List<Announcement> selectAnnouncement(Connection con) throws SQLException {
		List<Announcement> list = new ArrayList<Announcement>();
		ResultSet rs = null;
		Statement st = null;
		Announcement ann = null;
		String sql = "SELECT *FROM tab_announcement ORDER BY id DESC";
		st = con.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			ann = new Announcement();
			ann.setId(rs.getLong(1));
			ann.setTitle(rs.getString(2));
			ann.setPunTime((Date) rs.getDate(3));
			ann.setContent(rs.getString(4));
			Worker promulgator = new Worker();
			promulgator = new WorkerDaoImp().queryWorker(rs.getInt(5), con);
			ann.setPromulgator(promulgator);
			list.add(ann);
		}

		DBUtil.closeDB(rs, st);
		return list;
	}

	/**
	 * 根据id查询该公告详情
	 * 
	 */
	@Override
	public Announcement selectAnnByID(long id, Connection con) throws SQLException {
		String sql = "SELECT title,content,pubtime FROM tab_announcement WHERE id =" + id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		Announcement ann = new Announcement();
		rs.next();
		ann.setId(id);
		ann.setTitle(rs.getString(1));
		ann.setContent(rs.getString(2));
		ann.setPunTime((Date) rs.getDate(3));
		DBUtil.closeDB(st, rs);
		return ann;
	}

}
