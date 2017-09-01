package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Salary;

public interface IManageSalDao {

	public List<Salary> checkSal(Connection con)throws SQLException;
    
	public boolean saveSal(Salary s,Connection con) throws SQLException;

	public  boolean  updateSal(Salary s,Connection con)throws SQLException;

	public Salary checkSal(int id,Connection con)throws SQLException;

	public List<Salary> pagingWorker(int start, int end, Connection con) throws SQLException;
}
