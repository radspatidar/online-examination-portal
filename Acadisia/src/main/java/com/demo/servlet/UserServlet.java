package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.daoimpl.UserDaoImpl;
import com.demo.pojo.User;

/**
 * Servlet implementation class deleteUserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("link");
		
		if(link ==  null) {
			link = (String)request.getAttribute("link");
		}
		
		UserDaoImpl daoimpl = new UserDaoImpl();
		
		List<User> list = daoimpl.getStudents("admin");
		
		request.setAttribute("list", list);
		
		String target ="";
		
		if(link.equals("delete")) {
			target = "/deleteUser.jsp";
		}
		
		if(link.equals("search")) {
			target = "/searchUser.jsp";
		}
		
		if(link.equals("update")) {
			target = "/modifyUser.jsp";
		}
		
		if(link.equals("view")) {
			target = "/viewAlluser.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = 0;	
			try {
				id = Integer.parseInt(request.getParameter("id"));
			}catch(NumberFormatException e) {
				System.out.println("Invlid input");
			}
			
			String link = request.getParameter("link");
			
			UserDaoImpl daoimpl = new UserDaoImpl();
			
			if(link.equals("delete")) {
				boolean isDeleted = daoimpl.deleteUser(id);
		        if (isDeleted) {
		        	request.setAttribute("link", link);
		        	doGet(request, response);
		        } else {
		           System.out.println("error");
		        }
			}
			
			
			if(link.equals("search")) {
				User u1 = daoimpl.getUser(id);
		        if (u1 != null) {
		        	request.setAttribute("user", u1);
		        	RequestDispatcher rd = request.getRequestDispatcher("/searchUser.jsp");
		    		rd.forward(request, response);
		        } else {
		           System.out.println("error");
		        }
			}
			
			if(link.equals("search1")) {
				User u1 = daoimpl.getUser(id);
		        if (u1 != null) {
		        	request.setAttribute("user", u1);
		        	RequestDispatcher rd = request.getRequestDispatcher("/modifyUser.jsp");
		    		rd.forward(request, response);
		        } else {
		           System.out.println("error");
		        }
			}
	        
			if(link.equals("update")) {
			
				User u2 = new User();
				
				u2.setId(id);
				u2.setName(request.getParameter("name"));
				u2.setEmail(request.getParameter("email"));
				u2.setPassword(request.getParameter("password"));
				u2.setRole(request.getParameter("role"));
				
				boolean isUpdated = daoimpl.updateUser(u2);
			    if (isUpdated == true) {
			    	if(u2.getPassword() == null) {
			    		System.out.println("true");
			    		request.setAttribute("link", "update");
				    	doGet(request, response);
			    	}else {
			    		request.setAttribute("msg", "Record Updated Successfully");
				    	RequestDispatcher rd = request.getRequestDispatcher("/searchUser.jsp");
				    	rd.forward(request, response);
			    	}
			    	
			    } else {
			       System.out.println("error");
			    }
			}
			
	}

	        
	        
	      
	}
