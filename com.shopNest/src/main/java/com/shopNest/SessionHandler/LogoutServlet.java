package com.shopNest.SessionHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try 
		{
			// Invalidate the session object and redirect the user to the login page
			HttpSession session = request.getSession();
			
			session.removeAttribute("username");
			
			session.invalidate();
			
			// Redirect to the login page
			response.sendRedirect("login.jsp");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}