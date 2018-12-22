package com.rev.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.Beans.Credentials;
import com.rev.Beans.Employee;
import com.rev.Services.AuthenticationService;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AuthenticationService autherize;
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("handling request...");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		Credentials cred = new Credentials(0, req.getParameter("username"),req.getParameter("password"));
		Employee e = autherize.isValidUser(cred);
		if(e != null)
		{
			session.setAttribute("userid", e.getEmployee_ID());
			session.setAttribute("firstName", e.getFirstName());
			session.setAttribute("lastName", e.getLastName());
			session.setAttribute("username", e.getUserName());
			session.setAttribute("accounts", e.getAccount());
			session.setAttribute("managers", e.getManagers());
			session.setAttribute("reportsTo", e.getReportsTo());
			session.setAttribute("reimbursment", e.getReimbursment());
			session.setAttribute("problem",null);
			resp.sendRedirect("Profile");
		}
		else {
			session.setAttribute("problem", "invalid user");
			resp.sendRedirect("Login");
		}
	}
	
}
