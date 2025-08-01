package com.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.daoimpl.QuizDaoImpl;
import com.demo.daoimpl.UserDaoImpl;
import com.demo.pojo.Quiz;
import com.demo.pojo.User;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDaoImpl daoimpl = new UserDaoImpl();
		
		List<User> studentList = daoimpl.getStudents("student");
		
		QuizDaoImpl daoimpl1 = new QuizDaoImpl();
		
		Map<User, ArrayList<String>> map = daoimpl1.getSubjects(studentList);
		
		request.setAttribute("map", map);
		RequestDispatcher rd = request.getRequestDispatcher("/report.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
