package com.rev.Servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.Beans.Employee;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// grab current session, if it exists
		System.out.println("test");
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			try {
				System.out.println("test");
				int userId = Integer.parseInt(session.getAttribute("Employee_ID").toString());
				int managers = Integer.parseInt(session.getAttribute("Managers").toString());
				int reportsTo = Integer.parseInt(session.getAttribute("ReportsTo").toString());
				String username = session.getAttribute("UserName").toString();
				String firstname = session.getAttribute("FirstName").toString();
				String lastname = session.getAttribute("LastName").toString();
				String password = session.getAttribute("Passwords").toString();
				Employee u = new Employee(userId, managers, username, password, firstname, lastname, reportsTo);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}

}
