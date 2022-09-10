package com.lti.EmployeeApp;

import java.sql.SQLException;

import com.lti.DAO.Employee_DAO;
import com.lti.entity.Employee;

public class App {

	public static void main(String[] args) throws SQLException {

		Employee_DAO doa= new Employee_DAO();
		
		Employee e1 =new Employee();
		e1.setUsername("Pranav");
		e1.setPassword("Pranav1234");
		e1.setEmail("Pranav@gmail.com");
		
		doa.addEmp(e1);
		
		//doa.deleteEmp(e1);
	}

}
