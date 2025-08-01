package com.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String link = request.getParameter("link");
		
		HttpSession session = request.getSession(false);
		
		if(link == null) {
			link = (String)session.getAttribute("quizsubject");
		}
		
		session.setAttribute("quizsubject", link);
		
		List<Quiz> list = new ArrayList<Quiz>();
		
		QuizDaoImpl daoimpl = new QuizDaoImpl();	
		
		list = daoimpl.listOfAllQuestions(link);
			
		session.setAttribute("quizlist", list);
			
		String role = (String)session.getAttribute("role");
		    
		if(role.equals("admin")) {
	     	RequestDispatcher rd = request.getRequestDispatcher("/aQuiz.jsp");
	        rd.forward(request, response);
	    }else {
	    	RequestDispatcher rd = request.getRequestDispatcher("/sQuiz.jsp");
	        rd.forward(request, response);
	   }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String subject = request.getParameter("subject");
		
		String btn = request.getParameter("btn");
		
		HttpSession session = request.getSession(false);
		if(subject == null) {
			subject = (String) session.getAttribute("quizsubject");
		}else {
			session.setAttribute("quizsubject", subject);
		}
	
		if(btn != null) {
			if(btn.equals("Add Questions")) {
				
				List<Quiz> list = new ArrayList<Quiz>();
				
				Quiz q = new Quiz();
				
				q.setSubject(subject);
				
				q.setQuestion(request.getParameter("question"));
				
				q.setOption_a(request.getParameter("option_a"));
				
				q.setOption_b(request.getParameter("option_b"));
				
				q.setOption_c(request.getParameter("option_c"));
				
				q.setOption_d(request.getParameter("option_d"));
				
				q.setCorrect_answer(request.getParameter("correct_answer"));
				
				list.add(q);
				
				session.setAttribute("quizquestions", list);
				
				request.setAttribute("msg", "isAdded");
				
				RequestDispatcher rd = request.getRequestDispatcher("/newQuiz.jsp");
	            rd.forward(request, response);
	            
			}else if(btn.equals("Add More Questions")) {
				List<Quiz> list = (List)session.getAttribute("quizquestions");
				
				Quiz q = new Quiz();
				
				q.setSubject(subject);
				
				q.setQuestion(request.getParameter("question"));
				
				q.setOption_a(request.getParameter("option_a"));
				
				q.setOption_b(request.getParameter("option_b"));
				
				q.setOption_c(request.getParameter("option_c"));
				
				q.setOption_d(request.getParameter("option_d"));
				
				q.setCorrect_answer(request.getParameter("correct_answer"));
				
				list.add(q);
				
				session.setAttribute("quizquestions", list);
				
				request.setAttribute("msg", "isAdded");
				
				RequestDispatcher rd = request.getRequestDispatcher("/newQuiz.jsp");
	            rd.forward(request, response);
	            
			}else if(btn.equals("Create Quiz")) {
				
				List<Quiz> list = (List)session.getAttribute("quizquestions");
				
				if(list == null) {
					 list = new ArrayList<Quiz>();
				}
				
				Quiz q = new Quiz();
				
				q.setSubject(subject);
				
				q.setQuestion(request.getParameter("question"));
				
				q.setOption_a(request.getParameter("option_a"));
				
				q.setOption_b(request.getParameter("option_b"));
				
				q.setOption_c(request.getParameter("option_c"));
				
				q.setOption_d(request.getParameter("option_d"));
				
				q.setCorrect_answer(request.getParameter("correct_answer"));
				
				list.add(q);
				
				QuizDaoImpl daoimpl = new QuizDaoImpl();
				
				boolean isDone = true;
				int i = 0;
                while (i < list.size()) {
                	Quiz q1 = new Quiz();
                	q1 = list.get(i);
                	
                	boolean isAdded = daoimpl.addQuestion(q1);
         		   
        			if(isAdded == true) {
        				list.remove(i);
        				i++;	
        			}else {
        				isDone = false;
        			}
                }
                
                if(isDone == true) {
                	request.setAttribute("link", "quiz");
                	RequestDispatcher rd = request.getRequestDispatcher("/SubjectServlet");
    	            rd.forward(request, response);
                }else {
                	System.out.println("Error");
                }
           	
			}
			
		}else {
			QuizDaoImpl daoimpl = new QuizDaoImpl();
	        List<Quiz> list = new ArrayList<Quiz>();
	        
	        list = daoimpl.listOfAllQuestions(subject);
	        
	        session.setAttribute("quizlist", list);
	        
	        String role = (String)session.getAttribute("role");
	        
	        if(role.equals("admin")) {
	        	RequestDispatcher rd = request.getRequestDispatcher("/aQuiz.jsp");
	            rd.forward(request, response);
	        }else {
	        	RequestDispatcher rd = request.getRequestDispatcher("/sQuiz.jsp");
	            rd.forward(request, response);
	        }
	        
		}
		 
	}
		
}



