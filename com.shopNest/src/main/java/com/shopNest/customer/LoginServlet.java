package com.shopNest.customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// collecting form data
			String uname =req.getParameter("uname");
			String pass=req.getParameter("pass");

			// performing validation
			boolean isvalid = Validator.isValid(uname, pass);

			if(isvalid==true && uname.equals("admin")) 
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", uname);
				
				resp.sendRedirect("admin.jsp");
			}
			else if(isvalid==true) 
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", uname);
				
				resp.sendRedirect("home.jsp");
			}
			else 
			{
				resp.sendRedirect("login.jsp");
			}
		} 
		catch (Exception e) {
			System.out.println("Problem in LoginServlet");
			e.printStackTrace();
		}
	}
}