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
 * Servlet implementation class EditQuestionServlet
 */
@WebServlet("/EditQuestionServlet")
public class EditQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int question_id = 0;
		try{
			question_id = Integer.parseInt(request.getParameter("question_id"));
		}catch(NumberFormatException e) {
			System.out.println("Invalid input");
		}
		
		String delete = request.getParameter("delete");
		
		
		QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
		
		String target = "";
		
		if(delete != null) {
			
			boolean isDeleted = daoimpl.DeleteQuestion(question_id);
			
			if(isDeleted == true) {
				target = "/QuestionBankServlet";
			}else {
				System.out.println("Error");
			}
			
		}else{
			QuestionBank qb = daoimpl.getQuestion(question_id);
			
			if(qb != null) {
				request.setAttribute("qb", qb);
				target = "/editQuestion.jsp";
			}else {
				System.out.println("Error");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         QuestionBank qb = new QuestionBank();
		
         try {
        	 qb.setQuestion_id(Integer.parseInt(req.getParameter("question_id")));
         }catch(NumberFormatException e) {
        	 System.out.println("Invalid Input");
         }
         
		qb.setQuestion_text(req.getParameter("question_text"));
		
		HttpSession session = req.getSession(false);
		qb.setSubject((String)session.getAttribute("subject"));
		
		qb.setAnswer(req.getParameter("answer"));
		

		QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
		
		String target ="";
						
		boolean isUpdated = daoimpl.UpdateQuestion(qb);
		
		if(isUpdated == true) {
			target = "/QuestionBankServlet";
		}else {
			req.setAttribute("msg","Question could not be updated");
			target = "/editQuestion.jsp";
		}
	   
		RequestDispatcher rd = req.getRequestDispatcher(target);
		rd.forward(req, resp);
	}

	
}
