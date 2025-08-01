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

import com.demo.daoimpl.QuizDaoImpl;
import com.demo.pojo.Quiz;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuizDaoImpl daoimpl = new QuizDaoImpl();
		
		HttpSession session1 = request.getSession(false);
		
		
		String email = request.getParameter("email");
		
		if(email == null) {
			email =(String)session1.getAttribute("email");
		}
		
		String subject = request.getParameter("subject");
		
		if(subject == null) {
			subject = (String)session1.getAttribute("quizsubject");
		}
		
		
		List<Quiz> list = new ArrayList<Quiz>();
		
        
        list = daoimpl.getResult(subject,email);
        
        String req = request.getParameter("req");
        
        if(req == null) {
        	request.setAttribute("req","report");
        }else {
        	request.setAttribute("req",req);
        }
        request.setAttribute("result", list);
        
        RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
	    
        rd.forward(request, response);  
		
	}

}
