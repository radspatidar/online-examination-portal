package com.demo.pojo;

public class QuestionBank {
	
	private int question_id;
	private String question_text;
	private String subject;
	private String answer;
	
	public QuestionBank() {
		super();
		// TODO Auto-generated constructor stub
	
	}

	public QuestionBank(int question_id, String question_text, String subject, String answer) {
		super();
		this.question_id = question_id;
		this.question_text = question_text;
		this.subject = subject;
		this.answer = answer;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_text() {
		return question_text;
	}

	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	public String getFormattedQuestion() {
	    // Split by newline character
	    String[] lines = this.question_text.split("\\n");
	    StringBuilder formatted = new StringBuilder();

	    for (String line : lines) {
	        formatted.append(line.trim()).append("\n");
	    }

	    return formatted.toString();
	}
	
	
	
	
}
