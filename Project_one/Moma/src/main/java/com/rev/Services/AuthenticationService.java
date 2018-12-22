package com.rev.Services;

import java.util.ArrayList;
import java.util.List;

import com.rev.Beans.Account;
import com.rev.Beans.Credentials;
import com.rev.Beans.Employee;
import com.rev.Beans.Reimbursment;
import com.rev.Dao.EmployeeDao;
import com.rev.DaoImpl.EmployeeDaoImpl;

import weblogic.xml.xpath.common.utils.EmptyList;

public class AuthenticationService {

	public AuthenticationService() {
		
	}
	public Boolean manage = false;
	public static EmployeeDao empl = new EmployeeDaoImpl();
	public static void main(String[] args) {
		System.out.println(empl.getEmployeeById(1));
	}
	public Employee isValidUser(Credentials cred)
	{

		List<Employee> empList = empl.getEmployee();
		String user = cred.getUserName();
		String pass = cred.getPassword();
		if(user != null && pass != null)
		{
			for(int i = 0; i < empList.size(); i++){
				if(user.equals(empList.get(i).getUserName()) && pass.equals(empList.get(i).getPasswords()))
				{
					if(empList.get(i).getManagers() != 0)
					{
						manage = true;
					}
					return empList.get(i);
				}
			}
		}	
		else
		{
		 return null;
		}
		return null;
				
	}
}
