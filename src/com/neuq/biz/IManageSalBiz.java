package com.neuq.biz;

import java.util.List;

import com.neuq.entities.Salary;

public interface IManageSalBiz {
	//���ò�ѯ����Ա�����ʷ���
	public List<Salary> checkSal();
	
	//�������Ա�����ʷ���
		public boolean saveSal(Salary s);
	//�����޸�Ա�����ʷ���
		public boolean updateSal(Salary s);
	//���ø���ĳ����id��ѯ���˹��ʷ���
		public Salary checkSal(int id);
		//��ҳ��ѯ
		public List<Salary> pagingWorker(int start,int end);

		
		
		
}
