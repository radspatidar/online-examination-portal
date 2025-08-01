package com.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.pojo.Quiz;
import com.demo.pojo.User;

public interface QuizDao {
	
	List<Quiz> listOfAllQuestions(String subject);
	
	boolean addSelectedAnswers(Map<Integer, String> resMap,List<Quiz> list, String name, String email,String subject);
	
	boolean DeleteQuestion(String question);
	
	boolean deleteQuiz(String subject);
	
	Quiz getQuestion(String question);
	
	boolean updateQuestion(Quiz q);
	
	boolean addQuestion(Quiz q);
	
	List<Quiz> getResult(String subject,String email);
	
	Map<User, ArrayList<String>> getSubjects(List<User> list);
}
