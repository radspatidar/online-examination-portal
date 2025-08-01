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
 * Servlet implementation class EditQuizServlet
 */
@WebServlet("/EditQuizServlet")
public class EditQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question = request.getParameter("question");
		
		String delete = request.getParameter("delete");
	
		QuizDaoImpl daoimpl = new QuizDaoImpl();
		
		String target = "";
		
		if(delete != null) {
			
			boolean isDeleted = daoimpl.DeleteQuestion(question);
			
			if(isDeleted == true) {
				target = "/QuizServlet";
			}else {
				System.out.println("Error");
			}
			
		}else{
			Quiz q = daoimpl.getQuestion(question);
			
			if(q != null) {
				request.setAttribute("q", q);
				target = "/editQuiz.jsp";
			}else {
				System.out.println("Error");
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quiz q = new Quiz();
		
        try {
       	 q.setId(Integer.parseInt(request.getParameter("id")));
        }catch(NumberFormatException e) {
       	 System.out.println("Invalid Input");
        }
        
		q.setQuestion(request.getParameter("question"));
		
		HttpSession session = request.getSession(false);
		q.setSubject((String)session.getAttribute("subject"));
		
		q.setOption_a(request.getParameter("option_a"));
		q.setOption_b(request.getParameter("option_b"));
		q.setOption_c(request.getParameter("option_c"));
		q.setOption_d(request.getParameter("option_d"));
		q.setCorrect_answer(request.getParameter("correct_answer"));
		

		QuizDaoImpl daoimpl = new QuizDaoImpl();
		
		String target ="";
						
		boolean isUpdated = daoimpl.updateQuestion(q);
		
		if(isUpdated == true) {
			target = "/QuizServlet";
		}else {
			request.setAttribute("msg","Question could not be updated");
			target = "/editQuiz.jsp";
		}
	   
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}


