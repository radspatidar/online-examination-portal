package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.daoimpl.QuestionBankDaoImpl;
import com.demo.daoimpl.QuizDaoImpl;
import com.demo.pojo.QuestionBank;
import com.demo.pojo.Quiz;

/**
 * Servlet implementation class AddQuestionServlet
 */
@WebServlet("/AddQuizQuestionServlet")
public class AddQuizQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Quiz q = new Quiz();
		
		q.setQuestion(request.getParameter("question"));
		
		HttpSession session = request.getSession(false);
		q.setSubject((String)session.getAttribute("quizsubject"));
		
		q.setOption_a(request.getParameter("option_a"));
		
		q.setOption_b(request.getParameter("option_b"));
		
		q.setOption_c(request.getParameter("option_c"));
		
		q.setOption_d(request.getParameter("option_d"));
		
		
		q.setCorrect_answer(request.getParameter("correct_answer"));
		

		QuizDaoImpl daoimpl = new QuizDaoImpl();
		
		String target ="";
		
		boolean isAdded = daoimpl.addQuestion(q);
		   
		if(isAdded == true) {
			target = "QuizServlet";
		}else {
			request.setAttribute("msg","Question could not be added");
			target = "/addQuizQuestion.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	    		
		
			
		}
		
		
		
		
	}


