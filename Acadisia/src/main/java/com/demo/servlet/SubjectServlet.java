package com.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.daoimpl.QuestionBankDaoImpl;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String table = request.getParameter("link");
		
		if(table == null) {
			table = (String)request.getAttribute("link");
		}
		
		
		QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
		
		List<String> list = new ArrayList<String>();
		
		list = daoimpl.listOfAllSubjects(table);
		
		HttpSession session = request.getSession(false);
		
		if(table.equals("questionbank")) {
			
			session.setAttribute("quesSubjects", list);
			
			String role = (String)session.getAttribute("role");
			
			String target = "";
			
			if(role.equals("admin")) {
				target = "/questionBank.jsp";
			}else {
				target = "/sQuestionBank.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(target);
	        rd.forward(request, response);
	        
		}else {
			
			session.setAttribute("quizSubjects", list);
			
			String role = (String)session.getAttribute("role");
			
			String target = "";
			
			if(role.equals("admin")) {
				target = "/quiz.jsp";
			}else {
				target = "/studentQuiz.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(target);
	        rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
