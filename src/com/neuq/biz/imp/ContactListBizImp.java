package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IContactListBiz;
import com.neuq.dao.IContactListDao;
import com.neuq.dao.imp.ContactListDaoImp;
import com.neuq.entities.Worker;
import com.neuq.util.DBUtil;

public class ContactListBizImp implements IContactListBiz{

	@Override
	public List<Worker> selectContactListBiz() {
		// TODO Auto-generated method stub
		IContactListDao icld=new ContactListDaoImp();
		Connection con=DBUtil.getConnection();
		
			List<Worker> list=null;
			 try {
				list=icld.selectContactList(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeDB(con);
			}
			return list;
	}
	public List<Worker> SelectContactListNameBiz(String name){
		
		
			// TODO Auto-generated method stub
			IContactListDao icld=new ContactListDaoImp();
			Connection con=DBUtil.getConnection();
			
				List<Worker> list=new ArrayList<Worker>();
				 try {
					list=icld.selectContactListName(con,name);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBUtil.closeDB(con);
				}
				return list;
	}
	

}
