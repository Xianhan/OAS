package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Announcement;

public interface IAnnouncementDao {
/**
 * 添加公告
 * @param ann
 * @param con
 * @return
 * @throws SQLException
 */
	public boolean addAnnouncement(Announcement ann, Connection con) throws SQLException;//��������
/**
 * 删除公告
 * @param id
 * @param con
 * @return
 * @throws SQLException
 */
	public boolean deleteAnnouncement(long id, Connection con) throws SQLException;//ɾ������
/**
 * 更新公告
 * @param contemt
 * @param id
 * @param con
 * @return
 * @throws SQLException
 */
	public boolean updateAnnouncement(String contemt, long id, Connection con) throws SQLException;//�޸Ĺ���
/**
 * 查询所有公告
 * @param con
 * @return
 * @throws SQLException
 */
	public List<Announcement> selectAnnouncement(Connection con) throws SQLException;//�鿴���й���
/**
 * 根据公告id查询公告详情
 * @param id
 * @param con
 * @return
 * @throws SQLException
 */
	public Announcement selectAnnByID(long id, Connection con) throws SQLException;//�鿴��������




}
