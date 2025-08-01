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
import com.demo.pojo.QuestionBank;

@WebServlet("/QuestionBankServlet")
public class QuestionBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String link = request.getParameter("link");
		
		
		HttpSession session = request.getSession(false);
		
		QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
		
		
		if(link == null) {
			link = (String)session.getAttribute("subject");
		}
		
		session.setAttribute("subject", link);
		
		List<QuestionBank> list = new ArrayList<QuestionBank>();
        
	    list = daoimpl.listOfAllQuestions(link);
	    
	    session.setAttribute("list", list);
	    
	    String role = (String)session.getAttribute("role");
	    
	    if(role.equals("admin")) {
		   	RequestDispatcher rd = request.getRequestDispatcher("/aQuestions.jsp");
		    rd.forward(request, response);
		}else {
		  	RequestDispatcher rd = request.getRequestDispatcher("/sQuestions.jsp");
		    rd.forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		
		String btn = request.getParameter("btn");
		
		HttpSession session = request.getSession(false);
		if(subject == null) {
			subject = (String) session.getAttribute("subject");
		}else {
			session.setAttribute("subject", subject);
		}
	
		if(btn != null) {
			if(btn.equals("Add Questions")) {
				
				List<QuestionBank> list = new ArrayList<QuestionBank>();
				
				QuestionBank qb = new QuestionBank();
				
				qb.setSubject(subject);
				
				
				qb.setQuestion_text(request.getParameter("question_text"));
				
				qb.setAnswer(request.getParameter("answer"));
				
				list.add(qb);
				
				session.setAttribute("questions", list);
				
				request.setAttribute("msg", "isAdded");
				
				RequestDispatcher rd = request.getRequestDispatcher("/newQuestionBank.jsp");
	            rd.forward(request, response);
	            
			}else if(btn.equals("Add More Questions")) {
				List<QuestionBank> list = (List)session.getAttribute("questions");
				
				QuestionBank qb = new QuestionBank();
				
				qb.setSubject(subject);
				
				qb.setQuestion_text(request.getParameter("question_text"));
				
				qb.setAnswer(request.getParameter("answer"));
				
				list.add(qb);
				
				session.setAttribute("questions", list);
				
				request.setAttribute("msg", "isAdded");
				
				RequestDispatcher rd = request.getRequestDispatcher("/newQuestionBank.jsp");
	            rd.forward(request, response);
	            
			}else if(btn.equals("Create QuestionBank")) {
				List<QuestionBank> list = (List)session.getAttribute("questions");
				
				if(list == null) {
					 list = new ArrayList<QuestionBank>();
				}
				
				QuestionBank qb = new QuestionBank();
				
				qb.setSubject(subject);
				
				qb.setQuestion_text(request.getParameter("question_text"));
				
				qb.setAnswer(request.getParameter("answer"));
				
				list.add(qb);
				
				QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
				
				boolean isDone = true;
				int i = 0;
                while (i < list.size()) {
                	QuestionBank qb1 = new QuestionBank();
                	qb1 = list.get(i);
                	
                	boolean isAdded = daoimpl.AddQuestion(qb1);
         		   
        			if(isAdded == true) {
        				list.remove(i);
        				i++;	
        			}else {
        				isDone = false;
        			}
                }
                if(isDone == true) {
                	request.setAttribute("link", "questionbank");
                	RequestDispatcher rd = request.getRequestDispatcher("/SubjectServlet");
    	            rd.forward(request, response);
                }else {
                	System.out.println("Error");
                }
                    
				
			}
			
		}else {
			QuestionBankDaoImpl daoimpl = new QuestionBankDaoImpl();
	        List<QuestionBank> list = new ArrayList<QuestionBank>();
	        
	        list = daoimpl.listOfAllQuestions(subject);
	        
	        session.setAttribute("list", list);
	        
	        String role = (String)session.getAttribute("role");
	        
	        if(role.equals("admin")) {
	        	RequestDispatcher rd = request.getRequestDispatcher("/aQuestions.jsp");
	            rd.forward(request, response);
	        }else {
	        	RequestDispatcher rd = request.getRequestDispatcher("/sQuestions.jsp");
	            rd.forward(request, response);
	        }
	        
		}
		 
	}


}
