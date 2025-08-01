package com.demo.dao;

import java.util.List;

import com.demo.pojo.QuestionBank;

public interface QuestionBankDao {
	List<QuestionBank> listOfAllQuestions(String link);
	List<String> listOfAllSubjects(String table);
	boolean AddQuestion(QuestionBank qb);
	boolean UpdateQuestion(QuestionBank qb);
	boolean DeleteQuestion(int question_id);
	boolean deleteQuestionBank(String subject);
	QuestionBank getQuestion(int question_id);
}

