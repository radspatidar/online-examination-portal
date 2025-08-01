package com.demo.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

import com.demo.dao.QuestionBankDao;
import com.demo.pojo.QuestionBank;
import com.mysql.cj.protocol.Resultset;

public class QuestionBankDaoImpl implements QuestionBankDao{
	
	Connection con = null;
	
	
	public QuestionBankDaoImpl() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acadisia?user=root&password=root");
		}catch(Exception e) {
			System.out.println("Error in loading Driver and making Connection"+e);
		}
	}


	@Override
	public List<QuestionBank> listOfAllQuestions(String subject) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from questionbank where subject=?");
			
            ps.setString(1, subject);
			
			ResultSet rs = ps.executeQuery();
			
			List<QuestionBank> list = new ArrayList<QuestionBank>();
			while(rs.next()) {
				
				QuestionBank qb = new QuestionBank();
				
				qb.setQuestion_id(rs.getInt("question_id"));
				qb.setQuestion_text(rs.getString("question_text"));
				qb.setAnswer(rs.getString("answer"));
				list.add(qb);
			}
			return list;
			
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
		
		
	}


	@Override
	public boolean AddQuestion(QuestionBank qb) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into questionbank (question_text, subject, answer) values (?,?,?)");
			
			ps.setString(1, qb.getQuestion_text());
			ps.setString(2, qb.getSubject());
			ps.setString(3, qb.getAnswer());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL statements" +e);
			return false;
		}
		
	}


	@Override
	public QuestionBank getQuestion(int question_id) {
		try {
			System.out.println("QBDIMpl");
			
			PreparedStatement ps = con.prepareStatement("select * from questionbank where question_id = ?");
			
			ps.setInt(1, question_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == true) {
				QuestionBank qb = new QuestionBank();	
				System.out.println(rs.getString("answer"));
				qb.setQuestion_id(rs.getInt("question_id"));
				qb.setQuestion_text(rs.getString("question_text"));
				qb.setAnswer(rs.getString("answer"));
				
				return qb;	
			}else {
				return null;
			}
			
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
		
	}


	@Override
	public boolean UpdateQuestion(QuestionBank qb) {
		try {
			PreparedStatement ps = con.prepareStatement("update questionbank set answer= ? where question_id = ?");
			
			ps.setString(1, qb.getAnswer());
			ps.setInt(2, qb.getQuestion_id());
			
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
	public boolean DeleteQuestion(int question_id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from questionbank where question_id=?");
			
			ps.setInt(1, question_id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL Satement"+e);
			return false;
		}
	
	}


	@Override
	public List<String> listOfAllSubjects(String table) {
		try {
			List<String> list = new ArrayList<String>();
			
			if(table.equals("questionbank")) {
				PreparedStatement ps = con.prepareStatement("select distinct subject from questionbank");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					String s = rs.getString("subject");
					
					list.add(s);
				}
				
			}else {
                PreparedStatement ps = con.prepareStatement("select distinct subject from quiz");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					String s = rs.getString("subject");
					
					list.add(s);
				}
			}
			return list;
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
		
	}


	@Override
	public boolean deleteQuestionBank(String subject) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from questionbank where subject = ?");
			
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
	
	
	
	

}
