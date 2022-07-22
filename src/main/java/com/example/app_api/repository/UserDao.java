package com.example.app_api.repository;

import java.util.List;

import com.example.app_api.dto.User;

public interface UserDao {
	public User createUser( User user);
	public User getUser(Long userId);
	public List<User> getAllUser();
}
