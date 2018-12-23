package com.rev.Services;


import java.util.List;

import com.rev.Beans.Credentials;
import com.rev.Beans.Employee;
import com.rev.DaoImpl.EmployeeDaoImpl;


public class AuthenticationService {
	//public EmployeeDao empl = new EmployeeDaoImpl();
	public Employee isValidUser(Credentials cred)
	{
		EmployeeDaoImpl emin = new EmployeeDaoImpl();
		String user = cred.getUserName();
		String pass = cred.getPassword();
		Employee e = null;
		if(user != null && pass != null)
		{
			List<Employee> empList = emin.getEmployee();
			for(Employee em : empList){
				if(user.equals(em.getUserName()) && pass.equals(em.getPasswords()))
				{
					e = em;
				}
			}
		}
		return e;					
	}
}
