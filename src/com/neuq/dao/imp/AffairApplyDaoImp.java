package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.neuq.dao.AffairApplyDao;
import com.neuq.entities.Affairs;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;
import com.neuq.util.RealnameToIdUtil;

public class AffairApplyDaoImp implements AffairApplyDao{
	/**
	 * 将事务名称，申请人，接收人，内容，申请时间(自动获取系统当前时间)加入数据库
	 */
	@Override
	public boolean SubmitApply(Affairs aff,Connection con) throws SQLException {
		boolean b=false;
		//经测试不能使用占位符
		//通过真实姓名找id
//		RealnameToIdUtil rti=new RealnameToIdUtil();
//		aff.getSender().setId(rti.ToIdUtil(aff.getSender().getRealname()));
//		aff.getReceiver().setId(rti.ToIdUtil(aff.getReceiver().getRealname()));
		//存入数据库
		String sql="INSERT INTO tab_affairs VALUES(tab_affairs_seq.nextval,'"+aff.getTitle()+"',"+aff.getSender().getId()+","+aff.getReceiver().getId()+",'"+aff.getContent()+"',sysdate,0)";
		PreparedStatement pst=null;
		pst=con.prepareStatement(sql);	
		int count=pst.executeUpdate(sql);
		if(count>0){
			b=true;
		}
		return b;
	}
	/**
	 * 查询数据中提交的申请表内容
	 */
	@Override
	public List<Affairs> QueryApply(int id,Connection con) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		//查询事务内容
		String sql="select ta.title,ts.realname,tr.realname,ta.sendtime,ta.content,ta.approvalprog from TAB_WORKER ts,tab_worker tr,tab_affairs ta WHERE  ta.sender="+id+" AND ts.id=ta.sender AND tr.id=ta.receiver";
		pst=con.prepareStatement(sql);
		List<Affairs> arrAff=new ArrayList<Affairs>();
		
		rs=pst.executeQuery();
		/*返回结果集 名称
		 *事务的接收者和发送者需要反回Worker对象
		 *提交时间，内容，状态
		 */
		while(rs.next()){
			Affairs aff=new Affairs();
			aff.setTitle(rs.getString(1));
			
			Worker sender=new Worker();
			sender.setRealname(rs.getString(2));
			aff.setSender(sender); 
			
			Worker receiver=new Worker();
			receiver.setRealname(rs.getString(3));
			aff.setReceiver(receiver);
			
			aff.setSendTime(rs.getDate(4));
			aff.setContent(rs.getString(5));
			aff.setApprovalProgress(rs.getInt(6));
			arrAff.add(aff);
		}
		return arrAff;
	}
	
	/**
	 * 领导查看事务
	 */
	@Override
	public List<Affairs> ManagerQueryApply(int id, Connection con) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Affairs> arraff= new ArrayList<Affairs>();
		
		//查询事务内容
		String sql="select ta.title,ts.realname,tr.realname,ta.sendtime,ta.content,ta.approvalprog,ta.id from TAB_WORKER ts,tab_worker tr,tab_affairs ta WHERE  ta.receiver='"+id+"' AND ts.id=ta.sender AND tr.id=ta.receiver";
		pst=con.prepareStatement(sql);
		
		Worker sender=new Worker();
		Worker receiver=new Worker();
		//返回结果集 名称
		rs=pst.executeQuery(sql);
		while(rs.next()){
			Affairs aff=new Affairs();
			aff.setTitle(rs.getString(1));
		
		//事务的接收者和发送者需要反回Worker对象
			sender.setRealname(rs.getString(2));
			aff.setSender(sender); 
			receiver.setRealname(rs.getString(3));
			aff.setReceiver(receiver);
		
		//提交时间，内容，状态
			aff.setSendTime(rs.getDate(4));
			aff.setContent(rs.getString(5));
			aff.setApprovalProgress(rs.getInt(6));
			aff.setId(rs.getLong(7));
			arraff.add(aff);
		}
		return arraff;
	}
	@Override
	public boolean CheckApply(int approvalprog,long affid, Connection con) throws SQLException {
		boolean b=false;
		//依旧不能使用占位符
		String sql="UPDATE tab_affairs SET approvalprog ="+approvalprog+" WHERE ID="+affid+"";
		PreparedStatement pst=null;
		pst=con.prepareStatement(sql);	
		int count=pst.executeUpdate(sql);
		if(count>0){
			b=true;
		}
		return b;
	}
	
	/**
	 * 查询单个事务表的详细内容
	 */
	@Override
	public Affairs ApplyDetail(long affid, Connection con) throws SQLException {
		Affairs aff=new Affairs();
		String sql="SELECT ta.id,ta.title,ts.realname,tr.realname,ta.sendtime,ta.content,ta.approvalprog FROM tab_affairs ta,tab_worker ts,tab_worker tr WHERE ta.id="+affid+" AND ta.sender=ts.id AND ta.receiver=tr.id";
		PreparedStatement pst=null;
		pst=con.prepareStatement(sql);
		ResultSet rs=null;
		rs=pst.executeQuery();
		while(rs.next()){
			aff.setId(rs.getLong(1));
			aff.setTitle(rs.getString(2));
			Worker sender=new Worker();
			sender.setRealname(rs.getString(3));
			aff.setSender(sender);
			Worker receiver=new Worker();
			receiver.setRealname(rs.getString(4));
			aff.setReceiver(receiver);
			aff.setSendTime(rs.getDate(5));
			aff.setContent(rs.getString(6));
			aff.setApprovalProgress(rs.getInt(7));
		}
		return aff;
	}

}
