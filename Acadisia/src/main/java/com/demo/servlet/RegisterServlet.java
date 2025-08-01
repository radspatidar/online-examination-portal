package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.daoimpl.UserDaoImpl;
import com.demo.pojo.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		
		String role = request.getParameter("role");
		
		if(role !=  null) {
			u.setRole(role);
		}
		u.setName(request.getParameter("name"));
		
		u.setEmail(request.getParameter("email"));
		
		u.setPassword(request.getParameter("password"));
		
		UserDaoImpl daoimpl = new UserDaoImpl();
		
		String btn = request.getParameter("btn");
		
		String file = "";
		if(btn.equals("getPassword")){
			User user = daoimpl.getPassword(u);
			String password = user.getPassword();
			if(password.equals("null")){
				request.setAttribute("msg","User does not exist");
			}else{
				request.setAttribute("msg", user );
			}
			file = "/forgotPassword.jsp";
		}
		
		if(btn.equals("register")){
			boolean isAdded = daoimpl.addUser(u);
			if(isAdded == true){
				
				file = "/login.jsp";
			}else{
				request.setAttribute("msg","<font color = red size = 5>User could not be Register</font>");
				file = "/registration.jsp";
			}
			
		}
		
		if(btn.equals("Add User")){
			boolean isAdded = daoimpl.addUser(u);
			if(isAdded == true){
				request.setAttribute("msg","<font color = Green size = 5>User Added Successfully<br></font>");
				file = "/addUser.jsp";
			}else{
				request.setAttribute("msg","<font color = red size = 5>User could not be Register</font>");
				file = "/addUser.jsp";
			}
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(file);
		rd.forward(request, response);
	}

}
