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

import com.demo.daoimpl.QuizDaoImpl;
import com.demo.pojo.Quiz;

/**
 * Servlet implementation class SQuizServlet
 */
@WebServlet("/SQuizServlet")
public class SQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Integer, String> resMap = new LinkedHashMap<Integer, String>();
		
		HttpSession session1 = request.getSession(false);
		
		
		String name = (String)session1.getAttribute("name");
		
		String email =(String)session1.getAttribute("email");
		
		String subject = (String)session1.getAttribute("quizsubject");
		
		List<Quiz> list = new ArrayList<Quiz>();
		
        list = (List)session1.getAttribute("quizlist");
        
        int i = 0;
        while (i < list.size()) {
        	
            Quiz q = list.get(i);
          
            resMap.put(q.getId(), request.getParameter(String.valueOf(q.getId())));
            i++;
        
        }
        int totalMarks = i;
        
        int marks = 0;
        
        i = 0;
        while (i < list.size()) {
        	
            Quiz q = list.get(i);
            
            String selected_answer = resMap.get(q.getId()); 
            
            String correct_answer = q.getCorrect_answer();
            
            if(selected_answer.equals(correct_answer) ) {
            	marks++;
            }
            i++;
        }
        
        
        QuizDaoImpl daoimpl = new QuizDaoImpl();
        
        boolean isAdded = daoimpl.addSelectedAnswers(resMap, list ,name,email,subject); 
        
        if(isAdded == true) {
        	request.setAttribute("marks", marks);
        	
        	request.setAttribute("totalMarks", totalMarks);
        	RequestDispatcher rd = request.getRequestDispatcher("/sQuiz.jsp");
	        rd.forward(request, response);
        }else {
        	System.out.println("Error"); 
        }
        
        
	}

}
