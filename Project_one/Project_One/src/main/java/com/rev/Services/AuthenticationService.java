package com.rev.Services;

import com.rev.Beans.Credentials;
import com.rev.Beans.Employee;

public class AuthenticationService {

	public AuthenticationService() {
		
	}

	public Employee isValidUser(Credentials cred)
	{
		Employee e = null;
		String user = cred.getUserName();
		String pass = cred.getPassword();
		if(user != null && pass != null)
		{
			if(user.equals(e.getUserName()) && pass.equals(e.getPasswords()))
			{
				e = new Employee(5,0, user,"Bill","Cipher","Ciphers@Stolen.com", 3, 2, 4);
			}
		}
		
		
		return e;		
	}
}
