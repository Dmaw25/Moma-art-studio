package com.rev.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217738150363355737L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Perform Null check
		
		String paramEID = req.getParameter("employeeID");
		String paraManagers = req.getParameter("managers");
		String paramReport = req.getParameter("reportTo");
		String paramAccount = req.getParameter("account");
		String paramReim = req.getParameter("reimbursment");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String firstName = req.getParameter("lastName");
	if(paramEID != null && paraManagers != null) {
		Integer employID = Integer.parseInt(req.getParameter("paramEID"));
		Integer managers = Integer.parseInt(req.getParameter("paraManagers"));
		//You can use a switch to handle operations here
	}
	String error = null;
	req.setAttribute("error", error);
	RequestDispatcher rd = req.getRequestDispatcher("result");
	rd.forward(req,resp);
	}
}