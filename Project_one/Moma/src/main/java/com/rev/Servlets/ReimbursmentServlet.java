package com.rev.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.Beans.Reimbursment;
import com.rev.Dao.ReimbursmentDao;
import com.rev.DaoImpl.Reim;
import com.rev.Services.ReimburmsmentService;

@WebServlet("/ReimbursmentList")
public class ReimbursmentServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ReimburmsmentService reim = new ReimburmsmentService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		
		try {
			ReimbursmentDao reim = new Reim();
			List<Reimbursment> rlist = new ArrayList<>();
			List<Reimbursment> reiml = reim.getListReimbursements((int) session.getAttribute("Employee_ID"));
			for(Reimbursment r : reiml)
			{
				rlist.add(r);
			}
			response.getWriter().write((new ObjectMapper()).writeValueAsString(reiml));
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("{\"listEmployee\":null}");
		}
	}
}
