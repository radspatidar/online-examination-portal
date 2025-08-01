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
import com.demo.pojo.QuestionBank;

/**
 * Servlet implementation class AddQuestionServlet
 */
@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionBank qb = new QuestionBank();
		
		qb.setQuestion_text(request.getParameter("question_text"));
		
		HttpSession session = request.getSession(false);
		qb.setSubject((String)session.getAttribute("subject"));
		
		qb.setAnswer(request.getParameter("answer"));
		

		QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
		
		String target ="";
		
		
			boolean isAdded = daoimpl.AddQuestion(qb);
		   
			if(isAdded == true) {
				target = "QuestionBankServlet";
			}else {
				request.setAttribute("msg","Question could not be added");
				target = "/addQuestion.jsp";
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
			
		}
		
		
		
		
	}


