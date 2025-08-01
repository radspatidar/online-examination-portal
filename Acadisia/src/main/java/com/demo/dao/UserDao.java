package com.demo.dao;

import java.util.List;

import com.demo.pojo.User;

public interface UserDao {
	User checkUser(User u);
	boolean addUser(User u);
	User getPassword(User u);
	List<User> getStudents(String role);
	boolean deleteUser(int id);
	User getUser(int id);
	boolean updateUser(User u);
}
