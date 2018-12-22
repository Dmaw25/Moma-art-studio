package com.rev.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("username") != null)
			{
				req.getRequestDispatcher("Profile.html").forward(req, resp);
			}
		else
		{
			resp.sendRedirect("Login");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
