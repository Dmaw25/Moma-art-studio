package com.rev.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.Beans.Employee;

public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("username") != null)
			{
			try {
				int userid =Integer.parseInt(session.getAttribute("Employee_ID").toString());
				int managers = Integer.parseInt(session.getAttribute("Managers").toString());
				String userName = session.getAttribute("UserName").toString();
				String pass = session.getAttribute("Password").toString();
				String firstName = session.getAttribute("FirstName").toString();
				String lastName = session.getAttribute("LastName").toString();
				int reportTo = Integer.parseInt(session.getAttribute("ReportTo").toString());
				int account = Integer.parseInt(session.getAttribute("Account").toString());
				int reim = Integer.parseInt(session.getAttribute("Reimbursment").toString());
				Employee e = new Employee(userid,managers,userName,pass,firstName,lastName,reportTo,account,reim);
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			}catch(Exception e){
				resp.getWriter().write("{\"session\":null}");
			}
		}
		else
		{
			resp.sendRedirect("Login");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
