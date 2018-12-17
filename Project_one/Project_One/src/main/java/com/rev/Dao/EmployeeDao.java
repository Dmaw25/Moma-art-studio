package com.rev.Dao;

import java.util.List;

import com.rev.Beans.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployee();
	public Employee getEmployeeById(int id);
}
