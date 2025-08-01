package com.demo.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.UserDao;
import com.demo.pojo.User;

public class UserDaoImpl  implements UserDao{

	Connection con = null;
	public UserDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acadisia?user=root&password=root");
		}catch(Exception e) {
			System.out.println("Error in loading driver and connection making");
		}	
	}
	@Override
	public User checkUser(User u) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo where email = ? and password = ?");
			
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == true) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				
				return user;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
	}
	@Override
	public boolean addUser(User u) {
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into userinfo values(?,?,?,?,?)");
			
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getRole());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
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
	public User getPassword(User u) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo where email =?");
			
			ps.setString(1, u.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == true) {
				User user = new User();
				
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				return user;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
	}
	@Override
	public List<User> getStudents(String role) {
		try {
			List<User> list  = new ArrayList<User>();
			
			if(role.equals("student")) {
				PreparedStatement ps = con.prepareStatement("select * from userinfo where role=? ");
				
				ps.setString(1, "student");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					User u = new User();
					
					u.setId(rs.getInt("id"));
					u.setEmail(rs.getString("email"));
					u.setName(rs.getString("name"));
					u.setRole(rs.getString("role"));
					
					list.add(u);
				}
			}else {
				PreparedStatement ps = con.prepareStatement("select * from userinfo");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					User u = new User();
					
					u.setId(rs.getInt("id"));
					u.setEmail(rs.getString("email"));
					u.setName(rs.getString("name"));
					u.setPassword(rs.getString("password"));
					u.setRole(rs.getString("role"));
					
					list.add(u);
				}
			}
			
			return list;
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
	}
	@Override
	public boolean deleteUser(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from userinfo where id = ?");
			
			ps.setInt(1, id);
			
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
	public User getUser(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			User u = new User();
			
			if(rs.next() == true) {
				u.setId(id);
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
			}else {
				return null;
			}
			
			return u;
		}catch(SQLException e) {
			System.out.println("Error in SQL Statement");
			return null;
		}
	}
	@Override
	public boolean updateUser(User u) {
		try {
			int x=0;
			if(u.getPassword() != null) {
				PreparedStatement ps = con.prepareStatement("update userinfo set name=?,email=?,password=?,role=? where id =?");
				
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setString(3,u.getPassword());
				ps.setString(4, u.getRole());
				ps.setInt(5, u.getId());
				
				x = ps.executeUpdate();
				
			}else {
				PreparedStatement ps = con.prepareStatement("update userinfo set name=?,email=?,role=? where id =?");
				
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getRole());
				ps.setInt(4, u.getId());
				
				x = ps.executeUpdate();
				
			}
			if (x>0) {
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
