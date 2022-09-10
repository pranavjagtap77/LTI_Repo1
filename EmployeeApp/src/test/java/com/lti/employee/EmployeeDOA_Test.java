package com.lti.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lti.DAO.Database_conn;
import com.lti.DAO.Employee_DAO;
import com.lti.entity.Employee;

public class EmployeeDOA_Test {

	public static Employee_DAO dao;
    
    @Test
    void getConnectionTest() throws SQLException {
    	Connection conn = Database_conn.getConn();
    	assertNotNull(conn, "Connection successful");
    }
    
    
    @BeforeAll
    public static void getDao(){
    	dao = new Employee_DAO();
    }
    
    
    @Test
    public void addEmptest() throws SQLException {
    	Employee emp = new Employee();
    	emp.setUsername("emp");
    	emp.setPassword("emppass1");
    	emp.setEmail("emp@gmail.com");
    	
    	Connection conn = Database_conn.getConn();
    	
    	//dao.addEmp(emp);
    	
    	Employee empfromdb = dao.getEmployeebyName("John");
    	
    	assertEquals("JohnSmith", empfromdb.getPassword(),"Password cheked successfully");
    }
    
    @Test
    public void deleteEmpTest() throws SQLException {
    	Employee emp = new Employee();
    	
    	
    	Employee empfromdb = dao.getEmployeebyName("emp11");
    	
    	dao.deleteEmp("emp");
    	assertNull(empfromdb.getUsername());
    }
}
