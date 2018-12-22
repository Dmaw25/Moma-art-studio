package com.rev.Servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.Beans.Account;
import com.rev.Beans.Employee;
import com.rev.Beans.Reimbursment;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("username") != null)
			{
			try {
				int userid =Integer.parseInt(session.getAttribute("userid").toString());
				int managers = Integer.parseInt(session.getAttribute("managers").toString());
				String userName = session.getAttribute("username").toString();
				String pass = session.getAttribute("password").toString();
				String firstName = session.getAttribute("firstname").toString();
				String lastName = session.getAttribute("lastName").toString();
				int reportTo = Integer.parseInt(session.getAttribute("reportsTo").toString());
				Account account = (Account) session.getAttribute("account");
				Reimbursment reim = (Reimbursment) session.getAttribute("reim");
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
}
