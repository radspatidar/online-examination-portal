package com.demo.pojo;

public class Quiz {
	
	private int id;
	private int question_id;
	private String name;
	private String email;
	private String subject;
	private String question;
	private String option_a;
	private String option_b;
	private String option_c;
	private String option_d;
	private String correct_answer;
	private String selected_answer;
	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(int id, int question_id, String name, String email, String subject, String question, String option_a,
			String option_b, String option_c, String option_d, String correct_answer, String selected_answer) {
		super();
		this.id = id;
		this.question_id = question_id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.question = question;
		this.option_a = option_a;
		this.option_b = option_b;
		this.option_c = option_c;
		this.option_d = option_d;
		this.correct_answer = correct_answer;
		this.selected_answer = selected_answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption_a() {
		return option_a;
	}

	public void setOption_a(String option_a) {
		this.option_a = option_a;
	}

	public String getOption_b() {
		return option_b;
	}

	public void setOption_b(String option_b) {
		this.option_b = option_b;
	}

	public String getOption_c() {
		return option_c;
	}

	public void setOption_c(String option_c) {
		this.option_c = option_c;
	}

	public String getOption_d() {
		return option_d;
	}

	public void setOption_d(String option_d) {
		this.option_d = option_d;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public String getSelected_answer() {
		return selected_answer;
	}

	public void setSelected_answer(String selected_answer) {
		this.selected_answer = selected_answer;
	}
	
	
	
	
}
