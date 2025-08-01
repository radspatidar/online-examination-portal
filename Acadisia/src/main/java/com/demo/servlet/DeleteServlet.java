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

/**
 * Servlet implementation class DeleteQuestionBankServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("link");
		
		String subject = (String)request.getParameter("subject");
		
		if(link.equals("questionbank")){
			QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
			
			boolean isDeleted = daoimpl.deleteQuestionBank(subject); 
			
			if(isDeleted == true) {
				RequestDispatcher rd = request.getRequestDispatcher("/SubjectServlet?link=questionbank");
		        rd.forward(request, response);
			}else {
				System.out.println("error");
			}
		}else {
			QuizDaoImpl daoimpl = new QuizDaoImpl();
			
			boolean isDeleted = daoimpl.deleteQuiz(subject); 
			
			if(isDeleted == true) {
				RequestDispatcher rd = request.getRequestDispatcher("/SubjectServlet?link=quiz");
		        rd.forward(request, response);
			}else {
				System.out.println("error");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
