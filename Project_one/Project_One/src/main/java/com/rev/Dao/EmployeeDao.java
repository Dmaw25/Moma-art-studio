package com.rev.Dao;

import java.time.LocalDate;
import java.util.List;

import com.rev.Beans.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployee();
	public Employee getEmployeeById(int id);
	public Employee addEmployee(int j, int k, String user, String pass, String first, String last, String title, int report, LocalDate birth, LocalDate Hired, String adress,String city,String state, String coun,String postal,String phone, String fax, String email);
}
