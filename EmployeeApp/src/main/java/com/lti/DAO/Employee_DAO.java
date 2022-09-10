package com.lti.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.entity.Employee;

public class Employee_DAO {

	private Connection conn;

	public Employee_DAO() {
		try {
			conn = Database_conn.getConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addEmp(Employee e) throws SQLException {
		
		String query = "insert into employee_table(username, password, email) values(?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, e.getUsername());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		
		ps.executeUpdate();
		
		System.out.println("Employee Added successfully");
		
		ps.close();
	}
	
	public Employee getEmployeebyName(String uaername) throws SQLException {
		Employee emp1 = new Employee();
		
		PreparedStatement ps = conn.prepareStatement("select * from employee_table where username = ?");
		
		ps.setString(1, uaername);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			emp1.setUsername(rs.getString(1));
			emp1.setPassword(rs.getString(2));
			emp1.setEmail(rs.getString(3));
		}
		
		return emp1;
	}
	
	public void deleteEmp(String  username) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("delete from employee_table where username =?");
		
		ps.setString(1, username);
		
		ps.executeUpdate();
		System.out.println("Deleted Successfull");
	}

}
