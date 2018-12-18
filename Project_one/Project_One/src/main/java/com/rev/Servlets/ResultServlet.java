package com.rev.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/otherResultServlet") //removes need to register in web.xml

public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Enumeration<String> atts = request.getAttributeNames();
		while (atts.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " : " + request.getAttribute(s));
			}
		String error = (String) request.getAttribute("error");
		PrintWriter pw = response.getWriter();
		if(error == null || error.equals("")) {
			try {
				Double answer = (Double) request.getAttribute("answer");
				pw.write("<p>This answer is: " +request.getAttribute("answer") + "</p>");
			}catch(Exception e) {
				pw.write("<p> Error: Invlaid</p>");
			}
			
		}
		else
		{
			pw.write("<p> Error: "+error+ "</p>");
		}
		pw.write("<p> Go Back </p>");
		
	}

}
