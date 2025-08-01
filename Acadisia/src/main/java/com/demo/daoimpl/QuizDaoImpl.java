package com.demo.daoimpl;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyPermission;

import javax.servlet.http.HttpSession;

import com.demo.dao.QuizDao;
import com.demo.pojo.QuestionBank;
import com.demo.pojo.Quiz;
import com.demo.pojo.User;

public class QuizDaoImpl implements QuizDao {

    Connection con = null;
	
	
	public QuizDaoImpl() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acadisia?user=root&password=root");
		}catch(Exception e) {
			System.out.println("Error in loading Driver and making Connection"+e);
		}
	}


	@Override
	public List<Quiz> listOfAllQuestions(String subject) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from quiz where subject=?");
			
            ps.setString(1, subject);
			
			ResultSet rs = ps.executeQuery();
			
			List<Quiz> list = new ArrayList<Quiz>();
			
			while(rs.next()) {
				
				Quiz q = new Quiz();
				
				q.setId(rs.getInt("id"));
				q.setQuestion(rs.getString("question"));
				q.setOption_a(rs.getString("option_a"));
				q.setOption_b(rs.getString("option_b"));
				q.setOption_c(rs.getString("option_c"));
				q.setOption_d(rs.getString("option_d"));
				q.setCorrect_answer(rs.getString("correct_answer"));
				
				list.add(q);
			}
			return list;
			
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement" + e);
			return null;
		}
		
	}


	@Override
	public boolean addSelectedAnswers(Map<Integer, String> resMap, List<Quiz> list, String name, String email,String subject) {
		try {
			
			PreparedStatement ps1 = con.prepareStatement("select * from result where email=? and subject=?");
			
			ps1.setString(1, email);
			ps1.setString(2, subject);
			
			ResultSet rs = ps1.executeQuery();
			
			boolean isAdded = true;
			
			if(rs.next() == true) {
				

				int i = 0;
				while(i < list.size()) {
					Quiz q = list.get(i);
					
					PreparedStatement ps = con.prepareStatement("update result set question=?, option_a=?, option_b=?, option_c=?, option_d=?, selected_answer=?, correct_answer=? where email=? and subject=? and question_id=?");
					
					ps.setString(1, q.getQuestion());
					ps.setString(2, q.getOption_a());
					ps.setString(3, q.getOption_b());
					ps.setString(4, q.getOption_c());
					ps.setString(5, q.getOption_d());
					ps.setString(6, resMap.get(q.getId()));
					ps.setString(7, q.getCorrect_answer());
					ps.setString(8, email);
					ps.setString(9, subject);
					ps.setInt(10, q.getId());
					
					int x = ps.executeUpdate();
					
					if(x>0) {
						isAdded = true;
					}else {
						isAdded = false;
					}
					
					i++;
				}
				
			}else {
				
				int i = 0;
				while(i < list.size()) {
					Quiz q = list.get(i);
					
					PreparedStatement ps = con.prepareStatement("insert into result (email, name, question_id, question, option_a, option_b, option_c, option_d, selected_answer, correct_answer, subject) values (?,?,?,?,?,?,?,?,?,?,?) ");
					
					ps.setString(1, email);
					ps.setString(2, name);
					ps.setInt(3, q.getId());
					ps.setString(4, q.getQuestion());
					ps.setString(5, q.getOption_a());
					ps.setString(6, q.getOption_b());
					ps.setString(7, q.getOption_c());
					ps.setString(8, q.getOption_d());
					ps.setString(9, resMap.get(q.getId()));
					ps.setString(10, q.getCorrect_answer());
					ps.setString(11, subject);
					
					int x = ps.executeUpdate();
					
					if(x>0) {
						isAdded = true;
					}else {
						isAdded = false;
					}
					i++;
				}
			}
			System.out.println(isAdded);
			if(isAdded == true) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return false;
		}
	}


	@Override
	public boolean DeleteQuestion(String question) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from quiz where question=?");
			
			ps.setString(1, question);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL Satement");
			return false;
		}
	
	}


	@Override
	public Quiz getQuestion(String question) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from quiz where question = ?");
			
			ps.setString(1, question);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == true) {
				Quiz q = new Quiz();
				
				q.setId(rs.getInt("id"));
				q.setQuestion(rs.getString("question"));
				q.setOption_a(rs.getString("option_a"));
				q.setOption_b(rs.getString("option_b"));
				q.setOption_c(rs.getString("option_c"));
				q.setOption_d(rs.getString("option_d"));
				q.setCorrect_answer(rs.getString("correct_answer"));
				
				return q;	
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
		
	}


	@Override
	public boolean updateQuestion(Quiz q) {
		try {
			PreparedStatement ps = con.prepareStatement("update quiz set question= ?,option_a =?, option_b=?, option_c=?, option_d =?,correct_answer=? where id = ?");
			
			ps.setString(1, q.getQuestion());
			ps.setString(2, q.getOption_a());
			ps.setString(3, q.getOption_b());
			ps.setString(4, q.getOption_c());
			ps.setString(5, q.getOption_d());
			ps.setString(6, q.getCorrect_answer());
			ps.setInt(7, q.getId());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL statements");
			return false;
		}
		
	}


	@Override
	public boolean addQuestion(Quiz q) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into quiz (subject, question, option_a , option_b, option_c, option_d, correct_answer) values (?,?,?,?,?,?,?)");
			
			ps.setString(1, q.getSubject());
			ps.setString(2, q.getQuestion());
			ps.setString(3, q.getOption_a());
			ps.setString(4, q.getOption_b());
			ps.setString(5, q.getOption_c());
			ps.setString(6, q.getOption_d());
			ps.setString(7, q.getCorrect_answer());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL statements");
			return false;
		}
	}


	@Override
	public List<Quiz> getResult(String subject,String email) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from result where email=? and subject =?");
			
			ps.setString(1, email);
			ps.setString(2, subject);
			
			ResultSet rs = ps.executeQuery();
			
			List<Quiz> list = new ArrayList<Quiz>();
			
			while(rs.next()) {
				Quiz q = new Quiz();
				
				q.setName(rs.getString("name"));
				q.setEmail(rs.getString("email"));
				q.setQuestion_id(rs.getInt("question_id"));
				q.setQuestion(rs.getString("question"));
				q.setOption_a(rs.getString("option_a"));
				q.setOption_b(rs.getString("option_b"));
				q.setOption_c(rs.getString("option_c"));
				q.setOption_d(rs.getString("option_d"));
				q.setSelected_answer(rs.getString("selected_answer"));
				q.setCorrect_answer(rs.getString("correct_answer"));
				q.setSubject(rs.getString("subject"));
				
				list.add(q);
			}
			
			return list;
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
		
	}


	@Override
	public boolean deleteQuiz(String subject) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from quiz where subject = ?");
			
			ps.setString(1, subject);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return false;
		}
	}


	@Override
	public Map<User, ArrayList<String>> getSubjects(List<User> list) {
		try {
			Map<User, ArrayList<String>> map = new LinkedHashMap();
			int i =0;
			while(i< list.size()) {
				
				User u = list.get(i);
				PreparedStatement ps = con.prepareStatement("select distinct subject from result where email=?");
				
				ps.setString(1, u.getEmail());
				
				ResultSet rs = ps.executeQuery();
				
				ArrayList<String> subject = new ArrayList<>();
				
				while(rs.next()) {
					
					subject.add(rs.getString("subject"));
					
				}
				
				map.put(u, subject);
				
				i++;
			}
			return map;
			
		}catch(SQLException e) {
			System.out.println("error in sql statement");
			return null;
		}
	}
	
	
	
	
	

}
