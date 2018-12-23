package com.rev.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		System.out.println("TEST");
		if(session != null && session.getAttribute("username") != null)
			{
			System.out.println("Pass");
				req.getRequestDispatcher("Profile.html").forward(req, resp);
			}
		else
		{
			System.out.println("Fail");
			resp.sendRedirect("Login");
		}
	}
}
