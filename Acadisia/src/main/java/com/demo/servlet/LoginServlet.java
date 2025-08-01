package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.daoimpl.UserDaoImpl;
import com.demo.pojo.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = new User();
		
		u.setEmail(request.getParameter("email"));
		
		u.setPassword(request.getParameter("password"));
		
		UserDaoImpl daoimpl = new UserDaoImpl();
		
		User user = daoimpl.checkUser(u);
		
		String target = "";
		
		if(user != null){
			
			HttpSession session = request.getSession(false);
			
			if(session != null) {
				session.invalidate();
			}
			
			session = request.getSession(true);
			
			session.setAttribute("role", user.getRole());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("name", user.getName());
			
			if(user.getRole().equals("admin")){
				target = "/admin.jsp";
			}else {
				target = "/student.jsp";
			}
			
		}else{
			request.setAttribute("msg","<font color=red size = 3>User doen not exists</font>");
			target = "/login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
