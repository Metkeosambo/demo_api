package com.example.app_api.service;

import java.util.List;

import com.example.app_api.dto.User;

public interface UserService {
	public User createUser( User user);
	
	public User getUser(Long userId);
	
	public List<User> getAllUser();
}
