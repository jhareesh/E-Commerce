package com.shopNest.customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopNest.dbHandler.DataInjector;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
	{
		try {
			String uname = req.getParameter("uname");
			String mail = req.getParameter("mail");
			String pass = req.getParameter("pass");
			String gender = req.getParameter("gender");
			String address = req.getParameter("address");

			String status = DataInjector.addCustomer(uname, mail, pass, gender, address);

			resp.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Problem in registration of user");
			e.printStackTrace();
		}
	}
}
