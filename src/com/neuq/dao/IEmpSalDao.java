package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Salary;

public interface IEmpSalDao {
  //Ա����ѯ����
	public List<Salary> checkSal(int id,Connection con)throws SQLException;
}
